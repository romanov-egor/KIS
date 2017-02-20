package ru.ifmo.documentautomation.portlet.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.ifmo.srv.model.WorkflowDocument;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;

public class WorkflowDocumentsList {
	@SuppressWarnings("unused")
	private static final Log log = LogFactoryUtil.getLog(WorkflowDocumentsList.class);
	
	private HashMap<String, List<WorkflowDocument>> documentsByTaskName = new HashMap<String, List<WorkflowDocument>>();
	private List<String> taskNames;
	private HashMap<WorkflowDocument, WorkflowTask> documentTaskMap = new HashMap<WorkflowDocument, WorkflowTask>();
	private long companyId;
	private long userId;
	
	public WorkflowDocumentsList(long companyId, long userId, List<String> taskNames) {
		this.companyId = companyId;
		this.userId = userId;
		this.taskNames = taskNames;
		for (String taskName : taskNames) {
			documentsByTaskName.put(taskName, new ArrayList<WorkflowDocument>());
		}
	}

	public List<String> getTaskNames() {
		return taskNames;
	}
	
	public String getTabNames() {
		return StringUtil.merge(taskNames.toArray(), ",");
	}
	
	public List<WorkflowDocument> getWorkflowDocumentsByTaskName(String taskName) {
		return documentsByTaskName.get(taskName);
	}
	
	public WorkflowTask getTaskByWorkflowDocument(WorkflowDocument document) {
		return documentTaskMap.get(document);
	}
	
	public List<String> getNextTransitionNamesByWorkflowDocument(WorkflowDocument document) {
		WorkflowTask wt = documentTaskMap.get(document);
		List<String> transitionNames = new ArrayList<String>();
		try {
			transitionNames = WorkflowTaskManagerUtil.getNextTransitionNames(companyId, userId, wt.getWorkflowTaskId());
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
		return transitionNames;
	}

	public WorkflowDocument putWorkflowDocumentAssignedToTask(WorkflowTask wt, WorkflowDocument document) {
		List<WorkflowDocument> documents = documentsByTaskName.get(wt.getName());
		documents.add(document);
		documentTaskMap.put(document, wt);
		return document;
	}
}
