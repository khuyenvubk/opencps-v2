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

package org.opencps.backend.dossiermgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.opencps.backend.dossiermgt.model.ServiceOption;
import org.opencps.backend.dossiermgt.model.ServiceOptionModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ServiceOption service. Represents a row in the &quot;opencps_serviceoption&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ServiceOptionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ServiceOptionImpl}.
 * </p>
 *
 * @author huymq
 * @see ServiceOptionImpl
 * @see ServiceOption
 * @see ServiceOptionModel
 * @generated
 */
@ProviderType
public class ServiceOptionModelImpl extends BaseModelImpl<ServiceOption>
	implements ServiceOptionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a service option model instance should use the {@link ServiceOption} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_serviceoption";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "serviceOptionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "optionCode", Types.VARCHAR },
			{ "optionName", Types.VARCHAR },
			{ "optionOrder", Types.INTEGER },
			{ "autoSelect", Types.VARCHAR },
			{ "dossierTemplateId", Types.BIGINT },
			{ "serviceProcessId", Types.BIGINT },
			{ "instructionNote", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serviceOptionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("optionCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("optionName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("optionOrder", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("autoSelect", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dossierTemplateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("serviceProcessId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("instructionNote", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_serviceoption (uuid_ VARCHAR(75) null,serviceOptionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,optionCode VARCHAR(75) null,optionName VARCHAR(75) null,optionOrder INTEGER,autoSelect VARCHAR(75) null,dossierTemplateId LONG,serviceProcessId LONG,instructionNote VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_serviceoption";
	public static final String ORDER_BY_JPQL = " ORDER BY serviceOption.serviceOptionId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_serviceoption.serviceOptionId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.backend.dossiermgt.model.ServiceOption"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.backend.dossiermgt.model.ServiceOption"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.backend.dossiermgt.model.ServiceOption"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long SERVICEOPTIONID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.backend.dossiermgt.model.ServiceOption"));

	public ServiceOptionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _serviceOptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setServiceOptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _serviceOptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceOption.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceOption.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("serviceOptionId", getServiceOptionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("optionCode", getOptionCode());
		attributes.put("optionName", getOptionName());
		attributes.put("optionOrder", getOptionOrder());
		attributes.put("autoSelect", getAutoSelect());
		attributes.put("dossierTemplateId", getDossierTemplateId());
		attributes.put("serviceProcessId", getServiceProcessId());
		attributes.put("instructionNote", getInstructionNote());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long serviceOptionId = (Long)attributes.get("serviceOptionId");

		if (serviceOptionId != null) {
			setServiceOptionId(serviceOptionId);
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

		String optionCode = (String)attributes.get("optionCode");

		if (optionCode != null) {
			setOptionCode(optionCode);
		}

		String optionName = (String)attributes.get("optionName");

		if (optionName != null) {
			setOptionName(optionName);
		}

		Integer optionOrder = (Integer)attributes.get("optionOrder");

		if (optionOrder != null) {
			setOptionOrder(optionOrder);
		}

		String autoSelect = (String)attributes.get("autoSelect");

		if (autoSelect != null) {
			setAutoSelect(autoSelect);
		}

		Long dossierTemplateId = (Long)attributes.get("dossierTemplateId");

		if (dossierTemplateId != null) {
			setDossierTemplateId(dossierTemplateId);
		}

		Long serviceProcessId = (Long)attributes.get("serviceProcessId");

		if (serviceProcessId != null) {
			setServiceProcessId(serviceProcessId);
		}

		String instructionNote = (String)attributes.get("instructionNote");

		if (instructionNote != null) {
			setInstructionNote(instructionNote);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getServiceOptionId() {
		return _serviceOptionId;
	}

	@Override
	public void setServiceOptionId(long serviceOptionId) {
		_serviceOptionId = serviceOptionId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getOptionCode() {
		if (_optionCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _optionCode;
		}
	}

	@Override
	public void setOptionCode(String optionCode) {
		_optionCode = optionCode;
	}

	@Override
	public String getOptionName() {
		if (_optionName == null) {
			return StringPool.BLANK;
		}
		else {
			return _optionName;
		}
	}

	@Override
	public void setOptionName(String optionName) {
		_optionName = optionName;
	}

	@Override
	public int getOptionOrder() {
		return _optionOrder;
	}

	@Override
	public void setOptionOrder(int optionOrder) {
		_optionOrder = optionOrder;
	}

	@Override
	public String getAutoSelect() {
		if (_autoSelect == null) {
			return StringPool.BLANK;
		}
		else {
			return _autoSelect;
		}
	}

	@Override
	public void setAutoSelect(String autoSelect) {
		_autoSelect = autoSelect;
	}

	@Override
	public long getDossierTemplateId() {
		return _dossierTemplateId;
	}

	@Override
	public void setDossierTemplateId(long dossierTemplateId) {
		_dossierTemplateId = dossierTemplateId;
	}

	@Override
	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	@Override
	public void setServiceProcessId(long serviceProcessId) {
		_serviceProcessId = serviceProcessId;
	}

	@Override
	public String getInstructionNote() {
		if (_instructionNote == null) {
			return StringPool.BLANK;
		}
		else {
			return _instructionNote;
		}
	}

	@Override
	public void setInstructionNote(String instructionNote) {
		_instructionNote = instructionNote;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ServiceOption.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ServiceOption.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ServiceOption toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ServiceOption)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ServiceOptionImpl serviceOptionImpl = new ServiceOptionImpl();

		serviceOptionImpl.setUuid(getUuid());
		serviceOptionImpl.setServiceOptionId(getServiceOptionId());
		serviceOptionImpl.setGroupId(getGroupId());
		serviceOptionImpl.setCompanyId(getCompanyId());
		serviceOptionImpl.setUserId(getUserId());
		serviceOptionImpl.setUserName(getUserName());
		serviceOptionImpl.setCreateDate(getCreateDate());
		serviceOptionImpl.setModifiedDate(getModifiedDate());
		serviceOptionImpl.setOptionCode(getOptionCode());
		serviceOptionImpl.setOptionName(getOptionName());
		serviceOptionImpl.setOptionOrder(getOptionOrder());
		serviceOptionImpl.setAutoSelect(getAutoSelect());
		serviceOptionImpl.setDossierTemplateId(getDossierTemplateId());
		serviceOptionImpl.setServiceProcessId(getServiceProcessId());
		serviceOptionImpl.setInstructionNote(getInstructionNote());

		serviceOptionImpl.resetOriginalValues();

		return serviceOptionImpl;
	}

	@Override
	public int compareTo(ServiceOption serviceOption) {
		long primaryKey = serviceOption.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceOption)) {
			return false;
		}

		ServiceOption serviceOption = (ServiceOption)obj;

		long primaryKey = serviceOption.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ServiceOptionModelImpl serviceOptionModelImpl = this;

		serviceOptionModelImpl._originalUuid = serviceOptionModelImpl._uuid;

		serviceOptionModelImpl._originalGroupId = serviceOptionModelImpl._groupId;

		serviceOptionModelImpl._setOriginalGroupId = false;

		serviceOptionModelImpl._originalCompanyId = serviceOptionModelImpl._companyId;

		serviceOptionModelImpl._setOriginalCompanyId = false;

		serviceOptionModelImpl._setModifiedDate = false;

		serviceOptionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ServiceOption> toCacheModel() {
		ServiceOptionCacheModel serviceOptionCacheModel = new ServiceOptionCacheModel();

		serviceOptionCacheModel.uuid = getUuid();

		String uuid = serviceOptionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			serviceOptionCacheModel.uuid = null;
		}

		serviceOptionCacheModel.serviceOptionId = getServiceOptionId();

		serviceOptionCacheModel.groupId = getGroupId();

		serviceOptionCacheModel.companyId = getCompanyId();

		serviceOptionCacheModel.userId = getUserId();

		serviceOptionCacheModel.userName = getUserName();

		String userName = serviceOptionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			serviceOptionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			serviceOptionCacheModel.createDate = createDate.getTime();
		}
		else {
			serviceOptionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			serviceOptionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			serviceOptionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		serviceOptionCacheModel.optionCode = getOptionCode();

		String optionCode = serviceOptionCacheModel.optionCode;

		if ((optionCode != null) && (optionCode.length() == 0)) {
			serviceOptionCacheModel.optionCode = null;
		}

		serviceOptionCacheModel.optionName = getOptionName();

		String optionName = serviceOptionCacheModel.optionName;

		if ((optionName != null) && (optionName.length() == 0)) {
			serviceOptionCacheModel.optionName = null;
		}

		serviceOptionCacheModel.optionOrder = getOptionOrder();

		serviceOptionCacheModel.autoSelect = getAutoSelect();

		String autoSelect = serviceOptionCacheModel.autoSelect;

		if ((autoSelect != null) && (autoSelect.length() == 0)) {
			serviceOptionCacheModel.autoSelect = null;
		}

		serviceOptionCacheModel.dossierTemplateId = getDossierTemplateId();

		serviceOptionCacheModel.serviceProcessId = getServiceProcessId();

		serviceOptionCacheModel.instructionNote = getInstructionNote();

		String instructionNote = serviceOptionCacheModel.instructionNote;

		if ((instructionNote != null) && (instructionNote.length() == 0)) {
			serviceOptionCacheModel.instructionNote = null;
		}

		return serviceOptionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", serviceOptionId=");
		sb.append(getServiceOptionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", optionCode=");
		sb.append(getOptionCode());
		sb.append(", optionName=");
		sb.append(getOptionName());
		sb.append(", optionOrder=");
		sb.append(getOptionOrder());
		sb.append(", autoSelect=");
		sb.append(getAutoSelect());
		sb.append(", dossierTemplateId=");
		sb.append(getDossierTemplateId());
		sb.append(", serviceProcessId=");
		sb.append(getServiceProcessId());
		sb.append(", instructionNote=");
		sb.append(getInstructionNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("org.opencps.backend.dossiermgt.model.ServiceOption");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceOptionId</column-name><column-value><![CDATA[");
		sb.append(getServiceOptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionCode</column-name><column-value><![CDATA[");
		sb.append(getOptionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionName</column-name><column-value><![CDATA[");
		sb.append(getOptionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionOrder</column-name><column-value><![CDATA[");
		sb.append(getOptionOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>autoSelect</column-name><column-value><![CDATA[");
		sb.append(getAutoSelect());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierTemplateId</column-name><column-value><![CDATA[");
		sb.append(getDossierTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceProcessId</column-name><column-value><![CDATA[");
		sb.append(getServiceProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>instructionNote</column-name><column-value><![CDATA[");
		sb.append(getInstructionNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ServiceOption.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ServiceOption.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _serviceOptionId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _optionCode;
	private String _optionName;
	private int _optionOrder;
	private String _autoSelect;
	private long _dossierTemplateId;
	private long _serviceProcessId;
	private String _instructionNote;
	private long _columnBitmask;
	private ServiceOption _escapedModel;
}