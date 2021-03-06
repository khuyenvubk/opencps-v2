<div class="panel">
	<div class="panel-heading P0">
		<div class="row">
			<div class="row-header"> <div class="background-triangle-big">Tên thủ tục</div> <span>KÊT QUẢ TÌM KIÊM HÔ SƠ</span> 
			<div class="form-group search-icon pull-right MR10">
				<input type="text" class="form-control" placeholder="Nhập từ khóa">
			</div>
		</div>
	</div>
</div>
<div class="panel-body PT0">
	<input type="hidden" name="idItemCustomerDossier" id="idItemCustomerDossier">
	<ul class='ul-with-border'>
		<div id='listViewProfile'></div>
	</ul>
	<div id='pagerProfile'></div>

	<script type="text/x-kendo-template" id="proFileTemplate">
		<div class="row itemCustomerDossierList" dataPk="#:id#">
			<div class="row">
				<div class="row-blue align-middle">
					<div class="order-number">123</div>
					<div class="dossier-number" data-toggle="tooltip" title="Mã hồ sơ"><span class="red">\\#</span> #:serviceCode#</div>
					<div class="receive-number"><span class="text-normal">Mã tiếp nhận:</span> #:referenceUid#</div>
					#
						var label="label-info";
						if(dossierStatus=="cbs"){
							label="label-warning";
						}else if(dossierStatus=="ctt"){
							label="label-danger";
						}else if(dossierStatus=="ht"){
							label="label-success";
						}else if(dossierStatus=="dh"){
							label="label-default";
						}else{
							label="label-info";
						}
					#
					<span class="label #:label# MLA"><#-- #:dosierStatusText# -->Hoàn thành</span> 
				</div>
			</div>
			<div class="col-sm-12 PT5 PB10">
				<div class="row">
					<div class="col-sm-8">
						<p>#:serviceName#</p>
						<p>
							<i class="fa fa-university" style="color: \\#84FAFA;" aria-hidden="true"></i> #:govAgencyName#
						</p>
						<p>
							<i class="fa fa-bolt" aria-hidden="true" style="color: red;"></i> 
							<i>#:dossierSubStatusText#</i>
						</p>
						# if (dossierOverdue) { #
						<p>
							<i>Hồ sơ này sẽ được giải quyết trong vòng #:overDue# ngày, khi đó bạn hãy đến cơ quan tiếp nhận hồ sơ để lấy kết quả khi hồ sơ hoàn tất 
							</i>
						</p>
						# } #.

						<a href="${api.server}/dossiers/#:id#/result" style="margin-right: 10px;">
							<i class="fa fa-download" aria-hidden="true">
							</i> Tải giấy tờ kết quả
						</a>

						<a href="javascript:;" onclick="javascript:copyProfile(#:id#)"><i class="fa fa-file-archive-o" aria-hidden="true"></i> Sao chép hồ sơ
						</a>
					</div>
					<div class="col-sm-4 MT10 text-right">
						<div class="row">
							<p data-toggle="tooltip" title="Ngày gửi">
								<i class="fa fa-paper-plane-o" aria-hidden="true"></i> #:submitDate#
							</p>
							<p data-toggle="tooltip" title="Ngày tiếp nhận">
								<i class="fa fa-file-o" aria-hidden="true"></i> #:receiveDate#
							</p>
							<p data-toggle="tooltip" title="Ngày hẹn trả">
								<i class="fa fa-clock-o" aria-hidden="true"></i> #:dueDate#
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>

	</script>
</div>
</div>

<script type="text/javascript">	
	var dataSourceProfile=new kendo.data.DataSource({
		transport:{
			read:function(options){
				$.ajax({
					url:"${api.server}/dossiers",
					dataType:"json",
					type:"GET",
					data:{
						statusCode:options.data.statusCode,
						serviceInfo:options.data.serviceInfo,
						receiptCode:options.data.receiptCode,
						startDate:options.data.startDate,
						endDate:options.data.endDate,
						keyword:options.data.keyword
					},	
					success:function(result){
						options.success(result);
						console.log(options);
					},
					error:function(result){
						console.log(options);
						options.error(result);
					}
				});
			}
		},
		error: function(e) {         
			this.cancelChanges();
		},
		pageSize:7,
		schema:{
			data:"data",
			total:"total",
			model:{
				id:"dossierId"
			}
		}
	});

	$("#listViewProfile").kendoListView({
		dataSource:dataSourceProfile,
		template:kendo.template($("#proFileTemplate").html()),
		selectable: "single",
		/*remove:function(e){
			if(!confirm('Bạn có muốn xóa ?')){
				e.preventDefault();
			}
		},*/
		autoBind: false,
		change:function(){

		}
	});

	$("#pagerProfile").kendoPager({
		dataSource:dataSourceProfile,
		input: true,
		numeric: false,
		messages: {
			empty: "Không có kết quả phù hợp!",
			display: "Hiển thị {0}-{1} trong {2} bản ghi",
			page: "",
			of: "/ {0}"
		}
	});

	$(document).on("click",".itemCustomerDossierList",function(event){
		var id=$(this).attr("dataPk");	
		$("#idItemCustomerDossier").val(id);
		$("#dossier_detail").show();
		$("#dossier_list").hide();
		$("#dossier_detail").load("${ajax.customer_dossier_detail}?id="+id+"",function(result){
			dataSourceDossiserFileTemplate.read({
				id:id
			});
			dataSourceDossiserLog.read({
				id:id
			});
		});
	});

	$(document).ready(function(){
		$('[data-toggle="tooltip"]').tooltip(); 
	});

	var copyProfile=function(id){
		$.ajax({
			url:"${api.server}/"+id+"/cloning",
			dataType:"json",
			type:"GET",
			success:function(result){
				location.href = "http://www.google.com";
			},
			error:function(result){

			}
		});
	}
</script>