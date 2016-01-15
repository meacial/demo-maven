/*
 * @(#)LogDemo.java Jan 12, 2016
 *
 * Copyright (C) Union Mobile Pay Ltd (2016).
 * 
 * All Rights Reserved.
 */
package com.meacial.apache.log4j;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;

/**<pre/>
	Log4j Êµ¼ù
	
    @author <a href="mailto:meacial@live.cn">Gangping Li</a>
    
    @version 1.0 , Jan 12, 2016
    
 */
public class LogDemo {
	static private Logger log = LogManager.getLogger(LogDemo.class);
	public static void main(String[] args) {
		log.info ("[INFO ]:Hello World!");
		log.debug("[DEBUG]:Hello World!");
		log.warn ("[WARN ]:Hello World!");
		log.error("[ERROR]:Hello World!");
		
		System.out.println("--------------------------------------");
		LogDemo demo = new LogDemo();
		demo.retrieveMessage();
		demo.exampleException();
		
		// Marker
		log.debug("Error %s", "Error message is ???????");
		log.debug("Error %s", "message is ???????");
		// log.debug("Error", message);
		// log.debug("SystemError", message);
		// log.debug("ApplicationError", message);
	}
	
	private String[] messages = new String[] {
	        "Hello, World",
	        "Goodbye Cruel World",
	        "You had me at hello"
	    };
	    private Random rand = new Random(1);
	    
	    
	    public String retrieveMessage() {
	        log.entry();
	        String testMsg = getMessage(getKey());
	        return log.exit(testMsg);
	    }
	    public void exampleException() {
	        log.entry();
	        try {
	            String msg = messages[messages.length];
	            log.error("An exception should have been thrown");
	        } catch (Exception ex) {
	            log.catching(ex);
	        }
	        log.exit();
	    }
	    public String getMessage(int key) {
	        log.entry(key);
	 
	        String value = messages[key];
	 
	        return log.exit(value);
	    }
	    private int getKey() {
	        log.entry();
	        int key = rand.nextInt(messages.length);
	        return log.exit(key);
	    }
}

