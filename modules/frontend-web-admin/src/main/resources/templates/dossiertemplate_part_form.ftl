<#if (Request)??>
<#include "init.ftl">
</#if>

<div class="row">
	<div class="col-xs-12 col-sm-12">
		<h4>Thêm mới thành phần hồ sơ</h4>
	</div>
</div>
<div id="dossier_template_part_model">
	<form id="fm">
		<div class="row">
			<div class="col-xs-12 col-sm-8">
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						Số thành phần
					</div>
				</div>
				<div class="row MT5">
					<div class="col-xs-12 col-sm-12">
						<input id="partNo" name="partNo" class="k-textbox form-control" required="required" validationMessage="Trường nhập yêu cầu bắt buộc" data-bind="value:partNo"/>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-4">
				<div class="row">
					<div class="col-xs-12 col-sm-12 invisible">invisible</div>
				</div>
				<div class="row MT5">
					<div class="col-xs-12 col-sm-12">
						<div class="checkbox MB0 MT5"> <input type="checkbox" id="required" name="required" data-bind="checked:required"> <label>Bắt buộc</label> </div>
					</div>
				</div>
			</div>
		</div>
		<div class="row MT10">
			<div class="col-xs-12 col-sm-12">
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						Tên thành phần
					</div>
				</div>
				<div class="row MT5">
					<div class="col-xs-12 col-sm-12">
						<input id="partName" name="partName" class="k-textbox form-control" required="required" validationMessage="Trường nhập yêu cầu bắt buộc" data-bind="value:partName"/>
					</div>
				</div>
			</div>
		</div>
		<div class="row MT10">
			<div class="col-xs-12 col-sm-12">
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						Hướng dẫn thành phần hồ sơ
					</div>
				</div>
				<div class="row MT5">
					<div class="col-xs-12 col-sm-12">
						<textarea id="partTip" name="partTip" class="k-textbox form-control" required="required" validationMessage="Trường nhập yêu cầu bắt buộc" data-bind="value:partTip" />
					</div>
				</div>
			</div>
		</div>
		<div class="row MT10">
			<div class="col-xs-12 col-sm-4">
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						Kiểu thành phần hồ sơ
					</div>
				</div>
				<div class="row MT5">
					<div class="col-xs-12 col-sm-12">
						<input id="partType" name="partType" class="k-textbox form-control" required="required" validationMessage="Trường nhập yêu cầu bắt buộc" data-bind="value:partType"/>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-4">
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						Mã mẫu tài liệu
					</div>
				</div>
				<div class="row MT5">
					<div class="col-xs-12 col-sm-12">
						<input id="fileTemplateNo" name="fileTemplateNo" class="k-textbox form-control" required="required" validationMessage="Trường nhập yêu cầu bắt buộc" data-bind="value:fileTemplateNo"/>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-4">
				<div class="row">
					<div class="col-xs-12 col-sm-12 invisible">invisible</div>
				</div>
				<div class="row MT5">
					<div class="col-xs-12 col-sm-12">
						<div class="checkbox MB0 MT5"> <input type="checkbox" id="esign" name="esign" data-bind="checked:esign"> <label>Yêu cầu chữ ký số</label> </div>
					</div>
				</div>
			</div>
		</div>
		<div class="row MT10">
			<div class="col-xs-12 col-sm-12">
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						Mã tạo form
					</div>
				</div>
				<div class="row MT5">
					<div class="col-xs-12 col-sm-12">
						<textarea id="formScript" name="formScript" class="k-textbox form-control" data-bind="value:formScript"></textarea>
					</div>
				</div>
			</div>
		</div>
		<div class="row MT10">
			<div class="col-xs-12 col-sm-12">
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						Mã thiết kế xml jasper
					</div>
				</div>
				<div class="row MT5">
					<div class="col-xs-12 col-sm-12">
						<textarea id="formReport" name="formReport" class="k-textbox form-control" data-bind="value:formReport"></textarea>
					</div>
				</div>
			</div>
		</div>
		<div class="row MT10">
			<div class="col-xs-12 col-sm-12">
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						Dữ liệu mẫu
					</div>
				</div>
				<div class="row MT5">
					<div class="col-xs-12 col-sm-12">
						<textarea id="sampleData" name="sampleData" class="k-textbox form-control" data-bind="value:sampleData"></textarea>
					</div>
				</div>
			</div>
		</div>
		<div class="row MT10 text-center">
			<button id="btn_save_dossier_template_part" class="k-button btn-primary" title="Ghi lại">Ghi lại</button>
			<button id="btn_cancle_dossier_template_part" class="k-button btn-default" title="Hủy bỏ">Hủy bỏ</button>
		</div>
	</form>
