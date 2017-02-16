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
 * This class is a wrapper for {@link document_}.
 * </p>
 *
 * @author rei
 * @see document_
 * @generated
 */
public class document_Wrapper implements document_, ModelWrapper<document_> {
	public document_Wrapper(document_ document_) {
		_document_ = document_;
	}

	@Override
	public Class<?> getModelClass() {
		return document_.class;
	}

	@Override
	public String getModelClassName() {
		return document_.class.getName();
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
	* Returns the primary key of this document_.
	*
	* @return the primary key of this document_
	*/
	@Override
	public long getPrimaryKey() {
		return _document_.getPrimaryKey();
	}

	/**
	* Sets the primary key of this document_.
	*
	* @param primaryKey the primary key of this document_
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_document_.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the document ID of this document_.
	*
	* @return the document ID of this document_
	*/
	@Override
	public long getDocumentId() {
		return _document_.getDocumentId();
	}

	/**
	* Sets the document ID of this document_.
	*
	* @param documentId the document ID of this document_
	*/
	@Override
	public void setDocumentId(long documentId) {
		_document_.setDocumentId(documentId);
	}

	/**
	* Returns the group ID of this document_.
	*
	* @return the group ID of this document_
	*/
	@Override
	public long getGroupId() {
		return _document_.getGroupId();
	}

	/**
	* Sets the group ID of this document_.
	*
	* @param groupId the group ID of this document_
	*/
	@Override
	public void setGroupId(long groupId) {
		_document_.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this document_.
	*
	* @return the company ID of this document_
	*/
	@Override
	public long getCompanyId() {
		return _document_.getCompanyId();
	}

	/**
	* Sets the company ID of this document_.
	*
	* @param companyId the company ID of this document_
	*/
	@Override
	public void setCompanyId(long companyId) {
		_document_.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this document_.
	*
	* @return the user ID of this document_
	*/
	@Override
	public long getUserId() {
		return _document_.getUserId();
	}

	/**
	* Sets the user ID of this document_.
	*
	* @param userId the user ID of this document_
	*/
	@Override
	public void setUserId(long userId) {
		_document_.setUserId(userId);
	}

	/**
	* Returns the user uuid of this document_.
	*
	* @return the user uuid of this document_
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _document_.getUserUuid();
	}

	/**
	* Sets the user uuid of this document_.
	*
	* @param userUuid the user uuid of this document_
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_document_.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this document_.
	*
	* @return the user name of this document_
	*/
	@Override
	public java.lang.String getUserName() {
		return _document_.getUserName();
	}

	/**
	* Sets the user name of this document_.
	*
	* @param userName the user name of this document_
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_document_.setUserName(userName);
	}

	/**
	* Returns the create date of this document_.
	*
	* @return the create date of this document_
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _document_.getCreateDate();
	}

	/**
	* Sets the create date of this document_.
	*
	* @param createDate the create date of this document_
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_document_.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this document_.
	*
	* @return the modified date of this document_
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _document_.getModifiedDate();
	}

	/**
	* Sets the modified date of this document_.
	*
	* @param modifiedDate the modified date of this document_
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_document_.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this document_.
	*
	* @return the title of this document_
	*/
	@Override
	public java.lang.String getTitle() {
		return _document_.getTitle();
	}

	/**
	* Sets the title of this document_.
	*
	* @param title the title of this document_
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_document_.setTitle(title);
	}

	/**
	* Returns the description of this document_.
	*
	* @return the description of this document_
	*/
	@Override
	public java.lang.String getDescription() {
		return _document_.getDescription();
	}

	/**
	* Sets the description of this document_.
	*
	* @param description the description of this document_
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_document_.setDescription(description);
	}

	/**
	* Returns the dl document ID of this document_.
	*
	* @return the dl document ID of this document_
	*/
	@Override
	public long getDlDocumentId() {
		return _document_.getDlDocumentId();
	}

	/**
	* Sets the dl document ID of this document_.
	*
	* @param dlDocumentId the dl document ID of this document_
	*/
	@Override
	public void setDlDocumentId(long dlDocumentId) {
		_document_.setDlDocumentId(dlDocumentId);
	}

	/**
	* Returns the status of this document_.
	*
	* @return the status of this document_
	*/
	@Override
	public int getStatus() {
		return _document_.getStatus();
	}

	/**
	* Sets the status of this document_.
	*
	* @param status the status of this document_
	*/
	@Override
	public void setStatus(int status) {
		_document_.setStatus(status);
	}

	/**
	* Returns the status by user ID of this document_.
	*
	* @return the status by user ID of this document_
	*/
	@Override
	public long getStatusByUserId() {
		return _document_.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this document_.
	*
	* @param statusByUserId the status by user ID of this document_
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_document_.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this document_.
	*
	* @return the status by user uuid of this document_
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _document_.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this document_.
	*
	* @param statusByUserUuid the status by user uuid of this document_
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_document_.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this document_.
	*
	* @return the status by user name of this document_
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _document_.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this document_.
	*
	* @param statusByUserName the status by user name of this document_
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_document_.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this document_.
	*
	* @return the status date of this document_
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _document_.getStatusDate();
	}

	/**
	* Sets the status date of this document_.
	*
	* @param statusDate the status date of this document_
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_document_.setStatusDate(statusDate);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _document_.getApproved();
	}

	/**
	* Returns <code>true</code> if this document_ is approved.
	*
	* @return <code>true</code> if this document_ is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _document_.isApproved();
	}

	/**
	* Returns <code>true</code> if this document_ is denied.
	*
	* @return <code>true</code> if this document_ is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _document_.isDenied();
	}

	/**
	* Returns <code>true</code> if this document_ is a draft.
	*
	* @return <code>true</code> if this document_ is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _document_.isDraft();
	}

	/**
	* Returns <code>true</code> if this document_ is expired.
	*
	* @return <code>true</code> if this document_ is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _document_.isExpired();
	}

	/**
	* Returns <code>true</code> if this document_ is inactive.
	*
	* @return <code>true</code> if this document_ is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _document_.isInactive();
	}

	/**
	* Returns <code>true</code> if this document_ is incomplete.
	*
	* @return <code>true</code> if this document_ is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _document_.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this document_ is pending.
	*
	* @return <code>true</code> if this document_ is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _document_.isPending();
	}

	/**
	* Returns <code>true</code> if this document_ is scheduled.
	*
	* @return <code>true</code> if this document_ is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _document_.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _document_.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_document_.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _document_.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_document_.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _document_.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _document_.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_document_.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _document_.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_document_.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_document_.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_document_.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new document_Wrapper((document_)_document_.clone());
	}

	@Override
	public int compareTo(ru.ifmo.model.document_ document_) {
		return _document_.compareTo(document_);
	}

	@Override
	public int hashCode() {
		return _document_.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ru.ifmo.model.document_> toCacheModel() {
		return _document_.toCacheModel();
	}

	@Override
	public ru.ifmo.model.document_ toEscapedModel() {
		return new document_Wrapper(_document_.toEscapedModel());
	}

	@Override
	public ru.ifmo.model.document_ toUnescapedModel() {
		return new document_Wrapper(_document_.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _document_.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _document_.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof document_Wrapper)) {
			return false;
		}

		document_Wrapper document_Wrapper = (document_Wrapper)obj;

		if (Validator.equals(_document_, document_Wrapper._document_)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public document_ getWrappeddocument_() {
		return _document_;
	}

	@Override
	public document_ getWrappedModel() {
		return _document_;
	}

	@Override
	public void resetOriginalValues() {
		_document_.resetOriginalValues();
	}

	private document_ _document_;
}