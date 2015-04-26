<%@ include file="/WEB-INF/common/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title><spring:message code="public.titulo" /></title>

<meta name="description" content="description"></meta>
<meta name="author" content="DevOOPS"></meta>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/plugins/bootstrap/bootstrap.css"
	rel="stylesheet"></link>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/plugins/jquery-ui/jquery-ui.min.css"
	rel="stylesheet"></link>
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet"></link>
<link href='http://fonts.googleapis.com/css?family=Righteous'
	rel='stylesheet' type='text/css'></link>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/plugins/fancybox/jquery.fancybox.css"
	rel="stylesheet"></link>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/plugins/fullcalendar/fullcalendar.css"
	rel="stylesheet"></link>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/plugins/xcharts/xcharts.min.css"
	rel="stylesheet"></link>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/plugins/select2/select2.css"
	rel="stylesheet"></link>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/style.css"
	rel="stylesheet"></link>

</head>
<body>
	<!--Start Header-->
	<div id="screensaver">
		<canvas id="canvas"></canvas>
		<i class="fa fa-lock" id="screen_unlock"></i>
	</div>
	<div id="modalbox">
		<div class="devoops-modal">
			<div class="devoops-modal-header">
				<div class="modal-header-name">
					<span>Basic table</span>
				</div>
				<div class="box-icons">
					<a class="close-link"> <i class="fa fa-times"></i>
					</a>
				</div>
			</div>
			<div class="devoops-modal-inner"></div>
			<div class="devoops-modal-bottom"></div>
		</div>
	</div>

	<div>
		<tiles:insertAttribute name="cabecera" />
	</div>
	<div>
		<div id="main" class="container-fluid">
			<div class="row">
				<tiles:insertAttribute name="contenidoIzq" />
				<tiles:insertAttribute name="contenidoCentro" />
				<tiles:insertAttribute name="contenidoDcho" />
			</div>
		</div>
	</div>
	<div>
		<tiles:insertAttribute name="pie" />
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!--<script src="http://code.jquery.com/jquery.js"></script>-->
<script src="${pageContext.request.contextPath}/resources/bootstrap/plugins/jquery/jquery-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/plugins/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/plugins/justified-gallery/jquery.justifiedgallery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/plugins/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/plugins/tinymce/jquery.tinymce.min.js"></script>
<!-- All functions for this theme + document.ready processing -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/devoops.js"></script>
</body>
</html>