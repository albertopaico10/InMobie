<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="index.html">Menu</a></li>
			<c:if test="${not empty listRestaurantPending}">
				<li><a href="#"><spring:message code="private.left.option.mantenience.restaurant" /></a></li>
			</c:if>
			<c:if test="${not empty listProviderPending}">
				<li><a href="#"><spring:message code="private.left.option.mantenience.provider" /></a></li>
			</c:if>
			<li><a href="#"><spring:message code="private.left.option.mantenience.common.active" /></a></li>
		</ol>
	</div>
</div>
<div class="well">
	<div class="row">
		<c:if test="${messages == 'EMPTY_LIST_RESTAURANT_PENDING_ACTIVE'}">
			<label class="error"><spring:message code="list.pending.activerestaurant" /></label>
		</c:if>
		<c:if test="${messages == 'EMPTY_LIST_PROVIDER_PENDING_ACTIVE'}">
			<label class="error"><spring:message code="list.pending.activerestaurant" /></label>
		</c:if>
		<c:if test="${messages == 'SUCCESS_CHECK_REST'}">
			<label class="error"><spring:message code="list.update.activerestaurant.correct" /></label>
		</c:if>
	</div>
	<div class="row">
		<div class="col-lg-4 col-lg-offset-4">
			<input type="search" id="search" value="" class="form-control"
				placeholder="Introduce un criterio de busqueda">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<table class="table" id="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Razon Social</th>
						<th>Nombre Contacto</th>
						<th>RUC</th>
						<th>Dirección</th>
						<th>Distrito</th>
						<th>Activar</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty listRestaurantPending}">
						<c:forEach items="${listRestaurantPending}" var="listRestaurantData">
							<tr>
								<td>${listRestaurantData.id}</td>
								<td>${listRestaurantData.socialReason}</td>
								<td>${listRestaurantData.nameContact}</td>
								<td>${listRestaurantData.ruc}</td>
								<td>${listRestaurantData.address}</td>
								<td>${listRestaurantData.districtNameSpecific}</td>
								<td><a id="lnkDetail" href="javascript:getCheckValuesForRestaurant('${listRestaurantData.id}');">
										<img src="${pageContext.request.contextPath}/resources/bootstrap/img/activeImage.png" alt="HTML tutorial" style="width:20px;height:20px;border:0">
									</a></td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${not empty listProviderPending}">
					<c:forEach items="${listProviderPending}" var="listProviderData">
							<tr>
								<td>${listProviderData.id}</td>
								<td>${listProviderData.socialReason}</td>
								<td>${listProviderData.nameContact}</td>
								<td>${listProviderData.ruc}</td>
								<td>${listProviderData.address}</td>
								<td>${listProviderData.districtNameSpecific}</td>
								<td>
									<a id="lnkDetail" href="javascript:getCheckValuesForProvider('${listProviderData.id}');">
										<img src="${pageContext.request.contextPath}/resources/bootstrap/img/activeImage.png" alt="HTML tutorial" style="width:20px;height:20px;border:0">
									</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>
