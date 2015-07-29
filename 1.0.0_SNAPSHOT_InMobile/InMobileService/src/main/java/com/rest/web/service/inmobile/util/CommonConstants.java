package com.rest.web.service.inmobile.util;

public class CommonConstants {

	public class CodeResponse{
		public final static String CODE_RESPONSE_ERROR="ERROR";
		public final static String CODE_RESPONSE_SUCCESS_USER="SUCCESS_INSERT_USER";
		public final static String CODE_RESPONSE_SUCCESS_VALIDATION="SUCCESS_VALIDATION_USER";
		public final static String CODE_RESPONSE_FAIL_VALIDATION="FAIL_VALIDATION_USER";
		public final static String CODE_RESPONSE_EXITS_USER="EMAIL_EXIST";
		public final static String CODE_RESPONSE_NOT_EXITS_USER="EMAIL_NOT_EXIST";
		public final static String CODE_RESPONSE_IS_PROVIDER="IS_PROVIDER";
		public final static String CODE_RESPONSE_IS_RESTAURANT="IS_RESTAURANT";
		public final static String CODE_RESPONSE_ACCOUNT_INACTIVE="ACCOUNT_INACTIVE";
		public final static String CODE_RESPONSE_ACCOUNT_PENDING_VALDATION="ACCOUNT_PENDING_VALDATION";
		public final static String CODE_RESPONSE_ACCOUNT_ADMIN="ACCOUNT_ADMIN";
		public final static String CODE_RESPONSE_SUCCESS_DEPARTMENT="SUCCESS_DEPARTMENT";
		public final static String CODE_RESPONSE_SUCCESS_PROVINCE="SUCCESS_PROVINCE";
		public final static String CODE_RESPONSE_SUCCESS_DISTRICT="SUCCESS_DISTRICT";
		public final static String CODE_RESPONSE_SUCCESS_IMAGE="SUCCESS_INSERT_IMAGE";
		public final static String CODE_RESPONSE_SUCCESS_RESTAURANT="SUCCESS_INSERT_RESTAURANT";
		public final static String CODE_RESPONSE_SUCCESS_PROVIDE="SUCCESS_INSERT_PROVIDER";
		public final static String CODE_RESPONSE_SUCCESS_DISTRICT_PROVIDER="SUCCESS_INSERT_DISTRICT_PROVIDER";
		public final static String CODE_RESPONSE_LINK_USED="LINK_USED_BEFORE";
		public final static String CODE_RESPONSE_SUCCESS_SCHEDULER="SUCCESS_SCHEDULER";
		public final static String CODE_RESPONSE_SUCCESS_LIST_RESTAURANT_PENDING_ACTIVE="SUCCESS_LIST_RESTAURANT_PENDING_ACTIVE";
		public final static String CODE_RESPONSE_EMPTY_LIST_RESTAURANT_PENDING_ACTIVE="EMPTY_LIST_RESTAURANT_PENDING_ACTIVE";
		public final static String CODE_RESPONSE_SUCCESS_VERIFICATION_CHECK_REST="SUCCESS_VERIFICATION_CHECK_REST";
		public final static String CODE_RESPONSE_SUCCESS_CHECK_REST="SUCCESS_CHECK_REST";
		public final static String CODE_RESPONSE_SUCCESS_LIST_PROVIDER_PENDING_ACTIVE="SUCCESS_LIST_PROVIDER_PENDING_ACTIVE";
		public final static String CODE_RESPONSE_EMPTY_LIST_PROVIDER_PENDING_ACTIVE="EMPTY_LIST_PROVIDER_PENDING_ACTIVE";
	}
	
	public class Email{
		public final static String EMAIL_FROM="plazaproveedor@inmobile.pe";
		public final static String PASSWORD_FROM="Plaza2015";
		public final static String SUBJECT_CREATION_USER="InMobile - Creation User";
		public final static String SUBJECT_FINAL_STEP_REGISTRATON="InMobile - Final Step Registration";
		public final static String EMAIL_TRUE="true";
		public final static String EMAIL_SMTP_GMAIL="smtp.gmail.com";
		public final static String EMAIL_PORT_GMAIL="587";
	}
	
	public class ValueRequestMapping{
		public static final String CREATE_USER = "/rest/user/create";
		public static final String VALIDATE_USER = "/rest/user/validation";
		public static final String ACTIVATE_USER = "/rest/user/activate";
		public static final String SAVE_RESTAURANT = "/rest/restaurant/save";
		public static final String SAVE_PROVIDER = "/rest/provider/save";
		public static final String ADD_DISTRICT_PROVIDER = "/rest/districtProvider/add";
		public static final String LIST_DEPARTMENTS = "/rest/list/departments";
		public static final String LIST_PROVINCE = "/rest/list/province/{id}";
		public static final String LIST_DISTRICT = "/rest/list/district/{id}";
		public static final String SAVE_IMAGE = "/rest/image/save";
		public static final String SAVE_RESTAURANT_SCHEDULER = "/rest/restaurant/saveScheduler";
		public static final String LIST_RESTAURANT_PENDING_ACTIVE = "/rest/list/restaurantPendingActive/";
		public static final String VERIFICATION_RESTAURANT = "/rest/verification/restaurant/{id}";
		public static final String SAVE_CHECK_RESTAURANT = "/rest/restaurant/saveCheckRestaurant";
		
		public static final String LIST_PROVIDER_PENDING_ACTIVE = "/rest/list/providerPendingActive/";
	}
	
	public class EncriptedValues{
		public static final String ALGORITHM_MD5="MD5";
		public static final String KEY_VALUE_ENCRIPTED="inMobileKeyPublic";
	}
	
	public class ValuesProject{
		public static final String URL_SERVER="http://localhost:8080/";
		public static final String PROJECT_VALUE="InMobileWeb/";
		public static final String ACTION_CONTINUE="continue.htm?val=";
	}
	
	public class TypeOperationReqResp{
		public static final String OPERATION_CREATE_USER="CREATE_USER";
		public static final String OPERATION_VALIDATE_USER="VALIDATE_USER";
		public static final String OPERATION_SAVE_RESTAURANT="SAVE_RESTAURANT";
		public static final String OPERATION_UPLOAD_LOGO_RESTAURANT="UPLOAD_LOGO_RESTAURANT";
		public static final String OPERATION_SAVE_PROVIDER = "SAVE_PROVIDER";
		public static final String OPERATION_SAVE_DISTRICT_PROVIDER = "SAVE_DISTRICT_PROVIDER";
		public static final String OPERATION_LIST_RESTAURANT_PENDING_ACTIVE="RESTAURANT_PENDING_ACTIVE";
		public static final String OPERATION_LIST_PROVIDER_PENDING_ACTIVE="PROVIDER_PENDING_ACTIVE";
		public static final String OPERATION_GET_VALUES_RESTAURANT="GET_VALUES_PENDING_ACTIVE";
		public static final String OPERATION_SAVE_RESTAURANT_SCHEDULER="SAVE_RESTAURANT_SCHEDULER";
	}
	public class Logger{
		public static final String LOGGER_START="****START****";
		public static final String LOGGER_END="****END****";
	}
}
