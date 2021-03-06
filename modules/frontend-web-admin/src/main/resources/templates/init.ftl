<#if (Request)??>
<#assign aui = PortletJspTagLibs["/META-INF/liferay-aui.tld"] />
<#assign liferay_portlet = PortletJspTagLibs["/META-INF/liferay-portlet-ext.tld"] />
<#assign liferay_security = PortletJspTagLibs["/META-INF/liferay-security.tld"] />
<#assign liferay_theme = PortletJspTagLibs["/META-INF/liferay-theme.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign liferay_util = PortletJspTagLibs["/META-INF/liferay-util.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@liferay_theme["defineObjects"] />

<@portlet["defineObjects"] />

<#assign ajax = (Request.ajax)!>
<#assign api = (Request.api)!>
<#assign serviceInfoStatuses = (Request.serviceInfoStatuses)!>
<#assign serviceInfo = (Request.SERVICE_INFO)!>
<#assign portletNamespace = (Request.portletNamespace)!>

<#assign groupId = themeDisplay.getScopeGroupId() />
<#assign userId = themeDisplay.getUserId() />
<#assign currentURL = themeDisplay.getURLCurrent() />
<#assign request = themeDisplay.getRequest() />
<#assign portalURL = (themeDisplay.getPortalURL())!>

<!--INIT EMPLOYEE-->
<#if Request.employee_workingStatus??>
<#assign employee_workingStatus = Request.employee_workingStatus>
</#if>

<#if Request.employee??>
<#assign employee = Request.employee>
</#if>

<#if Request.employee_accountInfo??>
<#assign employee_accountInfo = Request.employee_accountInfo>
</#if>

<#if Request.employee_jobPos??>
<#assign employee_jobPos = Request.employee_jobPos>
</#if>

<#assign url = Request.url?eval>
<#assign api = Request.api?eval>
<#if Request.params??>
<#assign params = Request.params?eval>
</#if>
<#if Request.constants??>
<#assign constants = Request.constants?eval>
</#if>

<!--INIT  WORKING UNIT-->

<#assign url = Request.url?eval>
<#assign api = Request.api?eval>

<#if Request.activityType_dictItem??>
<#assign activityType_dictItem = Request.activityType_dictItem>
</#if>

<#if Request.dictCollection_dictItem??>
<#assign dictCollection_dictItem = Request.dictCollection_dictItem>
</#if>

<#if Request.documentType_dictItem??>
<#assign documentType_dictItem = Request.documentType_dictItem>
</#if>

<#if Request.dictCollection_dictCollection??>
<#assign dictCollection_dictCollection = Request.dictCollection_dictCollection>
</#if>

<#if Request.dictCollection_dictGroup??>
<#assign dictCollection_dictGroup = Request.dictCollection_dictGroup>
</#if>

<#if Request.label??>
<#assign label = Request.label>
</#if>

<#if Request.location??>
<#assign location = Request.location>
</#if>

<#if Request.notificationTemplate??>
<#assign notificationTemplate = Request.notificationTemplate>
</#if>

<#if Request.workspace??>
<#assign workspace = Request.workspace>
</#if>

<#if Request.officeSite??>
<#assign officeSite = Request.officeSite>
</#if>

<#if Request.workingUnit??>
<#assign workingUnit = Request.workingUnit>
</#if>

<#if Request.contact??>
<#assign contact = Request.contact>
</#if>

<#if Request.jobPos??>
<#assign jobPos = Request.jobPos>
</#if>

<#if Request.param??>
<#assign param = Request.param?eval>
</#if>

<#if Request.constant??>
<#assign constant = Request.constant?eval>
</#if>

<#if Request.workspace_jobposes??>
<#assign workspace_jobposes = Request.workspace_jobposes>
</#if>

<#-- <#assign api = Request.api?eval>
<#assign groupId = Request.groupId>
<#assign userId = Request.userId>
<#assign isOmniadmin = Request.isOmniadmin>
<#assign portletNamespace = Request.portletNamespace> -->
</#if>

<!-- popup notification -->
<!-- container -->
<span id="notification" style="display:none;"></span>

<!-- templates -->
<script id="errorTemplate" type="text/x-kendo-template">
  <div class="popup-error-notification">
    <p>#= message #</p>
  </div>
</script>

<script id="successTemplate" type="text/x-kendo-template">
  <div class="popup-success-notification">
    <p>#= message #</p>
  </div>
</script>

<!-- script -->
<script type="text/javascript">
	// notification
  var notification;
  $(document).ready(function() {
    notification = $("#notification").kendoNotification({
      position: {
        pinned: true,
        top: 30,
        right: 30
      },
      autoHideAfter: 3500,
      stacking: "down",
      templates: [
      {
        type: "success",
        template: $("#successTemplate").html()
      },
      {
        type: "error",
        template: $("#errorTemplate").html()
      }
      ]
    }).data("kendoNotification");

    // kendo combo box auto open when click
    $("[data-role=combobox]").each(function() {
      var widget = $(this).getKendoComboBox();
      widget.input.on("focus", function() {
        widget.open();
      });
    });
  });
</script>

<style type="text/css">
    /* Over the pointer-events:none, set the cursor to not-allowed.
    On this way you will have a more user friendly cursor. */
    .disabled-tab {
      cursor: not-allowed;
    }
    /* Clicks are not permitted and change the opacity. */
    li.disabled-tab > a[data-toggle="tab"] {
      pointer-events: none;
      filter: alpha(opacity=65);
      -webkit-box-shadow: none;
      box-shadow: none;
      opacity: .65;
    }
  </style>
