package ru.ifmo.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import ru.ifmo.model.Document;
import ru.ifmo.service.DocumentLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;

public class DocumentWorkflowHandler extends BaseWorkflowHandler {

	@Override
	public String getClassName() {
		return Document.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public Object updateStatus(int status, Map<String, Serializable> workflowContext) 
			throws PortalException, SystemException {
		long userId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long documentId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		ServiceContext serviceContext = (ServiceContext)workflowContext.get("serviceContext");
		return DocumentLocalServiceUtil.updateStatus(userId, documentId, status, serviceContext);
	}

}
