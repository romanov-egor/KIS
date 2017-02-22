package ru.ifmo.portlet.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;

import ru.ifmo.model.Document;

public class DocumentCollectionModel {
	private HashMap<String, List<Document>> documentsByTaskName = new HashMap<String, List<Document>>();
	private List<String> taskNames;
	private HashMap<Document, WorkflowTask> document_task = new HashMap<Document, WorkflowTask>();
	private long companyId;
	private long userId;
	
	public DocumentCollectionModel(long companyId, long userId, List<String> taskNames) {
		this.companyId = companyId;
		this.userId = userId;
		this.taskNames = taskNames;
		for (String taskName : taskNames) {
			documentsByTaskName.put(taskName, new ArrayList<Document>());
		}
	}

	public List<String> getTaskNames() {
		return taskNames;
	}
	
	public String getTabNames() {
		return StringUtil.merge(taskNames.toArray(), ",");
	}
	
	public List<Document> getDocumentsByTaskName(String taskName) {
		return documentsByTaskName.get(taskName);
	}
	
	public WorkflowTask getTaskByDocument(Document document) {
		return document_task.get(document);
	}
	
	public Document getDocumentById(long documentId) {
		Set<Document> documents = document_task.keySet();
		for (Document document : documents) {
			if (document.getDocumentId() == documentId) {
				return document;
			}
		}
		return null;
	}
	
	public List<String> getNextTransitionNamesByDocument(Document document) {
		WorkflowTask wt = document_task.get(document);
		List<String> transitionNames = new ArrayList<String>();
		try {
			transitionNames = WorkflowTaskManagerUtil.getNextTransitionNames(companyId, userId, wt.getWorkflowTaskId());
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
		return transitionNames;
	}

	public Document putDocumentAssignedToTask(WorkflowTask wt, Document document) {
		List<Document> documents = documentsByTaskName.get(wt.getName());
		documents.add(document);
		
		document_task.put(document, wt);
		return document;
	}
}
