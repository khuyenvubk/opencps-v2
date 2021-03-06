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

package org.opencps.communication.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.opencps.communication.constants.NotificationTemplateTerm;
import org.opencps.communication.exception.NoSuchNotificationtemplateException;
import org.opencps.communication.model.Notificationtemplate;
import org.opencps.communication.service.base.NotificationtemplateLocalServiceBaseImpl;

import com.liferay.asset.kernel.exception.DuplicateCategoryException;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.generic.MultiMatchQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.ProviderType;
import org.opencps.auth.api.BackendAuthImpl;
import org.opencps.auth.api.exception.NotFoundException;
import org.opencps.auth.api.exception.UnauthenticationException;
import org.opencps.auth.api.exception.UnauthorizationException;
import org.opencps.auth.api.keys.ActionKeys;
import org.opencps.auth.api.keys.ModelNameKeys;

/**
 * The implementation of the notificationtemplate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.opencps.communication.service.NotificationtemplateLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Binhth
 * @see NotificationtemplateLocalServiceBaseImpl
 * @see org.opencps.communication.service.NotificationtemplateLocalServiceUtil
 */
@ProviderType
public class NotificationtemplateLocalServiceImpl extends NotificationtemplateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * org.opencps.communication.service.
	 * NotificationtemplateLocalServiceUtil} to access the notificationtemplate
	 * local service.
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Notificationtemplate addNotificationTemplate(long userId, long groupId, String notificationType,
			String emailSubject, String emailBody, String textMessage, boolean sendSMS, boolean sendEmail,
			ServiceContext serviceContext) throws UnauthenticationException, UnauthorizationException,
			NoSuchUserException, DuplicateCategoryException {

		Notificationtemplate notificationtemplate = notificationtemplatePersistence
				.fetchByF_NotificationtemplateByType(groupId, notificationType);

		if (Validator.isNotNull(notificationtemplate)) {

			throw new DuplicateCategoryException();

		}

		// authen
		BackendAuthImpl authImpl = new BackendAuthImpl();

		boolean isAuth = authImpl.isAuth(serviceContext);

		if (!isAuth) {
			throw new UnauthenticationException();
		}

		boolean hasPermission = authImpl.hasResource(serviceContext, ModelNameKeys.WORKINGUNIT_MGT_CENTER,
				ActionKeys.EDIT_DATA);

		if (!hasPermission) {
			throw new UnauthorizationException();
		}

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		long notificationTemplateId = counterLocalService.increment(Notificationtemplate.class.getName());

		Notificationtemplate notificationTemplate = notificationtemplatePersistence.create(notificationTemplateId);

		// Group instance
		notificationTemplate.setGroupId(groupId);

		// Audit fields
		notificationTemplate.setCompanyId(user.getCompanyId());
		notificationTemplate.setUserId(user.getUserId());
		notificationTemplate.setUserName(user.getFullName());
		notificationTemplate.setCreateDate(serviceContext.getCreateDate(now));
		notificationTemplate.setModifiedDate(serviceContext.getCreateDate(now));

		notificationTemplate.setSendEmail(sendEmail);

		notificationTemplate.setNotificationType(notificationType);
		notificationTemplate.setEmailSubject(emailSubject);
		notificationTemplate.setEmailBody(emailBody);
		notificationTemplate.setTextMessage(textMessage);
		notificationTemplate.setSendSMS(sendSMS);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		notificationTemplate.setExpireDuration(cal.getTime());
		
		notificationTemplate.setExpandoBridgeAttributes(serviceContext);

		notificationtemplatePersistence.update(notificationTemplate);

		return notificationTemplate;
	}

	/**
	 * @param dictCollectionId
	 * @param serviceContext
	 * @return
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Notificationtemplate deleteNotificationTemplate(long notificationTemplateId, ServiceContext serviceContext)
			throws UnauthenticationException, UnauthorizationException, NotFoundException {
		// authen
		BackendAuthImpl authImpl = new BackendAuthImpl();

		boolean isAuth = authImpl.isAuth(serviceContext);

		if (!isAuth) {
			throw new UnauthenticationException();
		}

		boolean hasPermission = authImpl.hasResource(serviceContext, ModelNameKeys.WORKINGUNIT_MGT_CENTER,
				ActionKeys.EDIT_DATA);

		if (!hasPermission) {
			throw new UnauthorizationException();
		}

		Notificationtemplate notificationTemplate = null;
		try {
			notificationTemplate = notificationtemplatePersistence.remove(notificationTemplateId);
		} catch (NoSuchNotificationtemplateException e) {
			e.printStackTrace();
		}

		return notificationTemplate;

	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Notificationtemplate updateNotificationTemplate(long userId, long notificationTemplateId,
			String notificationType, String emailSubject, String emailBody, String textMessage, boolean sendSMS,
			boolean sendEmail, Date expireDuration, ServiceContext serviceContext)
			throws UnauthenticationException, UnauthorizationException, NotFoundException, NoSuchUserException {

		// authen
		BackendAuthImpl authImpl = new BackendAuthImpl();

		boolean isAuth = authImpl.isAuth(serviceContext);

		if (!isAuth) {
			throw new UnauthenticationException();
		}

		boolean hasPermission = authImpl.hasResource(serviceContext, ModelNameKeys.WORKINGUNIT_MGT_CENTER,
				ActionKeys.EDIT_DATA);

		if (!hasPermission) {
			throw new UnauthorizationException();
		}

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		Notificationtemplate notificationTemplate = notificationtemplatePersistence
				.fetchByPrimaryKey(notificationTemplateId);

		// Audit fields
		notificationTemplate.setUserId(user.getUserId());
		notificationTemplate.setUserName(user.getFullName());
		notificationTemplate.setModifiedDate(serviceContext.getCreateDate(now));

		notificationTemplate.setSendEmail(sendEmail);
		notificationTemplate.setNotificationType(notificationType);
		notificationTemplate.setEmailSubject(emailSubject);
		notificationTemplate.setEmailBody(emailBody);
		notificationTemplate.setTextMessage(textMessage);
		notificationTemplate.setSendSMS(sendSMS);
		notificationTemplate.setExpireDuration(expireDuration);
		
		notificationTemplate.setExpandoBridgeAttributes(serviceContext);

		notificationtemplatePersistence.update(notificationTemplate);

		return notificationTemplate;
	}

	public Hits luceneSearchEngine(LinkedHashMap<String, Object> params, Sort[] sorts, int start, int end,
			SearchContext searchContext) throws ParseException, SearchException {
		Indexer<Notificationtemplate> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Notificationtemplate.class);

		searchContext.addFullQueryEntryClassName(Notificationtemplate.class.getName());
		searchContext.setEntryClassNames(new String[] { Notificationtemplate.class.getName() });
		searchContext.setAttribute("paginationType", "regular");
		searchContext.setLike(true);
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setAndSearch(true);
		searchContext.setSorts(sorts);

		searchContext.setAttribute("params", params);

		// // LAY CAC THAM SO TRONG PARAMS.
		String keywords = (String) params.get("keywords");
		String groupId = (String) params.get("groupId");
		String userId = (String) params.get("userId");
		String sendEMail = (String) params.get(NotificationTemplateTerm.SEND_EMAIL);
		BooleanQuery booleanQuery = null;

		booleanQuery = Validator.isNotNull((String) keywords)
				? BooleanQueryFactoryUtil.create((SearchContext) searchContext) : indexer.getFullQuery(searchContext);

		if (Validator.isNotNull(keywords)) {
			String[] keyword = keywords.split(StringPool.SPACE);
			for (String string : keyword) {

				MultiMatchQuery query = new MultiMatchQuery(string);

				query.addFields(NotificationTemplateTerm.NOTIFICATION_EMAIL_SUBJECT);

				booleanQuery.add(query, BooleanClauseOccur.MUST);

			}
		}

		if (Validator.isNotNull(groupId)) {
			MultiMatchQuery query = new MultiMatchQuery(groupId);

			query.addFields(NotificationTemplateTerm.GROUP_ID);

			booleanQuery.add(query, BooleanClauseOccur.MUST);
		}

		if (Validator.isNotNull(userId)) {
			MultiMatchQuery query = new MultiMatchQuery(userId);

			query.addFields(NotificationTemplateTerm.USER_ID);

			booleanQuery.add(query, BooleanClauseOccur.MUST);

		}
		if (Validator.isNotNull(sendEMail)) {
			MultiMatchQuery query = new MultiMatchQuery(sendEMail);

			query.addFields(NotificationTemplateTerm.SEND_EMAIL);

			booleanQuery.add(query, BooleanClauseOccur.MUST);

		}

		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, Notificationtemplate.class.getName());

		return IndexSearcherHelperUtil.search(searchContext, booleanQuery);

	}

	public long countLuceneSearchEngine(LinkedHashMap<String, Object> params, SearchContext searchContext)
			throws ParseException, SearchException {
		Indexer<Notificationtemplate> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Notificationtemplate.class);

		searchContext.addFullQueryEntryClassName(Notificationtemplate.class.getName());
		searchContext.setEntryClassNames(new String[] { Notificationtemplate.class.getName() });
		searchContext.setAttribute("paginationType", "regular");
		searchContext.setLike(true);
		searchContext.setAndSearch(true);

		searchContext.setAttribute("params", params);

		// // LAY CAC THAM SO TRONG PARAMS.
		String keywords = (String) params.get("keywords");
		String groupId = (String) params.get("groupId");
		String userId = (String) params.get("userId");
		String sendEMail = (String) params.get(NotificationTemplateTerm.SEND_EMAIL);

		BooleanQuery booleanQuery = null;

		booleanQuery = Validator.isNotNull((String) keywords)
				? BooleanQueryFactoryUtil.create((SearchContext) searchContext) : indexer.getFullQuery(searchContext);

		if (Validator.isNotNull(keywords)) {
			String[] keyword = keywords.split(StringPool.SPACE);
			for (String string : keyword) {

				MultiMatchQuery query = new MultiMatchQuery(string);

				query.addFields(NotificationTemplateTerm.NOTIFICATION_EMAIL_SUBJECT);

				booleanQuery.add(query, BooleanClauseOccur.MUST);

			}
		}

		if (Validator.isNotNull(groupId)) {
			MultiMatchQuery query = new MultiMatchQuery(groupId);

			query.addFields(NotificationTemplateTerm.GROUP_ID);

			booleanQuery.add(query, BooleanClauseOccur.MUST);
		}

		if (Validator.isNotNull(userId)) {
			MultiMatchQuery query = new MultiMatchQuery(userId);

			query.addFields(NotificationTemplateTerm.USER_ID);

			booleanQuery.add(query, BooleanClauseOccur.MUST);

		}

		if (Validator.isNotNull(sendEMail)) {
			MultiMatchQuery query = new MultiMatchQuery(sendEMail);

			query.addFields(NotificationTemplateTerm.SEND_EMAIL);

			booleanQuery.add(query, BooleanClauseOccur.MUST);

		}

		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, Notificationtemplate.class.getName());

		return IndexSearcherHelperUtil.searchCount(searchContext, booleanQuery);

	}

	public Notificationtemplate fetchByF_NotificationtemplateByType(long groupId, String notificationType) {
		return notificationtemplatePersistence.fetchByF_NotificationtemplateByType(groupId, notificationType);
	}

	public List<Notificationtemplate> findByF_NotificationtemplateByGroup(long groupId) {
		return notificationtemplatePersistence.findByF_NotificationtemplateByGroup(groupId);
	}

	public boolean initTemplate(long groupId) {

		boolean result = false;

		if (notificationtemplatePersistence.findByF_NotificationtemplateByGroup(groupId).size() <= 0) {

			result = true;

		}

		return result;

	}

	private static final Log _log = LogFactoryUtil.getLog(NotificationtemplateLocalServiceImpl.class);
}