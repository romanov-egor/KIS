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

package ru.ifmo.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.workflow.*;
import com.liferay.portal.kernel.workflow.comparator.WorkflowInstanceStartDateComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

import ru.ifmo.NoSuchDocumentException;
import ru.ifmo.model.Document;
import ru.ifmo.service.base.DocumentLocalServiceBaseImpl;

/**
 * The implementation of the document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.ifmo.service.DocumentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author rei
 * @see ru.ifmo.service.base.DocumentLocalServiceBaseImpl
 * @see ru.ifmo.service.DocumentLocalServiceUtil
 */
public class DocumentLocalServiceImpl extends DocumentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link ru.ifmo.service.DocumentLocalServiceUtil} to access the document local service.
	 */
	
	public List<Document> getDocuments (long groupId) throws SystemException {
	    return documentPersistence.findByGroupId(groupId);
	}

	public List<Document> getDocuments (long groupId, int start, int end) throws SystemException {
	    return documentPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<Document> getDocuments (long groupId, int status) throws SystemException {
		return documentPersistence.findByG_S(groupId, status);
	}
	
	public Document addDocument(long userId, String title, String description, long dlDocumentId, ServiceContext serviceContext) 
			throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		long documentId = counterLocalService.increment(Document.class.getName());
		
		Document document = documentPersistence.create(documentId);
		
		document.setUserId(userId);
		document.setGroupId(groupId);
		document.setCompanyId(user.getCompanyId());
		document.setUserName(user.getFullName());
		document.setCreateDate(serviceContext.getCreateDate(now));
		document.setModifiedDate(serviceContext.getModifiedDate(now));
		document.setTitle(title);
		document.setDescription(description);
		document.setDlDocumentId(dlDocumentId);
		document.setStatus(WorkflowConstants.STATUS_SCHEDULED);
		document.setStatusByUserId(userId);
		document.setStatusByUserName(user.getFullName());
		document.setStatusDate(new Date());
		document.setExpandoBridgeAttributes(serviceContext);
		
		documentPersistence.update(document);
		
		return document;
	}
	
	public Document deleteDocument(long documentId) throws NoSuchDocumentException, SystemException {
		return documentPersistence.remove(documentId);
	}
	
	public Document updateStatus(long userId, long documentId, int status, ServiceContext serviceContext) 
			throws PortalException, SystemException {
		User user = userLocalService.getUser(userId);
		Document document = getDocument(documentId);
		
		document.setStatus(status);
		document.setStatusByUserId(userId);
		document.setStatusByUserName(user.getFullName());
		document.setStatusDate(new Date());

		return documentPersistence.update(document);
		
	}
}