<div id="showDetailActiveByRestaruant" class="modal fade" style="display: none">
</div>
<div id="showDetailActiveByProvider" class="modal fade" style="display: none">
</div>
<script>
function getCheckValuesForProvider(idProvider){
	$('#showDetailActiveByProvider').modal('show');    
	$("showDetailActiveByProvider").append("");
	$.ajax({
		url : "${pageContext.request.contextPath}/getCheckValuesProvider.htm?idProvider="+ idProvider,
		data : null,
		type : "GET",
		dataType : "json",
		success : function(data) {
				$("#showDetailActiveByProvider").empty();
			 	var checkDiv="";
			 	checkDiv = "<div class='modal-dialog'><div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
			 	checkDiv=checkDiv+"<h4 class='modal-title'>** Check Restaurant</h4></div><div class='modal-body'>";
			 	checkDiv=checkDiv+'<html:form method="POST" commandName="checkProvForm" action="saveCheckProvider.htm" id="idCheckProvForm" novalidate="novalidate">';
			 	for(var i = 0; i < data.length; i++) {
			 		if(data[i].beanCheckProviderActive.manualReception==0){
			 			checkDiv=checkDiv+"<input type='checkbox' name='manualReception' value='0' id='manualReception'><span><spring:message code='active.restaurant.manual' /></span><br>";
			 		}else{
			 			checkDiv=checkDiv+"<input type='checkbox' name='manualReception' value='1' checked='checked' id='manualReception'><span><spring:message code='active.restaurant.manual' /></span><br>";
			 		}
			 		if(data[i].beanCheckProviderActive.training==0){
			 			checkDiv=checkDiv+"<input type='checkbox' name='training' value='0' id='training'><span><spring:message code='active.restaurant.training' /></span><br>";
			 		}else{
			 			checkDiv=checkDiv+"<input type='checkbox' name='training' value='1' checked='checked' id='training'><span><spring:message code='active.restaurant.training' /></span><br>";
			 		}
					if(data[i].beanCheckProviderActive.verificationAddress==0){
						checkDiv=checkDiv+"<input type='checkbox' name='verificationAddress' value='0' id='verificationAddress'><span><spring:message code='active.restaurant.verificationAddress' /></span><br>";
			 		}else{
			 			checkDiv=checkDiv+"<input type='checkbox' name='verificationAddress' value='1' checked='checked' id='verificationAddress'><span><spring:message code='active.restaurant.verificationAddress' /></span><br>";
			 		}
					if(data[i].beanCheckProviderActive.verificationSunat==0){
						checkDiv=checkDiv+"<input type='checkbox' name='verificationSunat' value='0' id='verificationSunat'><span><spring:message code='active.restaurant.verificationSunat' /></span><br>";
			 		}else{
			 			checkDiv=checkDiv+"<input type='checkbox' name='verificationSunat' value='1' checked='checked' id='verificationSunat'><span><spring:message code='active.restaurant.verificationSunat' /></span><br>";
			 		}
					if(data[i].beanCheckProviderActive.verificationUser==0){
						checkDiv=checkDiv+"<input type='checkbox' name='verificationUser' value='0' id='verificationUser'><span><spring:message code='active.restaurant.verificationUser' /></span><br>";
			 		}else{
			 			checkDiv=checkDiv+"<input type='checkbox' name='verificationUser' value='1' checked='checked' id='verificationUser'><span><spring:message code='active.restaurant.verificationUser' /></span><br>";
			 		}
					checkDiv=checkDiv+"<br>";
					checkDiv=checkDiv+'<select name="idMembershipPlan" id="idMembershipPlan" class="form-control">';
					for(var j = -1; j<data[i].listPlanMenber.length; j++){
// 						checkDiv=checkDiv+"***"+data[i].listPlanMenber[j].valuePlanMenber+"***"+data[i].listPlanMenber[j].id+"<br>";
						var valuePlanMember=data[i].beanCheckProviderActive.idMembershipPlan;
						if(j==-1){
							checkDiv=checkDiv+'<option value="0"><spring:message code="register.restaurant.district.option.0"/></option>';
						}else if(valuePlanMember-1==j){
							checkDiv=checkDiv+'<option value="'+data[i].listPlanMenber[j].id+'" selected="selected"><span>'+data[i].listPlanMenber[j].valuePlanMenber+'</span></option>';
						}else{
							checkDiv=checkDiv+'<option value="'+data[i].listPlanMenber[j].id+'"><span>'+data[i].listPlanMenber[j].valuePlanMenber+'</span></option>';
						}
					}
// 					checkDiv=checkDiv+"<input type='text' name='idMembershipPlan' value='"+data[i].beanCheckRestaurantActive.idMembershipPlan+"'/>";
					
					checkDiv=checkDiv+'</select>';
					checkDiv = checkDiv+ '<input type="hidden" name="providerId" class="form-control input-lg" id="providerId" value="'+idProvider+'"/>';
				 	checkDiv = checkDiv+ '<input type="hidden" name="idCheck" class="form-control input-lg" id="idCheck" value="'+data[i].beanCheckProviderActive.id+'"/>';
				 	checkDiv = checkDiv+ '<input type="hidden" name="updateStatus" class="form-control input-lg" id="updateStatus"/>';
			 	}
			 	checkDiv = checkDiv+ "<br>";
// 			 	checkDiv = checkDiv+ "<button type='submit' class='btn btn-primary btn-lg btn-block'><spring:message code="common.value.accept" /></button>";
			 	checkDiv = checkDiv+"<div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>";
			 	checkDiv = checkDiv+"<button type='submit' class='btn btn-primary' onclick='validateCheck();'>Save changes</button></div>";
			 	checkDiv = checkDiv+ "</html:form>";
			 	checkDiv = checkDiv+ "</div>";
			 	checkDiv = checkDiv+ "</div>";
			 	$("#showDetailActiveByProvider").append(checkDiv);
			 	$('#showDetailActiveByProvider').modal('show');    
			},
		error: function (request, status, error) {
			alert("Error : "+request.responseText);
			}
		});
}

