<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div>
	<div class="well">
		<h3 id="grid-options"><spring:message code="register.restaurant.title.scheduler" /></h3>
		<br/>
		<div class="col-md-12" style="border: 1px solid #CCCCCC">
	
		<c:forEach items="${listHours}" var="listHoursWeb" varStatus="iHours">
			<div class="row">
				<c:if test="${listHoursWeb.value!='/'}">
	    			<c:forEach items="${listDay}" var="listDayWeb2" varStatus="iDays">
	    				<c:if test="${listDayWeb2.value!='0'}">
	    					<div class="col-md-1 text-center" style="border: 1px solid #CCCCCC" >
	    						<img id="${iDays.index}_${iHours.index}" 
	    							onclick="javascript:changeIcon('${iDays.index}_${iHours.index}','${listDayWeb2.value}-${listHoursWeb.value}');" 
	    							src="${pageContext.request.contextPath}/resources/img/chooseDate.png" 
	    							alt="HTML tutorial" style="width:18px;height:18px;border:0">
	    					</div>
	    				</c:if>
	    				<c:if test="${listDayWeb2.value=='0'}">
	    					<div class="col-md-1 text-center" style="border: 1px solid #CCCCCC">
					          	${listHoursWeb.value}
					        </div>
	    				</c:if>
		    		</c:forEach>
	    		</c:if>
	    		<c:if test="${listHoursWeb.value == '/'}">
	    			<c:forEach items="${listDay}" var="listDayWeb">
	    				<c:if test="${listDayWeb.value=='0'}">
	    					<div class="col-md-1 text-center" style="border: 1px solid #CCCCCC">
					            /
					        </div>
	    				</c:if>
	    				<c:if test="${listDayWeb.value=='1'}">
	    					<div class="col-md-1 text-center" style="border: 1px solid #CCCCCC">
					            <spring:message code="scheduler.day.name.monday" />
					        </div>
	    				</c:if>
	    				<c:if test="${listDayWeb.value=='2'}">
	    					<div class="col-md-1 text-center" style="border: 1px solid #CCCCCC">
					            <spring:message code="scheduler.day.name.tuesday" />
					        </div>
	    				</c:if>
	    				<c:if test="${listDayWeb.value=='3'}">
	    					<div class="col-md-1 text-center" style="border: 1px solid #CCCCCC">
					            <spring:message code="scheduler.day.name.wednesday" />
					        </div>
	    				</c:if>
	    				<c:if test="${listDayWeb.value=='4'}">
	    					<div class="col-md-1 text-center" style="border: 1px solid #CCCCCC">
					            <spring:message code="scheduler.day.name.thuerday" />
					        </div>
	    				</c:if>
	    				<c:if test="${listDayWeb.value=='5'}">
	    					<div class="col-md-1 text-center" style="border: 1px solid #CCCCCC">
					            <spring:message code="scheduler.day.name.friday" />
					        </div>
	    				</c:if>
	    				<c:if test="${listDayWeb.value=='6'}">
	    					<div class="col-md-1 text-center" style="border: 1px solid #CCCCCC">
					            <spring:message code="scheduler.day.name.saturday" />
					        </div>
	    				</c:if>
	    				<c:if test="${listDayWeb.value=='7'}">
	    					<div class="col-md-1 text-center" style="border: 1px solid #CCCCCC">
					            <spring:message code="scheduler.day.name.sunday" />
					        </div>
	    				</c:if>
	    			</c:forEach>
	    		</c:if>
	    		
	    	</div>
	    </c:forEach>
		<br>
		
	   	</div>
	   	<form action="saveScheduler.htm" method="POST">
			<input type="text" id=schedulerDetail name="schedulerDetail" value="${schedulerDetail}"></input>
			<input type="text" name="idUser" id="idUser" value="${idUserReq }">
			<button type="submit" class="btn btn-default btn-lg"><spring:message code="common.value.next"/></button>
		</form>
	</div>
</div>
<script>
	function changeIcon(item,value){
		if(validateExist(value)){
			$("#"+item).attr('src','resources/img/chooseDate.png');
			var valueForReplace=$("#schedulerDetail").val();
			valueForReplace=valueForReplace.replace("//"+value,"");
			$("#schedulerDetail").val(valueForReplace);
		}else{
			$("#"+item).attr('src','resources/img/success_icon.png');
			var oldValue=$("#schedulerDetail").val();
			$("#schedulerDetail").val(oldValue+"//"+value);
		}
	}
	
	function validateExist(valueValidate){
		var arrayText=$("#schedulerDetail").val().split("//");
		for(var i=0;i<arrayText.length;i++){
			var valueArray=arrayText[i];
			if(valueArray==valueValidate){
				return true;
			}
		}
		return false;
		
	}
</script>