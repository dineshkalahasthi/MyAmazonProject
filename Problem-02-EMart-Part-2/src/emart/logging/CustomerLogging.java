package emart.logging;

import org.apache.logging.log4j.Logger;

import resources.LogConfig;

public class CustomerLogging {

	final static Logger LOGGER = LogConfig.getLogger(CustomerLogging.class);

	public static void main(String[] args) {
		login("101", "infy@123");
		System.out.println("Done!");
	}

	public static void login(String customerId, String password) {
		LOGGER.info("Customer " + customerId + " attempted to log in");
	}
}
