package org.opencps.communication.action.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.opencps.communication.action.NotificationTemplateInterface;
import org.opencps.communication.constants.NotificationMGTConstants;
import org.opencps.communication.model.Notificationtemplate;
import org.opencps.communication.service.NotificationtemplateLocalServiceUtil;
import org.opencps.communication.utils.DateTimeUtils;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import org.opencps.auth.api.exception.NotFoundException;
import org.opencps.auth.api.exception.UnauthenticationException;
import org.opencps.auth.api.exception.UnauthorizationException;

public class NotificationTemplateActions implements NotificationTemplateInterface {

	public Log _log = LogFactoryUtil.getLog(NotificationTemplateActions.class);

	@Override
	public JSONObject getNotificationTemplates(long userId, long companyId, long groupId,
			LinkedHashMap<String, Object> params, Sort[] sorts, int start, int end, ServiceContext serviceContext) {
		JSONObject result = JSONFactoryUtil.createJSONObject();
		Hits hits = null;
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);

		try {
			hits = NotificationtemplateLocalServiceUtil.luceneSearchEngine(params, sorts, start, end, searchContext);

			result.put("data", hits.toList());

			long total = NotificationtemplateLocalServiceUtil.countLuceneSearchEngine(params, searchContext);

			result.put("total", total);

			if (NotificationtemplateLocalServiceUtil.initTemplate(groupId)) {

				// create init Templates
				Map<String, String> initTemplates = NotificationMGTConstants.NOTIFICATION_TEMPLATE_INIT;

				for (String key : initTemplates.keySet()) {

					try {

						NotificationtemplateLocalServiceUtil.addNotificationTemplate(userId, groupId, key,
								initTemplates.get(key), initTemplates.get(key), initTemplates.get(key), Boolean.FALSE,
								Boolean.FALSE, serviceContext);

					} catch (Exception e) {
						_log.error(e);
					}

				}

			}

		} catch (ParseException e) {
			_log.error(e);
		} catch (SearchException e) {
			_log.error(e);
		}

		return result;
	}

	@Override
	public boolean delete(long userId, long groupId, String type, ServiceContext serviceContext)
			throws NotFoundException, UnauthenticationException, UnauthorizationException {
		boolean flag = false;

		Notificationtemplate notificationtemplate = NotificationtemplateLocalServiceUtil
				.fetchByF_NotificationtemplateByType(groupId, type);

		if (Validator.isNotNull(notificationtemplate)) {

			NotificationtemplateLocalServiceUtil
					.deleteNotificationTemplate(notificationtemplate.getNotificationTemplateId(), serviceContext);
			flag = true;
		}

		return flag;
	}

	@Override
	public Notificationtemplate read(long userId, long groupId, String type, ServiceContext serviceContext) {
		Notificationtemplate ett = null;

		ett = NotificationtemplateLocalServiceUtil.fetchByF_NotificationtemplateByType(groupId, type);

		return ett;
	}

	@Override
	public Notificationtemplate update(long userId, long groupId, String type, String emailBody, String emailSubject,
			String sendEmail, String textMessage, String sendSMS, String expireDuration, ServiceContext serviceContext)
			throws NoSuchUserException, NotFoundException, UnauthenticationException, UnauthorizationException {
		Notificationtemplate notificationtemplate = NotificationtemplateLocalServiceUtil
				.fetchByF_NotificationtemplateByType(groupId, type);

		if (Validator.isNotNull(emailSubject)) {

			notificationtemplate.setEmailSubject(emailSubject);

		}

		if (Validator.isNotNull(emailBody)) {

			notificationtemplate.setEmailBody(emailBody);

		}

		if (Validator.isNotNull(textMessage)) {

			notificationtemplate.setTextMessage(textMessage);

		}

		if (Validator.isNotNull(sendEmail)) {

			notificationtemplate.setSendEmail(Boolean.valueOf(sendEmail));

		}

		if (Validator.isNotNull(sendSMS)) {

			notificationtemplate.setSendSMS(Boolean.valueOf(sendSMS));

		}

		if (Validator.isNotNull(expireDuration)) {

			notificationtemplate.setExpireDuration(DateTimeUtils.convertStringToDateAPI(expireDuration));

		}

		notificationtemplate = NotificationtemplateLocalServiceUtil.updateNotificationTemplate(userId,
				notificationtemplate.getNotificationTemplateId(), notificationtemplate.getNotificationType(),
				notificationtemplate.getEmailSubject(), notificationtemplate.getEmailBody(),
				notificationtemplate.getTextMessage(), notificationtemplate.getSendSMS(),
				notificationtemplate.getSendEmail(), notificationtemplate.getExpireDuration(), serviceContext);

		return notificationtemplate;
	}

	@Override
	public JSONObject getNotificationTypes() {
		JSONObject result = JSONFactoryUtil.createJSONObject();

		Map<String, String> initTemplates = NotificationMGTConstants.NOTIFICATION_TEMPLATE_INIT;

		result.put("data", initTemplates);

		result.put("total", initTemplates.size());

		return result;
	}

}
