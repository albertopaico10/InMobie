<%@ include file="/WEB-INF/common/taglib.jsp"%>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
<div>

<div class="well">
	<h3 id="grid-options"><spring:message code="common.title.welcome" /></h3>
	<br/>
	<html:form method="POST" modelAttribute="restaurantForm" action="registerRestaurant.htm" id="idRestaurantForm" novalidate="novalidate" enctype="multipart/form-data">
		<p><b><spring:message code="common.title.accommodation.information" /></b></p>
		<div class="row show-grid-forms">
			<div class="col-sm-3">
				<spring:message code="common.label.social.reason" var="socialReasonP"/>
				<html:input path="socialReason" maxlength="60"  class="form-control input-lg" id="socialReason" placeholder="${socialReasonP}" />
			</div>
			<div class="col-sm-3">
				<spring:message code="common.label.address" var="addressP"/>
				<html:input path="address" maxlength="60"  class="form-control input-lg" id="address" placeholder="${addressP}" />
			</div>
			<div class="col-sm-3">
<%-- 				<spring:message code="common.label.department" var="departmentP"/> --%>
<%-- 				<html:input path="department" maxlength="60"  class="form-control input-lg" id="department" placeholder="${departmentP}"/> --%>
				<html:select path="department" id="department" class="form-control"> 
					<html:option value="0">
						<spring:message code="register.restaurant.department.option.0"/>
					</html:option>
					<html:options items="${listAllDepartment}" itemLabel="nameDepartment" itemValue="idDepartment" />
				</html:select> 
			</div>
		</div>
		<div class="row show-grid-forms">
			<div class="col-sm-3">
				<spring:message code="common.label.comercial.name" var="comercialNameP"/>
				<html:input path="comercialName" maxlength="60"  class="form-control input-lg" id="comercialName" placeholder="${comercialNameP}"/>
			</div>
			<div class="col-sm-3">
				<spring:message code="common.label.phone" var="phoneP"/>
				<html:input path="phone" maxlength="10"  class="form-control input-lg" id="phone" placeholder="${phoneP}"/>
			</div>
			<div class="col-sm-3">
<%-- 				<spring:message code="common.label.province" var="provinceP"/> --%>
<%-- 				<html:input path="province" maxlength="60"  class="form-control input-lg" id="province" placeholder="${provinceP}"/> --%>
				<html:select path="province" id="province" class="form-control">
					<html:option value="0">
						<spring:message code="register.restaurant.province.option.0"/>
					</html:option>
					<html:options items="${listSpecificProvince}" itemLabel="nameProvince" itemValue="idProvince" />
				</html:select>
			</div>
		</div>
		<div class="row show-grid-forms">
			<div class="col-sm-3">
				<spring:message code="common.label.ruc" var="rucP"/>
				<html:input path="ruc" maxlength="11"  class="form-control input-lg" id="ruc" placeholder="${rucP}"/>
			</div>
			<div class="col-sm-3">
				<spring:message code="common.label.reference" var="referenceP"/>
				<html:input path="reference" maxlength="60"  class="form-control input-lg" id="reference" placeholder="${referenceP}"/>
			</div>
			<div class="col-sm-3">
				<spring:message code="common.label.district" var="districtP"/>
<%-- 				<html:input path="district" maxlength="60"  class="form-control input-lg" id="district" placeholder="${districtP}"/> --%>
				<html:select path="district" id="district" class="form-control">
					<html:option value="0">
						<spring:message code="register.restaurant.district.option.0"/>
					</html:option>
					<html:options items="${listSpecificDistrict}" itemLabel="nameDistrict" itemValue="idDistrict" />
				</html:select>
			</div>
		</div>
		<div class="row show-grid-forms">
			<div class="col-sm-3">
				<input type="file" name="fileLogo" id="fileLogo"  multiple accept='image/*'>
			</div>
			<c:if test="${not empty fileLogo}">
				<div class="col-sm-3">
					<b><spring:message code="common.name.image"/></b>&nbsp;${fileLogo}
				</div>
			</c:if>
		</div>
		<p><b><spring:message code="common.title.contact.information" /></b></p>
		<div class="row show-grid-forms">
			<div class="col-sm-3">
				<spring:message code="common.label.name.contact" var="nameContactP"/>
				<html:input path="nameContact" maxlength="60"  class="form-control input-lg" id="nameContact" placeholder="${nameContactP}"/>
			</div>
			<div class="col-sm-3">
				<spring:message code="common.label.phone.contact" var="phoneContactP"/>
				<html:input path="phoneContact" maxlength="10"  class="form-control input-lg" id="phoneContact" placeholder="${phoneContactP}"/>
			</div>
			<div class="col-sm-3">
				<spring:message code="common.label.anexo" var="anexoP"/>
				<html:input path="anexoContact" maxlength="60"  class="form-control input-lg" id="anexoContact" placeholder="${anexoP}"/>
			</div>
		</div>
		<div class="row show-grid-forms">
			<div class="col-sm-3">
				<spring:message code="common.label.lastName.contact" var="lasstNameContactP"/>
				<html:input path="lastNameContact" maxlength="60"  class="form-control input-lg" id="lastNameContact" placeholder="${lasstNameContactP}"/>
			</div>
			<div class="col-sm-3">
				<spring:message code="common.label.celphone" var="celphoneContactP"/>
				<html:input path="celphoneContact" maxlength="10"  class="form-control input-lg" id="celphoneContact" placeholder="${celphoneContactP}"/>
			</div>
		</div>
		<div class="row show-grid-forms">
			<div class="col-sm-3">
				<spring:message code="common.label.charge.contact" var="chargeContactP"/>
				<html:input path="chargeContact" maxlength="60"  class="form-control input-lg" id="chargeContact" placeholder="${chargeContactP}"/>
			</div>
			<div class="col-sm-3">
				<html:input path="emailContact" maxlength="60"  class="form-control input-lg" id="emailContact" />
			</div>
			<div class="col-sm-3" style="display: none">
