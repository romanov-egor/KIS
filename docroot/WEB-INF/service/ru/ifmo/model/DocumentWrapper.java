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

package ru.ifmo.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Document}.
 * </p>
 *
 * @author rei
 * @see Document
 * @generated
 */
public class DocumentWrapper implements Document, ModelWrapper<Document> {
	public DocumentWrapper(Document document) {
		_document = document;
	}

	@Override
	public Class<?> getModelClass() {
		return Document.class;
	}

	@Override
	public String getModelClassName() {
		return Document.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("documentId", getDocumentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("dlDocumentId", getDlDocumentId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long dlDocumentId = (Long)attributes.get("dlDocumentId");

		if (dlDocumentId != null) {
			setDlDocumentId(dlDocumentId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	* Returns the primary key of this document.
	*
	* @return the primary key of this document
	*/
	@Override
	public long getPrimaryKey() {
		return _document.getPrimaryKey();
	}

	/**
	* Sets the primary key of this document.
	*
	* @param primaryKey the primary key of this document
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_document.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the document ID of this document.
	*
	* @return the document ID of this document
	*/
	@Override
	public long getDocumentId() {
		return _document.getDocumentId();
	}

	/**
	* Sets the document ID of this document.
	*
	* @param documentId the document ID of this document
	*/
	@Override
	public void setDocumentId(long documentId) {
		_document.setDocumentId(documentId);
	}

	/**
	* Returns the group ID of this document.
	*
	* @return the group ID of this document
	*/
	@Override
	public long getGroupId() {
		return _document.getGroupId();
	}

	/**
	* Sets the group ID of this document.
	*
	* @param groupId the group ID of this document
	*/
	@Override
	public void setGroupId(long groupId) {
		_document.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this document.
	*
	* @return the company ID of this document
	*/
	@Override
	public long getCompanyId() {
		return _document.getCompanyId();
	}

	/**
	* Sets the company ID of this document.
	*
	* @param companyId the company ID of this document
	*/
	@Override
	public void setCompanyId(long companyId) {
		_document.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this document.
	*
	* @return the user ID of this document
	*/
	@Override
	public long getUserId() {
		return _document.getUserId();
	}

	/**
	* Sets the user ID of this document.
	*
	* @param userId the user ID of this document
	*/
	@Override
	public void setUserId(long userId) {
		_document.setUserId(userId);
	}

	/**
	* Returns the user uuid of this document.
	*
	* @return the user uuid of this document
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _document.getUserUuid();
	}

	/**
	* Sets the user uuid of this document.
	*
	* @param userUuid the user uuid of this document
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_document.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this document.
	*
	* @return the user name of this document
	*/
	@Override
	public java.lang.String getUserName() {
		return _document.getUserName();
	}

	/**
	* Sets the user name of this document.
	*
	* @param userName the user name of this document
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_document.setUserName(userName);
	}

	/**
	* Returns the create date of this document.
	*
	* @return the create date of this document
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _document.getCreateDate();
	}

	/**
	* Sets the create date of this document.
	*
	* @param createDate the create date of this document
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_document.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this document.
	*
	* @return the modified date of this document
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _document.getModifiedDate();
	}

	/**
	* Sets the modified date of this document.
	*
	* @param modifiedDate the modified date of this document
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_document.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this document.
	*
	* @return the title of this document
	*/
	@Override
	public java.lang.String getTitle() {
		return _document.getTitle();
	}

	/**
	* Sets the title of this document.
	*
	* @param title the title of this document
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_document.setTitle(title);
	}

	/**
	* Returns the description of this document.
	*
	* @return the description of this document
	*/
	@Override
	public java.lang.String getDescription() {
		return _document.getDescription();
	}

	/**
	* Sets the description of this document.
	*
	* @param description the description of this document
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_document.setDescription(description);
	}

	/**
	* Returns the dl document ID of this document.
	*
	* @return the dl document ID of this document
	*/
	@Override
	public long getDlDocumentId() {
		return _document.getDlDocumentId();
	}

	/**
	* Sets the dl document ID of this document.
	*
	* @param dlDocumentId the dl document ID of this document
	*/
	@Override
	public void setDlDocumentId(long dlDocumentId) {
		_document.setDlDocumentId(dlDocumentId);
	}

	/**
	* Returns the status of this document.
	*
	* @return the status of this document
	*/
	@Override
	public int getStatus() {
		return _document.getStatus();
	}

	/**
	* Sets the status of this document.
	*
	* @param status the status of this document
	*/
	@Override
	public void setStatus(int status) {
		_document.setStatus(status);
	}

	/**
	* Returns the status by user ID of this document.
	*
	* @return the status by user ID of this document
	*/
	@Override
	public long getStatusByUserId() {
		return _document.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this document.
	*
	* @param statusByUserId the status by user ID of this document
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_document.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this document.
	*
	* @return the status by user uuid of this document
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _document.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this document.
	*
	* @param statusByUserUuid the status by user uuid of this document
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_document.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this document.
	*
	* @return the status by user name of this document
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _document.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this document.
	*
	* @param statusByUserName the status by user name of this document
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_document.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this document.
	*
	* @return the status date of this document
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _document.getStatusDate();
	}

	/**
	* Sets the status date of this document.
	*
	* @param statusDate the status date of this document
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_document.setStatusDate(statusDate);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _document.getApproved();
	}

	/**
	* Returns <code>true</code> if this document is approved.
	*
	* @return <code>true</code> if this document is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _document.isApproved();
	}

	/**
	* Returns <code>true</code> if this document is denied.
	*
	* @return <code>true</code> if this document is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _document.isDenied();
	}

	/**
	* Returns <code>true</code> if this document is a draft.
	*
	* @return <code>true</code> if this document is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _document.isDraft();
	}

	/**
	* Returns <code>true</code> if this document is expired.
	*
	* @return <code>true</code> if this document is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _document.isExpired();
	}

	/**
	* Returns <code>true</code> if this document is inactive.
	*
	* @return <code>true</code> if this document is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _document.isInactive();
	}

	/**
	* Returns <code>true</code> if this document is incomplete.
	*
	* @return <code>true</code> if this document is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _document.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this document is pending.
	*
	* @return <code>true</code> if this document is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _document.isPending();
	}

	/**
	* Returns <code>true</code> if this document is scheduled.
	*
	* @return <code>true</code> if this document is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _document.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _document.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_document.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _document.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_document.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _document.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _document.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_document.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _document.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_document.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_document.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_document.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DocumentWrapper((Document)_document.clone());
	}

	@Override
	public int compareTo(ru.ifmo.model.Document document) {
		return _document.compareTo(document);
	}

	@Override
	public int hashCode() {
		return _document.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ru.ifmo.model.Document> toCacheModel() {
		return _document.toCacheModel();
	}

	@Override
	public ru.ifmo.model.Document toEscapedModel() {
		return new DocumentWrapper(_document.toEscapedModel());
	}

	@Override
	public ru.ifmo.model.Document toUnescapedModel() {
		return new DocumentWrapper(_document.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _document.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _document.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_document.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentWrapper)) {
			return false;
		}

		DocumentWrapper documentWrapper = (DocumentWrapper)obj;

		if (Validator.equals(_document, documentWrapper._document)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Document getWrappedDocument() {
		return _document;
	}

	@Override
	public Document getWrappedModel() {
		return _document;
	}

	@Override
	public void resetOriginalValues() {
		_document.resetOriginalValues();
	}

	private Document _document;
}