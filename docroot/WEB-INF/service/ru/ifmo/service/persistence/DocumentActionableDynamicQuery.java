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

package ru.ifmo.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ru.ifmo.model.Document;

import ru.ifmo.service.DocumentLocalServiceUtil;

/**
 * @author rei
 * @generated
 */
public abstract class DocumentActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public DocumentActionableDynamicQuery() throws SystemException {
		setBaseLocalService(DocumentLocalServiceUtil.getService());
		setClass(Document.class);

		setClassLoader(ru.ifmo.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("documentId");
	}
}