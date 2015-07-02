<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div id="sidebar-left" class="col-xs-2 col-sm-2">
	<ul class="nav main-menu">
		<li class="dropdown">
			<a href="#" class="dropdown-toggle"> 
				<i class="fa fa-pencil-square-o"></i> <span class="hidden-xs"><spring:message code="private.left.option.mantenience.restaurant" /></span>
			</a>
			<ul class="dropdown-menu">
				<li><a href="${pageContext.request.contextPath}/listPendingActive.htm"><spring:message code="private.left.option.mantenience.common.active" /></a></li>
				<li><a href="#"><spring:message code="private.left.option.mantenience.common.editProfile" /></a></li>
				<li><a href="#"><spring:message code="private.left.option.mantenience.common.desactive" /></a></li>
			</ul>
		</li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle">
				<i class="fa fa-pencil-square-o"></i><span class="hidden-xs"><spring:message code="private.left.option.mantenience.provider" /></span>
			</a>
			<ul class="dropdown-menu">
				<li><a class="ajax-link" href="#"><spring:message code="private.left.option.mantenience.common.active" /></a></li>
				<li><a class="ajax-link" href="#"><spring:message code="private.left.option.mantenience.common.editProfile" /></a></li>
				<li><a class="ajax-link" href="#"><spring:message code="private.left.option.mantenience.common.desactive" /></a></li>
				<li><a class="ajax-link" href="#"><spring:message code="private.left.option.mantenience.provider.upload.catalog.batch" /></a></li>
				<li><a class="ajax-link" href="#"><spring:message code="private.left.option.mantenience.provider.edit.catalog" /></a></li>
			</ul>
		</li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle"> 
				<i class="fa fa-pencil-square-o"></i> <span class="hidden-xs"><spring:message code="private.left.option.mantenience.principal" /></span>
			</a>
			<ul class="dropdown-menu">
				<li><a class="ajax-link" href="#"><spring:message code="private.left.option.mantenience.principal.category.products" /></a></li>
				<li><a class="ajax-link" href="#"><spring:message code="private.left.option.mantenience.principal.presentation" /></a></li>
				<li><a class="ajax-link" href="#"><spring:message code="private.left.option.mantenience.principal.category.restaurant" /></a></li>
				<li><a class="ajax-link" href="#"><spring:message code="private.left.option.mantenience.principal.subcription" /></a></li>
			</ul>
		</li>
		
	</ul>
</div>