<%@ include file="/WEB-INF/common/taglib.jsp"%>

<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<html:form method="POST" commandName="loginUsuForm" action="validateUser.htm" id="idLoginUsuForm" novalidate="novalidate">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h1 class="text-center"><spring:message code="page.login.title.register" /></h1>
				</div>
				<div class="modal-body">
					<form class="form col-md-12 center-block">
						<div class="form-group">
							<html:input path="user" maxlength="60"  class="form-control input-lg" id="userName" placeholder="Email"/>
						</div>
						<div class="form-group">
							<html:password path="password" maxlength="24" class="form-control input-lg" id="password" placeholder="Password"/>
						</div>
						<div class="form-group">
							<html:radiobutton path="typeUser" id="rbProveedor" value="1"/><span><spring:message code="login.radiobutton.provider" /></span>
							<html:radiobutton path="typeUser" id="rbRestaurante" value="2"/><span><spring:message code="login.radiobutton.restaurant" /></span>
						</div>
						<div class="form-group">
							<input type="checkbox"  id="idAcceptTerms"><span><spring:message code="login.term.condition" /></span>
						</div>
						<div class="form-group">
							<span><spring:message code="login.label.accept.term.condition" /></span><span><a href="#"><spring:message code="common.value.document-pdf" /></a></span>
						</div>
						<c:if test="${messages == 'incorrect'}">
							<label class="error"><spring:message code="login.password.incorrect" /></label>
						</c:if>
						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-lg btn-block"><spring:message code="common.value.next" /></button>
<!-- 							<span class="pull-right"><a href="#">Register</a></span><span><a -->
<!-- 								href="#">Need help?</a></span> -->
						</div>
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