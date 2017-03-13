package ru.ifmo.documentautomation.portlet;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ru.ifmo.documentautomation.portlet.model.WorkflowDocumentsList;
import ru.ifmo.srv.model.WorkflowDocument;
import ru.ifmo.srv.service.WorkflowDocumentLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowDefinitionManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.ServiceContextUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DocumentAutomationPortlet
 */
public class DocumentAutomationPortlet extends MVCPortlet {

	private static final String WORKFLOW_NAME = "Document Automation Process";
	private static final int WORKFLOW_VERSION = 1;
	private static final String WORKFLOW_DOCUMENT_CLASS_NAME = WorkflowDocument.class
			.getName();

	private static final Log log = LogFactoryUtil
			.getLog(DocumentAutomationPortlet.class);

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		long userId = themeDisplay.getUserId();

		try {
			WorkflowDefinition workflowDefinition = WorkflowDefinitionManagerUtil
					.getWorkflowDefinition(companyId, WORKFLOW_NAME,
							WORKFLOW_VERSION);
			List<String> allTaskNames = getAllWorkflowTasks(workflowDefinition);
			WorkflowDocumentsList documents = new WorkflowDocumentsList(
					companyId, userId, allTaskNames);

			List<WorkflowTask> workflowTasks = WorkflowTaskManagerUtil
					.getWorkflowTasksByUser(companyId, userId, false,
							QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			workflowTasks.addAll(WorkflowTaskManagerUtil
					.getWorkflowTasksByUserRoles(companyId, userId, false,
							QueryUtil.ALL_POS, QueryUtil.ALL_POS, null));

			for (WorkflowTask workflowTask : workflowTasks) {
				WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
						.getWorkflowInstance(companyId,
								workflowTask.getWorkflowInstanceId());
				Map<String, Serializable> workflowContext = workflowInstance
						.getWorkflowContext();
				long classPK = GetterUtil.getLong((String) workflowContext
						.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
				log.info("ClassPk variable is : " + classPK);
				
				WorkflowDocument document = WorkflowDocumentLocalServiceUtil
						.getWorkflowDocument(classPK);
				log.info("Document : " + document.getTitle() + "; status : "
						+ document.getStatus() + "; task : " + workflowTask.getName());
				documents.putWorkflowDocumentAssignedToTask(workflowTask, document);
			}

			renderRequest.setAttribute("documents", documents);
		} catch (SystemException | PortalException
				| ParserConfigurationException | SAXException e) {
			log.error(e.getMessage());
		}

		super.render(renderRequest, renderResponse);
	}

	public void addDocument(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				WORKFLOW_DOCUMENT_CLASS_NAME, request);

		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		long userId = themeDisplay.getUserId();

		String title = ParamUtil.getString(request, "title");
		String description = ParamUtil.getString(request, "description");
		String filePath = ParamUtil.getString(request, "filePath");

		try {
			long dlDocumentId = saveDocument(filePath, request);

			WorkflowDocument document = WorkflowDocumentLocalServiceUtil
					.addDocument(userId, title, description, dlDocumentId,
							serviceContext);

			WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId,
					userId, WORKFLOW_DOCUMENT_CLASS_NAME,
					document.getDocumentId(), document, serviceContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void completeTask(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				WORKFLOW_DOCUMENT_CLASS_NAME, request);
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();

		long workflowTaskId = ParamUtil.getLong(request, "workflowTaskId");
		String transitionName = ParamUtil.getString(request, "transitionName");

		WorkflowTask wt = WorkflowTaskManagerUtil.getWorkflowTask(companyId,
				workflowTaskId);
		WorkflowInstance wi = WorkflowInstanceManagerUtil.getWorkflowInstance(
				serviceContext.getCompanyId(), wt.getWorkflowInstanceId());

		/*
		 * Role role = RoleLocalServiceUtil.getRole(companyId,
		 * "Site Documents Reviewer");
		 * WorkflowTaskManagerUtil.assignWorkflowTaskToRole(companyId, userId,
		 * workflowTaskId, role.getPrimaryKey(), "", null,
		 * wi.getWorkflowContext());
		 * 
		 * WorkflowTaskManagerUtil.assignWorkflowTaskToUser(companyId, userId,
		 * workflowTaskId, userId, "", null, wi.getWorkflowContext());
		 */

		WorkflowTaskManagerUtil.completeWorkflowTask(companyId, userId,
				workflowTaskId, transitionName, "", wi.getWorkflowContext());
	}

	private List<String> getAllWorkflowTasks(
			WorkflowDefinition workflowDefinition)
			throws ParserConfigurationException, SAXException, IOException {
		ArrayList<String> taskNames = new ArrayList<String>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(
				workflowDefinition.getContent()));
		org.w3c.dom.Document workflowContent = builder.parse(is);

		NodeList tasks = workflowContent.getElementsByTagName("task");
		for (int i = 0; i < tasks.getLength(); i++) {
			Element task = (Element) tasks.item(i);
			taskNames.add(task.getElementsByTagName("name").item(0)
					.getTextContent());
		}
		return taskNames;
	}

	private long saveDocument(String filePath, ActionRequest request) {
		return 0;
	}

}
