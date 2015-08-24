<%
// User validation Login
boolean redirectLogin = true;
if(request.getSession().getAttribute("isUserLogin") != null){
	String isUserLogin = request.getSession().getAttribute("isUserLogin").toString();
	if("1".equals(isUserLogin)){
		redirectLogin = false;
	}
}
if(redirectLogin){%>
	<jsp:forward page="inicio.htm" />
<%}

%>