package com.rest.web.service.inmobile.util;

public class CommonConstants {

	public class CodeResponse{
		public final static String CODE_RESPONSE_ERROR="ERROR";
	}
	
	public class Email{
		public final static String EMAIL_FROM="albertopaico10@gmail.com";
		public final static String PASSWORD_FROM="Pa55w0rd4097";
		public final static String SUBJECT_CREATION_USER="InMobile - Creation User";
		public final static String EMAIL_TRUE="true";
		public final static String EMAIL_SMTP_GMAIL="smtp.gmail.com";
		public final static String EMAIL_PORT_GMAIL="587";
	}
	
	public class ValueRequestMapping{
		public static final String CREATE_USER = "/rest/user/create";
	}
	
	public class EncriptedValues{
		public static final String ALGORITHM_MD5="MD5";
		public static final String KEY_VALUE_ENCRIPTED="inMobileKeyPublic";
	}
	
	public class ValuesProject{
		public static final String URL_SERVER="http://localhost:8080/";
		public static final String PROJECT_VALUE="InMobileWeb/";
		public static final String ACTION_CONTINUE="continue.htm?id=";
	}
	
}
