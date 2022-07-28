package com.gozdesy.anotherlog;


import java.util.logging.Logger;

public class MyClass {
	
	 private static final Logger LOGGER = Logger.getLogger(MyClass.class.getName());
	 
	 public static void main(String[] args) {
		  
		 
	      System.out.println("Main method starts");
	      
	      LOGGER.severe("VERY URGENT SITUTATION! in MyClass");
	      
	      System.out.println("---------------------------------");
	      LOGGER.warning("Warning! in my MyClass");
	      LOGGER.info("Info about MyClass");
	      LOGGER.config("Config about MyClass");
	      LOGGER.fine("Fine things are happening in MyClass");
	      LOGGER.finer("Finer things are happening in MyClass");
	      LOGGER.finest("Couldn't be finest in MyClass");
	  }

}
