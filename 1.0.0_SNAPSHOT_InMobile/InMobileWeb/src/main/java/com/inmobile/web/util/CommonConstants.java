package com.inmobile.web.util;

public class CommonConstants {

	public class Page{
		public static final String REDIRECT_INIT_PAGE="initPage";
		public static final String REDIRECT_INIT_ADMIN_PAGE="initAdminPage";
		public static final String REDIRECT_LOGIN_PAGE="loginPage";
		public static final String REDIRECT_PROVIDER="providerPage";
		public static final String REDIRECT_RESTAURANT="restaurantPage";
		public static final String REDIRECT_SENDEMAIL="sendEmailPage";
		public static final String REDIRECT_INACTIVE_ACCOUNT_PAGE="inactiveAccountPage";
		public static final String REDIRECT_ERROR="errorPage";
		public static final String REDIRECT_ACCOUNT_PENDING="accountPendingPage";
		public static final String REDIRECT_SCHEDULER_PAGE="schedulerRestaurant";
		public static final String REDIRECT_DISTRICT_PROVIDER="districtProvider";
		public static final String REDIRECT_MESSAGE_LINK_USED="lnkDeprecatedPage";
		public static final String REDIRECT_MESSAGE_SUCCESS_VALIDATION="messagesSuccessValidation";
		public static final String REDIRECT_LIST_USER_PENDING_ACTIVE="listUserPendingActive";
	}
	
	public class Response{
		public static final String RESPONSE_USER_SUCCESS="SUCCESS_INSERT_USER";
		public static final String RESPONSE_USER_EXIST="EMAIL_EXIST";
		public static final String RESPONSE_ERROR="ERROR";
		public final static String RESPONSE_SUCCESS_VALIDATION="SUCCESS_VALIDATION_USER";
		public final static String RESPONSE_FAIL_VALIDATION="FAIL_VALIDATION_USER";
		public final static String RESPONSE_NOT_EXITS_USER="EMAIL_NOT_EXIST";
		public final static String RESPONSE_IS_RESTAURANT="IS_RESTAURANT";
		public final static String RESPONSE_IS_PROVIDER="IS_PROVIDER";
		public final static String RESPONSE_ACCOUNT_INACTIVE="ACCOUNT_INACTIVE";
		public final static String RESPONSE_ACCOUNT_PENDING_VALIDATION="ACCOUNT_PENDING_VALDATION";
		public final static String RESPONSE_SUCCESS_DEPARTMENT="SUCCESS_DEPARTMENT";
		public final static String RESPONSE_SUCCESS_PROVINCE="SUCCESS_PROVINCE";
		public final static String RESPONSE_SUCCESS_DISTRICT="SUCCESS_DISTRICT";
		public final static String RESPONSE_SUCCESS_IMAGE="SUCCESS_INSERT_IMAGE";
		public final static String RESPONSE_SUCCESS_RESTAURANT="SUCCESS_INSERT_RESTAURANT";
		public final static String RESPONSE_SUCCESS_PROVIDER="SUCCESS_INSERT_PROVIDER";
		public final static String RESPONSE_SUCCESS_DISTRICT_PROVIDER="SUCCESS_INSERT_DISTRICT_PROVIDER";
		public final static String RESPONSE_LINK_USED="LINK_USED_BEFORE";
		public final static String RESPONSE_SUCCESS_SCHEDULER="SUCCESS_SCHEDULER";
		public final static String RESPONSE_ACCOUNT_ADMIN="ACCOUNT_ADMIN";
		public final static String RESPONSE_SUCCESS_LIST_RESTAURANT_PENDING_ACTIVE="SUCCESS_LIST_RESTAURANT_PENDING_ACTIVE";
		public final static String RESPONSE_EMPTY_LIST_RESTAURANT_PENDING_ACTIVE="EMPTY_LIST_RESTAURANT_PENDING_ACTIVE";
		public final static String RESPONSE_SUCCESS_CHECK_REST="SUCCESS_CHECK_REST";
	}
	public class Logger{
		public static final String LOGGER_START="****START****";
		public static final String LOGGER_END="****END****";
	}
	
	public class URLService{
		public static final String URL_IP_SERVER = "http://localhost:8080/";
		public static final String URL_SERVICE_PROJECT = "InMobileService"; 
		public static final String URL_REGISTER_USER=URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/user/create";
		public static final String URL_VALIDATION_USER=URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/user/validation";
		public static final String URL_ACTIVATE_USER=URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/user/activate";
		public static final String URL_SAVE_RESTAURANT=URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/restaurant/save";
		public static final String URL_SAVE_PROVIDER = URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/provider/save";
		public static final String URL_LIST_DEPARTMENTS=URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/list/departments";
		public static final String URL_LIST_PROVINCE=URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/list/province/";
		public static final String URL_LIST_DISTRICT=URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/list/district/";
		public static final String URL_SAVE_IMAGE=URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/image/save";
		public static final String URL_ADD_DISTRICT_PROVIDER = URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/districtProvider/add";
		public static final String URL_SAVE_RESTAURANT_SCHEDULER=URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/restaurant/saveScheduler";
		public static final String URL_LIST_RESTAURANT_PENDING_ACTIVE=URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/list/restaurantPendingActive/";
		public static final String URL_GET_RESTAURANT_CHECK=URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/verification/restaurant/";
		public static final String URL_UPDATE_CHECK_REST=URL_IP_SERVER+URL_SERVICE_PROJECT+"/rest/restaurant/saveCheckRestaurant";
	}
	
	public class EncriptedValues{
		public static final String ALGORITHM_MD5="MD5";
		public static final String KEY_VALUE_ENCRIPTED="inMobileKeyPublic";
	}
	
	public class WebId{
		public static final String LOGIN_REGISTER_USER="register";
		public static final String IMAGE_SAVE_RESTAURANT="LOGO_RESTAURANT";
		public static final String IMAGE_SAVE_PROVIDER="LOGO_PROVIDER";
	}
	
	public class Format{
		public static final String FORMAT_JPG=".jpg";
	}
}
