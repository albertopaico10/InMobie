<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div>
	<div class="well">
	<html:form method="POST" modelAttribute="districtForm" action="registerDistrictProvider.htm" id="idDistrictProviderForm" novalidate="novalidate">
		<h3 id="grid-options"><spring:message code="register.provider.title.district" /></h3>
		<br/>
		<input type="text" name="idUser" id="idUser" value="${idUserReq }">
		
		<div class="row show-grid-forms">
			<div class="col-sm-2">
				<html:select path="department" size="15" id="department" class="col-sm-12 populate placeholder form-control"> 
					<html:options items="${listAllDepartment}" itemLabel="nameDepartment" itemValue="idDepartment" />
				</html:select> 
			</div>
			<div class="col-sm-2">
					<html:select path="province" size="15" id="province" class="col-sm-12 populate placeholder form-control">
						<html:option value="0">
							<spring:message code="register.restaurant.department.option.0"/>
						</html:option>
					</html:select>
			</div>
			<div class="col-sm-2">
				<spring:message code="common.label.district" var="districtP"/>
				<html:select path="district" size="15" id="district" class="col-sm-12 form-control">
					<html:option value="0">
						<spring:message code="register.restaurant.province.option.0"/>
					</html:option>
				</html:select>
			</div>
			<div class="col-sm-1" align="center">
				<a href="#" onclick="addDistrict()" class="btn btn-primary btn-lg" ><span class="glyphicon glyphicon-chevron-right"></span>|</a>
				<a href="#" onclick="removeDistrict()" class="btn btn-primary btn-lg" >|<span class="glyphicon glyphicon-chevron-left"></span></a>
			</div>
			<div class="col-sm-2">
				<spring:message code="common.label.district" var="districtP"/>
				<html:select path="district" size="15" id="district2" class="col-sm-12 form-control">
				</html:select>
			</div>
		</div>
		<html:input path="idDistrict" id="idDistrictProvider" name="idDistrictProvider"/>
		<button type="submit" class="btn btn-default btn-lg"><spring:message code="common.value.next"/></button>
		</html:form>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	$("#department").change(function(){
		$.ajax({
		    url: "${pageContext.request.contextPath}/getProvince.htm?departmentId="+$(this).val(),
	    	data: null,
	    	type: "GET",
	    	dataType: "json",
		    success: function(data){
		    	var options = '<option value="0"><spring:message code="register.restaurant.province.option.0"/></option>';
		    	$("#district").html(options);
		    	options = '';
		    	if(data.length > 0){
		    		for (var i = 0; i < data.length; i++) {
		 		       options += '<option value="' + data[i].idProvince + '">' + data[i].nameProvince + '</option>';
		 		    }
			    	$("#province").html(options);
				}else{
					$("#province").html('<option value="0"><spring:message code="register.restaurant.department.option.0"/></option>');
				}
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
		    	var options = '';//'<option value="0"><spring:message code="register.restaurant.district.option.0"/></option>';
			    for (var i = 0; i < data.length; i++) {
		 		    options += '<option value="' + data[i].idDistrict + '">' + data[i].nameDistrict + '</option>';
		 		}
			    $("#district").html(options);
		    }
		});
	});
});

function addDistrict(){
	
	var existe = false;
	var combo1 = document.getElementById("district").options;
	var combo2 = document.getElementById("district2").options;
	
	for(i=0;i<combo2.length;i++){
		if(!existe)
			if(combo1[combo1.selectedIndex].value == combo2[i].value)
				existe = true;
	}
	
	if(!existe){
		nuevaOpcion = new Option(combo1[combo1.selectedIndex].text,combo1[combo1.selectedIndex].value,"","");
		a = combo2.length;

		if (a==0) { i=0; } else { i=a; }
		combo2[i] = nuevaOpcion;
	}
	setDistrictProvider();
}
function removeDistrict(){
	var combo2 = document.getElementById("district2");
	combo2.remove(combo2.selectedIndex);
	setDistrictProvider();
}

function setDistrictProvider(){
	var combo2 = document.getElementById("district2").options;
	var ids = "";
	for(i=0;i<combo2.length;i++){
		ids+=combo2[i].value+"-";
	}
	$("#idDistrictProvider").val(ids);
}
</script>