<%-- 				<input type="text" value="${idUserReq}" id="idSuerReqTemp"> --%>
				<html:input path="idUser" maxlength="60"  class="form-control input-lg" id="idUser"/>
				<html:input path="id" maxlength="60"  class="form-control input-lg" id="id"/>
				<html:input path="idImage" maxlength="60"  class="form-control input-lg" id="idImage"/>
			</div>
		</div>
		<button type="submit" class="btn btn-default btn-lg"><spring:message code="common.value.next"/></button>
	</html:form>
</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	$("#idRestaurantForm").validate({
		rules: {
			socialReason: "required",
			address: "required",
			department:{min:1},
			comercialName: "required",
			phone: {
				required: true,
			    number: true
			},
			province:{min:1},
			ruc: "required",
			district:{min:1},
			nameContact: "required",
			phoneContact: {
				required: true,
			    number: true
			},
			anexoContact: {
			    number: true
			},
			lastNameContact: "required",
			celphoneContact: {
				required: true,
			    number: true
			},
			chargeContact: "required"
			
		},
		messages: {
			socialReason: '<spring:message code="maintenance.generic.field.required" />',
			address: '<spring:message code="maintenance.generic.field.required" />',
			department:'<spring:message code="select.value.cbo.option" />',
			comercialName: '<spring:message code="maintenance.generic.field.required" />',
			phone: {
				required: '<spring:message code="maintenance.generic.field.required" />',
			    number: '<spring:message code="generic.field.number.format" />'
			},
			province:'<spring:message code="select.value.cbo.option" />',
			ruc: '<spring:message code="maintenance.generic.field.required" />',
			district:'<spring:message code="select.value.cbo.option" />',
			nameContact: '<spring:message code="maintenance.generic.field.required" />',
			phoneContact: {
				required: '<spring:message code="maintenance.generic.field.required" />',
			    number: '<spring:message code="generic.field.number.format" />'
			},
			anexoContact: {
			    number: '<spring:message code="generic.field.number.format" />'
			},
			lastNameContact: '<spring:message code="maintenance.generic.field.required" />',
			celphoneContact: {
				required: '<spring:message code="maintenance.generic.field.required" />',
			    number: '<spring:message code="generic.field.number.format" />'
			},
			chargeContact: '<spring:message code="maintenance.generic.field.required" />'
			
		},
        submitHandler: function(form) {
            form.submit();
        }
		
	});
	$("#fileLogo").rules('add',{
        accept: "image/jpeg, image/pjpeg"
	});
	$("#department").change(function(){
		$.ajax({
		    url: "${pageContext.request.contextPath}/getProvince.htm?departmentId="+$(this).val(),
	    	data: null,
	    	type: "GET",
	    	dataType: "json",
		    success: function(data){
		    	var options = '<option value="0"><spring:message code="register.restaurant.province.option.0"/></option>';
		    	for (var i = 0; i < data.length; i++) {
	 		       options += '<option value="' + data[i].idProvince + '">' + data[i].nameProvince + '</option>';
	 		    }
		    	$("#province").html(options);
		    	}
		    });
	 });
	$("#province").change(function(){
		$.ajax({
			type:'GET',
		    url: '${pageContext.request.contextPath}/getDistrict.htm?provinceId=' + $(this).val(),
		    data : null,
		    dataType: "json",
		    success: function(data){
		    	var options = '<option value="0"><spring:message code="register.restaurant.district.option.0"/></option>';
			    for (var i = 0; i < data.length; i++) {
		 		    options += '<option value="' + data[i].idDistrict + '">' + data[i].nameDistrict + '</option>';
		 		}
			    $("#district").html(options);


		    	}
		});
	});
}); 

</script>