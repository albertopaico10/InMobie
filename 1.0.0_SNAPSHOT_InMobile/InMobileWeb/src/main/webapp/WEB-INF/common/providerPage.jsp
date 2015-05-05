<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div>

<div class="well">
	<h3 id="grid-options"><spring:message code="common.title.welcome" /></h3>
	<br/>
	<html:form method="POST" modelAttribute="providerForm" action="registerProvider.htm" id="idproviderForm" novalidate="novalidate">
		<p><b><spring:message code="common.title.accommodation.information" /></b></p>
		<div class="row show-grid-forms">
			<div class="col-sm-3">
				<spring:message code="common.label.social.reason" var="socialReasonP"/>
				<html:input path="socialReason" maxlength="60"  class="form-control input-lg" id="socialReason" placeholder="${socialReasonP}"/>
			</div>
			<div class="col-sm-3">
				<spring:message code="common.label.address" var="addressP"/>
				<html:input path="address" maxlength="60"  class="form-control input-lg" id="address" placeholder="${addressP}"/>
			</div>
			<div class="col-sm-3">
<%-- 				<spring:message code="common.label.department" var="departmentP"/> --%>
<%-- 				<html:input path="department" maxlength="60"  class="form-control input-lg" id="department" placeholder="${departmentP}"/> --%>
				<html:select path="department" id="department" class="populate placeholder form-control"> 
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
				<html:input path="phone" maxlength="60"  class="form-control input-lg" id="phone" placeholder="${phoneP}"/>
			</div>
			<div class="col-sm-3">
				<html:select path="province" id="province" class="populate placeholder form-control">
				</html:select>
			</div>
		</div>
		<div class="row show-grid-forms">
			<div class="col-sm-3">
				<spring:message code="common.label.ruc" var="rucP"/>
				<html:input path="ruc" maxlength="60"  class="form-control input-lg" id="ruc" placeholder="${rucP}"/>
			</div>
			<div class="col-sm-3">
				<spring:message code="common.label.reference" var="referenceP"/>
				<html:input path="reference" maxlength="60"  class="form-control input-lg" id="reference" placeholder="${referenceP}"/>
			</div>
			<div class="col-sm-3">
				<spring:message code="common.label.district" var="districtP"/>
<%-- 				<html:input path="district" maxlength="60"  class="form-control input-lg" id="district" placeholder="${districtP}"/> --%>
				<html:select path="district" id="district" class="form-control"></html:select>
			</div>
		</div>
		<div class="row show-grid-forms">
			<div class="col-sm-3">
				<spring:message code="common.label.ruc" var="rucP"/>
				<input type="file" name="fileLogo">
			</div>
		</div>
		
		
		<p><b><spring:message code="common.title.contact.information" /></b></p>
		<div class="row show-grid-forms">
			<div class="col-sm-3">
				<spring:message code="common.label.name.contact" var="nameContactP"/>
				<html:input path="nameContact" maxlength="60"  class="form-control input-lg" id="nameContact" placeholder="${nameContactP}"/>
			</div>
			<div class="col-sm-3">
				<spring:message code="common.label.phone.contact" var="phoneContactP"/>
				<html:input path="phoneContact" maxlength="60"  class="form-control input-lg" id="phoneContact" placeholder="${phoneContactP}"/>
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
				<html:input path="celphoneContact" maxlength="60"  class="form-control input-lg" id="celphoneContact" placeholder="${celphoneContactP}"/>
			</div>
		</div>
		<div class="row show-grid-forms">
			<div class="col-sm-3">
				<spring:message code="common.label.charge.contact" var="chargeContactP"/>
				<html:input path="chargeContact" maxlength="60"  class="form-control input-lg" id="chargeContact" placeholder="${chargeContactP}"/>
			</div>
			<div class="col-sm-3">
				<html:input path="emailContact" maxlength="60" disabled="true" class="form-control input-lg" id="emailContact" />
			</div>
			<div class="col-sm-3">
<%-- 				<input type="text" value="${idUserReq}" id="idSuerReqTemp"> --%>
				<html:hidden path="idUser" maxlength="60"  class="form-control input-lg" id="idUser"/>
			</div>
		</div>
		
		<div class="row show-grid-forms">
			<div class="column small col-md-3" style="vertical-align: top">
				<html:radiobutton path="idPlan" value="1" />
				<img alt="" src="resources/img/plan_1.png">
			</div>
			<div class="column small col-md-3" style="vertical-align: top">
				<html:radiobutton path="idPlan" value="2" />
				<img alt="" src="resources/img/plan_2.png">
			</div>
			<div class="column small col-md-3" style="vertical-align: top">
				<html:radiobutton path="idPlan" value="3" />
				<img alt="" src="resources/img/plan_3.png">
			</div>
		</div>
		
		<button type="submit" class="btn btn-default btn-lg"><spring:message code="common.value.next"/></button>
	</html:form>
</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	$("#department").change(function(){
		$.ajax({
		    type:'GET',
		    url: '${pageContext.request.contextPath}/getProvince.htm',
		    data : 'departmentId=' + $(this).val(),
		    success: function(data){
		    	 $("#province").html(data);
		    	}
		    });
	 });
	$("#province").change(function(){
		$.ajax({
			type:'GET',
		    url: '${pageContext.request.contextPath}/getDistrict.htm',
		    data : 'provinceId=' + $(this).val(),
		    success: function(data){
		    	 $("#district").html(data);
		    	}
		});
	});
}); 
</script>