</div>

<script type="text/javascript">
	$(document).on("click", "#btn_cancle_dossier_template_part", function(event){
		event.preventDefault();
		$("#dossiertemplate_part_container").show();
		$("#dossiertemplate_part_form_container").hide();
	});

	$(document).on("click", "#btn_save_dossier_template_part", function(event){
		event.preventDefault();
		var dossierTemplateDataPk = $("#btn_save_dossier_template").attr("data-pk");
		var dossierTemplatePartDataPk = $(this).attr("data-pk");
		updateDossierTemplatePart(dossierTemplateDataPk, dossierTemplatePartDataPk);
	});

	var updateDossierTemplatePart = function(dossierTemplateDataPk, dossierTemplatePartDataPk){

		var url = "";
		var type = "";
		if (dossierTemplateDataPk){
			if (dossierTemplatePartDataPk){
				url = "${api.server}" + "/dossiertemplates/" + dossierTemplateDataPk + "/parts/" + dossierTemplatePartDataPk;
				type = "PUT";
			} else {
				url = "${api.server}" + "/dossiertemplates/" + dossierTemplateDataPk + "/parts";
				type = "POST";
			}
		}

		$.ajax({
			url: url,
			type: type,
			dataType: "json",
			headers: {"groupId": ${groupId}},
			data: {
				partNo: $("#partNo").val(),
				partName: $("#partName").val(),
				partTip: $("#partTip").val(),
				partType: $("#partType").val(),
				fileTemplateNo: $("#fileTemplateNo").val(),
				required: $('#required').is(':checked'),
				esign: $('#esign').is(':checked'),
			},
			success: function(result) {
				notification.show({
					message: "Yêu cầu được thực hiện thành công"
				}, "success");

				var upFormscriptSuccess = false, upFormReportSuccess = false, upSampleDataSuccess = false;
				$.ajax({
					url: "${api.server}" + "/dossiertemplates/" + dossierTemplateDataPk + "/parts/" + dossierTemplatePartDataPk + "/formscript",
					type: "PUT",
					dataType: "json",
					headers: {"groupId": ${groupId}},
					async: false,
					data: {
						value: $("#formScript").val()
					},
					success: function(result) {
						upFormscriptSuccess = true;
					}
				});
				$.ajax({
					url: "${api.server}" + "/dossiertemplates/" + dossierTemplateDataPk + "/parts/" + dossierTemplatePartDataPk + "/formreport",
					type: "PUT",
					dataType: "json",
					headers: {"groupId": ${groupId}},
					async: false,
					data: {
						value: $("#formReport").val()
					},
					success: function(result) {
						upFormReportSuccess = true;
					}
				});
				$.ajax({
					url: "${api.server}" + "/dossiertemplates/" + dossierTemplateDataPk + "/parts/" + dossierTemplatePartDataPk + "/sampledata",
					type: "PUT",
					dataType: "json",
					headers: {"groupId": ${groupId}},
					async: false,
					data: {
						value: $("#sampleData").val()
					},
					success: function(result) {
						upSampleDataSuccess = true;
					}
				});

				if (upFormscriptSuccess && upFormReportSuccess && upSampleDataSuccess){
					$("#dossiertemplate_part_container").show();
					$("#dossiertemplate_part_form_container").hide();

					$("#dossier_template_part_listview").data("kendoListView").dataSource.read({dossierTemplateId: dossierTemplateDataPk});
				} else {
					notification.show({
						message: "Xẩy ra lỗi, vui lòng thử lại"
					}, "error");
				}

			},
			error: function(result) {
				notification.show({
					message: "Xẩy ra lỗi, vui lòng thử lại"
				}, "error");
			}
		});
	};
</script>