</script>
<script>
function getCheckValuesForRestaurant(idRestaurant){
	$('#showDetailActiveByRestaruant').modal('show');    
	$("showDetailActiveByRestaruant").append("");
	$.ajax({
		url : "${pageContext.request.contextPath}/getCheckValues.htm?idRestaurant="+ idRestaurant,
		data : null,
		type : "GET",
		dataType : "json",
		success : function(data) {
				$("#showDetailActiveByRestaruant").empty();
			 	var checkDiv="";
			 	checkDiv = "<div class='modal-dialog'><div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
			 	checkDiv=checkDiv+"<h4 class='modal-title'>** Check Restaurant</h4></div><div class='modal-body'>";
			 	checkDiv=checkDiv+'<html:form method="POST" commandName="checkRestForm" action="saveCheckRestaurant.htm" id="idCheckRestForm" novalidate="novalidate">';
			 	for(var i = 0; i < data.length; i++) {
			 		if(data[i].beanCheckRestaurantActive.manualReception==0){
			 			checkDiv=checkDiv+"<input type='checkbox' name='manualReception' value='0' id='manualReception'><span><spring:message code='active.restaurant.manual' /></span><br>";
			 		}else{
			 			checkDiv=checkDiv+"<input type='checkbox' name='manualReception' value='1' checked='checked' id='manualReception'><span><spring:message code='active.restaurant.manual' /></span><br>";
			 		}
			 		if(data[i].beanCheckRestaurantActive.training==0){
			 			checkDiv=checkDiv+"<input type='checkbox' name='training' value='0' id='training'><span><spring:message code='active.restaurant.training' /></span><br>";
			 		}else{
			 			checkDiv=checkDiv+"<input type='checkbox' name='training' value='1' checked='checked' id='training'><span><spring:message code='active.restaurant.training' /></span><br>";
			 		}
					if(data[i].beanCheckRestaurantActive.verificationAddress==0){
						checkDiv=checkDiv+"<input type='checkbox' name='verificationAddress' value='0' id='verificationAddress'><span><spring:message code='active.restaurant.verificationAddress' /></span><br>";
			 		}else{
			 			checkDiv=checkDiv+"<input type='checkbox' name='verificationAddress' value='1' checked='checked' id='verificationAddress'><span><spring:message code='active.restaurant.verificationAddress' /></span><br>";
			 		}
					if(data[i].beanCheckRestaurantActive.verificationSunat==0){
						checkDiv=checkDiv+"<input type='checkbox' name='verificationSunat' value='0' id='verificationSunat'><span><spring:message code='active.restaurant.verificationSunat' /></span><br>";
			 		}else{
			 			checkDiv=checkDiv+"<input type='checkbox' name='verificationSunat' value='1' checked='checked' id='verificationSunat'><span><spring:message code='active.restaurant.verificationSunat' /></span><br>";
			 		}
					if(data[i].beanCheckRestaurantActive.verificationUser==0){
						checkDiv=checkDiv+"<input type='checkbox' name='verificationUser' value='0' id='verificationUser'><span><spring:message code='active.restaurant.verificationUser' /></span><br>";
			 		}else{
			 			checkDiv=checkDiv+"<input type='checkbox' name='verificationUser' value='1' checked='checked' id='verificationUser'><span><spring:message code='active.restaurant.verificationUser' /></span><br>";
			 		}
					checkDiv=checkDiv+"<br>";
					checkDiv=checkDiv+'<select name="idMembershipPlan" id="idMembershipPlan" class="form-control">';
					for(var j = -1; j<data[i].listPlanMenber.length; j++){
// 						checkDiv=checkDiv+"***"+data[i].listPlanMenber[j].valuePlanMenber+"***"+data[i].listPlanMenber[j].id+"<br>";
						var valuePlanMember=data[i].beanCheckRestaurantActive.idMembershipPlan;
						if(j==-1){
							checkDiv=checkDiv+'<option value="0"><spring:message code="register.restaurant.district.option.0"/></option>';
						}else if(valuePlanMember-1==j){
							checkDiv=checkDiv+'<option value="'+data[i].listPlanMenber[j].id+'" selected="selected"><span>'+data[i].listPlanMenber[j].valuePlanMenber+'</span></option>';
						}else{
							checkDiv=checkDiv+'<option value="'+data[i].listPlanMenber[j].id+'"><span>'+data[i].listPlanMenber[j].valuePlanMenber+'</span></option>';
						}
					}
// 					checkDiv=checkDiv+"<input type='text' name='idMembershipPlan' value='"+data[i].beanCheckRestaurantActive.idMembershipPlan+"'/>";
					
					checkDiv=checkDiv+'</select>';
					checkDiv = checkDiv+ '<input type="hidden" name="restaurantId" class="form-control input-lg" id="restaurantId" value="'+idRestaurant+'"/>';
				 	checkDiv = checkDiv+ '<input type="hidden" name="idCheck" class="form-control input-lg" id="idCheck" value="'+data[i].beanCheckRestaurantActive.id+'"/>';
				 	checkDiv = checkDiv+ '<input type="hidden" name="updateStatus" class="form-control input-lg" id="updateStatus"/>';
			 	}
			 	checkDiv = checkDiv+ "<br>";
// 			 	checkDiv = checkDiv+ "<button type='submit' class='btn btn-primary btn-lg btn-block'><spring:message code="common.value.accept" /></button>";
			 	checkDiv = checkDiv+"<div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>";
			 	checkDiv = checkDiv+"<button type='submit' class='btn btn-primary' onclick='validateCheck();'>Save changes</button></div>";
			 	checkDiv = checkDiv+ "</html:form>";
			 	checkDiv = checkDiv+ "</div>";
			 	checkDiv = checkDiv+ "</div>";
			 	$("#showDetailActiveByRestaruant").append(checkDiv);
			 	$('#showDetailActiveByRestaruant').modal('show');    
			},
		error: function (request, status, error) {
			alert("Error : "+request.responseText);
			}
		});
}
function validateCheck(){
	if ($('#manualReception').prop('checked')) {
		$("#manualReception").val("1");
	}
	if ($('#training').prop('checked')) {
		$("#training").val("1");
	}
	if ($('#verificationSunat').prop('checked')) {
		$("#verificationSunat").val("1");
	}
	if ($('#verificationAddress').prop('checked')) {
		$("#verificationAddress").val("1");
	}
	if ($('#verificationUser').prop('checked')) {
		$("#verificationUser").val("1");
	}
	if($('#manualReception').prop('checked')&&$('#training').prop('checked')&&$('#verificationSunat').prop('checked')
			&&$('#verificationAddress').prop('checked')&&$('#verificationUser').prop('checked')){
		$('#updateStatus').val("1");
	}else{
		$('#updateStatus').val("0");
	}
}
</script>