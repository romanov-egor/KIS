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

package ru.ifmo.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ru.ifmo.service.model.document_;

/**
 * The persistence interface for the document_ service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rei
 * @see document_PersistenceImpl
 * @see document_Util
 * @generated
 */
public interface document_Persistence extends BasePersistence<document_> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link document_Util} to access the document_ persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the document_s where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching document_s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.ifmo.service.model.document_> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the document_s where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.ifmo.service.model.impl.document_ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of document_s
	* @param end the upper bound of the range of document_s (not inclusive)
	* @return the range of matching document_s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.ifmo.service.model.document_> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the document_s where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.ifmo.service.model.impl.document_ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of document_s
	* @param end the upper bound of the range of document_s (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching document_s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.ifmo.service.model.document_> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first document_ in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document_
	* @throws ru.ifmo.service.NoSuchdocument_Exception if a matching document_ could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_ findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.ifmo.service.NoSuchdocument_Exception;

	/**
	* Returns the first document_ in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document_, or <code>null</code> if a matching document_ could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_ fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last document_ in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document_
	* @throws ru.ifmo.service.NoSuchdocument_Exception if a matching document_ could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_ findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.ifmo.service.NoSuchdocument_Exception;

	/**
	* Returns the last document_ in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document_, or <code>null</code> if a matching document_ could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_ fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the document_s before and after the current document_ in the ordered set where groupId = &#63;.
	*
	* @param documentId the primary key of the current document_
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document_
	* @throws ru.ifmo.service.NoSuchdocument_Exception if a document_ with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_[] findByGroupId_PrevAndNext(
		long documentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.ifmo.service.NoSuchdocument_Exception;

	/**
	* Removes all the document_s where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of document_s where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching document_s
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the document_s where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching document_s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.ifmo.service.model.document_> findByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the document_s where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.ifmo.service.model.impl.document_ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of document_s
	* @param end the upper bound of the range of document_s (not inclusive)
	* @return the range of matching document_s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.ifmo.service.model.document_> findByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the document_s where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.ifmo.service.model.impl.document_ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of document_s
	* @param end the upper bound of the range of document_s (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching document_s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.ifmo.service.model.document_> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first document_ in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document_
	* @throws ru.ifmo.service.NoSuchdocument_Exception if a matching document_ could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_ findByG_S_First(long groupId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.ifmo.service.NoSuchdocument_Exception;

	/**
	* Returns the first document_ in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document_, or <code>null</code> if a matching document_ could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_ fetchByG_S_First(long groupId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last document_ in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document_
	* @throws ru.ifmo.service.NoSuchdocument_Exception if a matching document_ could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_ findByG_S_Last(long groupId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.ifmo.service.NoSuchdocument_Exception;

	/**
	* Returns the last document_ in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document_, or <code>null</code> if a matching document_ could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_ fetchByG_S_Last(long groupId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the document_s before and after the current document_ in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param documentId the primary key of the current document_
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document_
	* @throws ru.ifmo.service.NoSuchdocument_Exception if a document_ with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_[] findByG_S_PrevAndNext(
		long documentId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.ifmo.service.NoSuchdocument_Exception;

	/**
	* Removes all the document_s where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of document_s where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching document_s
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the document_ in the entity cache if it is enabled.
	*
	* @param document_ the document_
	*/
	public void cacheResult(ru.ifmo.service.model.document_ document_);

	/**
	* Caches the document_s in the entity cache if it is enabled.
	*
	* @param document_s the document_s
	*/
	public void cacheResult(
		java.util.List<ru.ifmo.service.model.document_> document_s);

	/**
	* Creates a new document_ with the primary key. Does not add the document_ to the database.
	*
	* @param documentId the primary key for the new document_
	* @return the new document_
	*/
	public ru.ifmo.service.model.document_ create(long documentId);

	/**
	* Removes the document_ with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the document_
	* @return the document_ that was removed
	* @throws ru.ifmo.service.NoSuchdocument_Exception if a document_ with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_ remove(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.ifmo.service.NoSuchdocument_Exception;

	public ru.ifmo.service.model.document_ updateImpl(
		ru.ifmo.service.model.document_ document_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the document_ with the primary key or throws a {@link ru.ifmo.service.NoSuchdocument_Exception} if it could not be found.
	*
	* @param documentId the primary key of the document_
	* @return the document_
	* @throws ru.ifmo.service.NoSuchdocument_Exception if a document_ with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_ findByPrimaryKey(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.ifmo.service.NoSuchdocument_Exception;

	/**
	* Returns the document_ with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param documentId the primary key of the document_
	* @return the document_, or <code>null</code> if a document_ with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.ifmo.service.model.document_ fetchByPrimaryKey(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the document_s.
	*
	* @return the document_s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.ifmo.service.model.document_> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the document_s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.ifmo.service.model.impl.document_ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document_s
	* @param end the upper bound of the range of document_s (not inclusive)
	* @return the range of document_s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.ifmo.service.model.document_> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the document_s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.ifmo.service.model.impl.document_ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document_s
	* @param end the upper bound of the range of document_s (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of document_s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.ifmo.service.model.document_> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the document_s from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of document_s.
	*
	* @return the number of document_s
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}