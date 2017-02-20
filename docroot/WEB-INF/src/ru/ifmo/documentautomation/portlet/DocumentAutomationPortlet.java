package ru.ifmo.portlet;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import ru.ifmo.model.Document;
import ru.ifmo.portlet.model.DocumentCollectionModel;
import ru.ifmo.service.DocumentLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowDefinitionManager;
import com.liferay.portal.kernel.workflow.WorkflowDefinitionManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskAssignee;
import com.liferay.portal.kernel.workflow.WorkflowTaskManager;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.model.WorkflowDefinitionLink;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.service.persistence.WorkflowDefinitionLinkUtil;
import com.liferay.portal.service.persistence.WorkflowInstanceLinkUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DocumentAutomation
 */
public class DocumentAutomation extends MVCPortlet {
	
	private static String WORKFLOW_NAME = "Document Automation Process";
	private static int WORKFLOW_VERSION = 5;
	
	@Override
	public void render (RenderRequest renderRequest, RenderResponse renderResponse) 
	        throws PortletException, IOException {
		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Document.class.getName(), renderRequest);
			long companyId = serviceContext.getCompanyId();
			long groupId = serviceContext.getScopeGroupId();
			long userId = serviceContext.getUserId();
			
			WorkflowDefinition wd = WorkflowDefinitionManagerUtil.getWorkflowDefinition(companyId, WORKFLOW_NAME, WORKFLOW_VERSION);
			List<String> allTaskNames = getAllWorkflowTasks(wd);
			DocumentCollectionModel documents = new DocumentCollectionModel(companyId, userId, allTaskNames);
			
			List<WorkflowTask> wtList = WorkflowTaskManagerUtil.getWorkflowTasksByUser(companyId, userId, false, 
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			wtList.addAll(WorkflowTaskManagerUtil.getWorkflowTasksByUserRoles(companyId, userId, false, 
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null));
			
			for (WorkflowTask wt : wtList) {
				WorkflowInstance wi = WorkflowInstanceManagerUtil.getWorkflowInstance(serviceContext.getCompanyId(), wt.getWorkflowInstanceId());
				Map<String, Serializable> wc = wi.getWorkflowContext();
				long classPK = GetterUtil.getLong((String) wc.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
				
				documents.putDocumentAssignedToTask(wt, DocumentLocalServiceUtil.getDocument(classPK));
			}
			
			renderRequest.setAttribute("documents", documents);
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    super.render(renderRequest, renderResponse);

	}
	
	public void addDocument(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Document.class.getName(), request);

	    String title = ParamUtil.getString(request, "title");
	    String description = ParamUtil.getString(request, "description");
	    String filePath = ParamUtil.getString(request, "filePath");

	    try {
	    	long dlDocumentId = saveDocument(filePath, request);
	    	
	        Document document = DocumentLocalServiceUtil.addDocument(serviceContext.getUserId(), title, description, dlDocumentId, serviceContext);
	        
			WorkflowHandlerRegistryUtil.startWorkflowInstance(serviceContext.getCompanyId(), serviceContext.getUserId(), Document.class.getName(), 
					document.getPrimaryKey(), document, serviceContext);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public void completeTask(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Document.class.getName(), request);
		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

	    long workflowTaskId = ParamUtil.getLong(request, "workflowTaskId");
	    String transitionName = ParamUtil.getString(request, "transitionName");
	    
	    WorkflowTask wt = WorkflowTaskManagerUtil.getWorkflowTask(companyId, workflowTaskId);
	    WorkflowInstance wi = WorkflowInstanceManagerUtil.getWorkflowInstance(serviceContext.getCompanyId(), wt.getWorkflowInstanceId());
	    
	    //Role role = RoleLocalServiceUtil.getRole(companyId, "Site Documents Reviewer");
	    //WorkflowTaskManagerUtil.assignWorkflowTaskToRole(companyId, userId, workflowTaskId, role.getPrimaryKey(), "", null, wi.getWorkflowContext());
	    
	    //WorkflowTaskManagerUtil.assignWorkflowTaskToUser(companyId, userId, workflowTaskId, userId, "", null, wi.getWorkflowContext());
	    WorkflowTaskManagerUtil.completeWorkflowTask(companyId, userId, workflowTaskId, transitionName, "", wi.getWorkflowContext());
	}
	
	
	private List<String> getAllWorkflowTasks(WorkflowDefinition workflowDefinition) throws ParserConfigurationException, SAXException, IOException {
		ArrayList<String> taskNames = new ArrayList<String>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(workflowDefinition.getContent()));
		org.w3c.dom.Document workflowContent = builder.parse(is);
		
		NodeList tasks = workflowContent.getElementsByTagName("task");
		for (int i = 0; i < tasks.getLength(); i++) {
			Element task = (Element) tasks.item(i);
			taskNames.add(task.getElementsByTagName("name").item(0).getTextContent());
		}
		return taskNames;
	}
	
	private long saveDocument(String filePath, ActionRequest request) {
		return 0;
	}

}
