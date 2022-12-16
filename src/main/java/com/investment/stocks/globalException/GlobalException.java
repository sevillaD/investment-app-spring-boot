package com.investment.stocks.globalException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalException extends Exception {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalException.class);
	
	private static final long serialVersionId = 5607625703052254893L;
	
	public GlobalException() {
		
	}
	
	public GlobalException(String msg) {
		super(msg);
	}
	
	public GlobalException(String msg, Exception ex) {
		super(msg, ex);
	}

}
