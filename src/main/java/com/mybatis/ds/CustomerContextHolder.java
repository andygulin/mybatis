package com.mybatis.ds;

import org.apache.log4j.Logger;

public class CustomerContextHolder {

	private static final Logger logger = Logger.getLogger(CustomerContextHolder.class);

	public static final String DATA_SOURCE_MASTER = "masterDataSource";

	public static final String DATA_SOURCE_SLAVE = "slaveDataSource";

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
		logger.info("Switch DataSource -> " + customerType);
	}

	public static String getCustomerType() {
		return contextHolder.get();
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}
}