<%@ include file="/WEB-INF/common/taglib.jsp"%>

<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<html:form method="POST" commandName="loginUsuForm" action="validateUser.htm" id="idLoginUsuForm" novalidate="novalidate">
				<div class="modal-header" style="display: none" id="idTitleRegister">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h1 class="text-center"><spring:message code="page.login.title.register" /></h1>
				</div>
				<div class="modal-header" id="idTitleLogin">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h1 class="text-center"><spring:message code="page.login.title.login" /></h1>
				</div>
				<div class="modal-body">
					<form class="form col-md-12 center-block">
						<div id="idDivLnkNewCustomer">
							<span class="pull-right"><a href="#" id="lnkNewCustomer"><spring:message code="page.login.new.customer" /></a></span>
						</div>
						<div id="idDivLnkLogin" style="display: none">
							<span class="pull-right"><a href="#" id="lnkLoginCustomer"><spring:message code="page.login.again" /></a></span>
						</div>
						<br>
						<div class="form-group">
							<html:input path="user" maxlength="60"  class="form-control input-lg" id="userName" placeholder="Email"/>
						</div>
						<div class="form-group">
							<html:password path="password" maxlength="24" class="form-control input-lg" id="password" placeholder="Password"/>
						</div>
						<div style="display: none" id="idDivRegiter">
							<div class="form-group">
								<html:radiobutton path="typeUser" id="rbProveedor" value="1"/><span><spring:message code="login.radiobutton.provider" /></span>
								<html:radiobutton path="typeUser" id="rbRestaurante" value="2"/><span><spring:message code="login.radiobutton.restaurant" /></span>
							</div>
							<div class="form-group">
								<input type="checkbox" name="idAcceptTerms" id="idAcceptTerms"><span><spring:message code="login.term.condition" /></span>
							</div>
							<div class="form-group">
								<span><spring:message code="login.label.accept.term.condition" /></span><span><a href="#"><spring:message code="common.value.document-pdf" /></a></span>
							</div>
							<html:hidden path="typeOperation" id="typeOperation"/>
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-lg btn-block"><spring:message code="common.value.next" /></button>
							</div>
						</div>
						<div id="idDivBtnAccept">
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-lg btn-block"><spring:message code="common.value.accept" /></button>
							</div>
						</div>
						<c:if test="${messages == 'EMAIL_EXIST'}">
							<label class="error"><spring:message code="login.email.exits" /></label>
						</c:if>
						<c:if test="${messages == 'FAIL_VALIDATION_USER'}">
							<label class="error"><spring:message code="login.faild.validations" /></label>
						</c:if>
						<c:if test="${messages == 'EMAIL_NOT_EXIST'}">
							<label class="error"><spring:message code="login.email.not.exist" /></label>
						</c:if>
						<c:if test="${messages == 'ERROR'}">
							<label class="error"><spring:message code="login.email.error" /></label><br/>
							<label class="error">${messagesSpecific}</label>
						</c:if>
					</form>
				</div>
				<div class="modal-footer">
					<div class="col-md-12">
						<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
					</div>
				</div>
			</html:form>
		</div>
	</div>
</div>
<script>
$(document).ready(function() {
	$("#idLoginUsuForm").validate({
		rules: {
			user: {
				required: true,
			    email: true
			},
			password: "required",
			typeUser: "required",
			idAcceptTerms: "required"
		},
		messages: {
			user: {
				required: '<spring:message code="maintenance.generic.field.required" />',
			    email: '<spring:message code="maintenance.email.format" />'
			},
			password: '<spring:message code="maintenance.generic.field.required" />',
			typeUser: '<spring:message code="maintenance.generic.field.required" />',
			idAcceptTerms: '<spring:message code="maintenance.generic.field.required" />'			
		},
        submitHandler: function(form) {
            form.submit();
        }
	});

});
$("#lnkNewCustomer" ).click(function( event ) {
	$("#idTitleRegister" ).show();
	$("#idTitleLogin" ).hide();
	
	$("#idDivLnkLogin" ).show();
	$("#idDivLnkNewCustomer" ).hide();
	
	$("#idDivRegiter" ).show();
	
	$("#idDivBtnAccept" ).hide();
	$("#typeOperation" ).val("register");
	
});

$("#lnkLoginCustomer" ).click(function( event ) {
	$("#idTitleRegister" ).hide();
	$("#idTitleLogin" ).show();
	
	$("#idDivLnkLogin" ).hide();
	$("#idDivLnkNewCustomer" ).show();
	
	$("#idDivRegiter" ).hide();
	
	$("#idDivBtnAccept").show();
	
	$("#typeOperation" ).val("login");
});
</script>