/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ru.ifmo.srv.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.UserUtil;

import ru.ifmo.srv.NoSuchWorkflowDocumentException;
import ru.ifmo.srv.model.WorkflowDocument;
import ru.ifmo.srv.service.base.WorkflowDocumentLocalServiceBaseImpl;
import ru.ifmo.srv.service.persistence.WorkflowDocumentUtil;

/**
 * The implementation of the workflow document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link ru.ifmo.srv.service.WorkflowDocumentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author rei
 * @see ru.ifmo.srv.service.base.WorkflowDocumentLocalServiceBaseImpl
 * @see ru.ifmo.srv.service.WorkflowDocumentLocalServiceUtil
 */
public class WorkflowDocumentLocalServiceImpl extends
		WorkflowDocumentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * ru.ifmo.srv.service.WorkflowDocumentLocalServiceUtil} to access the
	 * workflow document local service.
	 */
	@Override
	public List<WorkflowDocument> getAllDocuments() throws SystemException {
		return WorkflowDocumentUtil.findAll();
	}
	
	@Override
	public List<WorkflowDocument> getDocuments(long groupId)
			throws SystemException {
		return WorkflowDocumentUtil.findByGroupId(groupId);
	}

	@Override
	public List<WorkflowDocument> getDocuments(long groupId, int start, int end)
			throws SystemException {
		return WorkflowDocumentUtil.findByGroupId(groupId, start, end);
	}

	@Override
	public List<WorkflowDocument> getDocuments(long groupId, int status)
			throws SystemException {
		return WorkflowDocumentUtil.findByG_S(groupId, status);
	}

	@Override
	public WorkflowDocument addDocument(long userId, String title,
			String description, long dlDocumentId, ServiceContext serviceContext)
			throws SystemException, PortalException {
		//TODO handle exception, if no user exists
		User user = UserLocalServiceUtil.getUser(userId);

		Date now = new Date();

		long documentId = CounterLocalServiceUtil.increment(WorkflowDocument.class.getName());
		WorkflowDocument document = WorkflowDocumentUtil.create(documentId);

		document.setUserId(userId);
		document.setGroupId(serviceContext.getScopeGroupId());
		document.setCompanyId(user.getCompanyId());
		document.setUserName(user.getFullName());
		document.setCreateDate(now);
		document.setModifiedDate(now);
		document.setTitle(title);
		document.setDescription(description);
		document.setDlDocumentId(dlDocumentId);
		document.setStatus(WorkflowConstants.STATUS_SCHEDULED);
		document.setStatusByUserId(userId);
		document.setStatusByUserName(user.getFullName());
		document.setStatusDate(now);
		document.setExpandoBridgeAttributes(serviceContext);

		WorkflowDocumentUtil.update(document);

		return document;
	}

	@Override
	public WorkflowDocument deleteDocument(long documentId)
			throws NoSuchWorkflowDocumentException, SystemException {
		return WorkflowDocumentUtil.remove(documentId);
	}

	@Override
	public WorkflowDocument updateStatus(long userId, long documentId,
			int status) throws PortalException,
			SystemException {
		User user = UserLocalServiceUtil.getUser(userId);
		WorkflowDocument document = WorkflowDocumentUtil.findByPrimaryKey(documentId);

		document.setStatus(status);
		document.setStatusByUserId(userId);
		document.setStatusByUserName(user.getFullName());
		document.setStatusDate(new Date());

		return WorkflowDocumentUtil.update(document);

	}
}