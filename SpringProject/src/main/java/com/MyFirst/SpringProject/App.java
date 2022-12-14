package com.MyFirst.SpringProject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // load the xml file
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mycontext.xml");
    	
    	//get a reference to the bean
    	//Engineer engineer = context.getBean("theEngineer",Engineer.class);
    	// call methods on the bean
    	//engineer.workForWages();
    	
    	  DbOperations dbConnect = context.getBean("dbOperations", DbOperations.class);
    	
    	
    }
}
