/**
 * 
 */
package it.csi.stacore.stassosrv.util;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.StringTokenizer;

import java.io.Serializable;
import java.sql.Timestamp;
import org.slf4j.Logger;





public class Tracer implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3052270659427671821L;

	private static final String separator = "::";		
	public static Tracer _Tracer;


	private static String getLastStack() {
		final Writer stw = new StringWriter();
		new Throwable("").printStackTrace(new PrintWriter(stw));
		String stackTrace = stw.toString();
		StringTokenizer st = new StringTokenizer(stackTrace, "\n");

		if(st.countTokens() > 3) {
			String lastMethodCalled = st.nextToken();
			lastMethodCalled = st.nextToken();
			lastMethodCalled = st.nextToken();
			lastMethodCalled = st.nextToken();
			lastMethodCalled = st.nextToken();
			lastMethodCalled = st.nextToken();
			if(lastMethodCalled.length() > 0)
				lastMethodCalled = lastMethodCalled.substring(0,lastMethodCalled.length()-1).trim();
			if(lastMethodCalled.length() > 3)
				lastMethodCalled = lastMethodCalled.substring(3,lastMethodCalled.length());

			return lastMethodCalled.trim();
		}
		else {
			return "";
		}
	}

	/**
	 * 	  
	 * @deprecated
	 * 
	 */	
	public static void write(String className,	String methodName,String msg) {

		String row ="Class : "+ className + " | Method : " + methodName + " | Message :" + msg;
		System.out.println(row);
	}

	/**
	 * 	  
	 * @deprecated
	 * 
	 */
	public static void writeWithTime(String className,	String methodName,String msg) {

		String row ="TIME="+(new Timestamp(System.currentTimeMillis())).toString()+" Class : "+ className + " | Method : " 
				+ methodName + " | Message :" + msg;
		System.out.println(row);
	}

	public static void debug(Logger logger, String className, String methodName, String msg)  {
		if(logger != null){
			if (logger.isDebugEnabled())  logger.debug(createOutput(className,methodName,msg));
		}
	}
	
	public static void debug(org.jboss.logging.Logger logger, String className, String methodName, String msg)  {
		if(logger != null){
			if (logger.isDebugEnabled())  logger.debug(createOutput(className,methodName,msg));
		}
	}

	public static void info(Logger logger, String className, String methodName, String msg) {
		if(logger != null){
			if (logger.isInfoEnabled()) {
				logger.info(createOutput(className,methodName,msg));
			}
		}
	}
	public static void info(org.jboss.logging.Logger logger, String className, String methodName, String msg) {
		if(logger != null){
			if (logger.isInfoEnabled()) {
				logger.info(createOutput(className,methodName,msg));
			}
		}
	}
	
	public static void warn(Logger logger, String className, String methodName, String msg){
		if(logger != null){
			logger.warn(createOutput(className,methodName,msg));
		}
	}
	
	public static void warn(org.jboss.logging.Logger logger, String className, String methodName, String msg){
		if(logger != null){
			logger.warn(createOutput(className,methodName,msg));
		}
	}

	public static void error(Logger logger, String className, String methodName, String msg, Throwable ex) {
		if(logger != null){
			logger.error(createOutput(className,methodName,msg), ex);	
		}
	}
	public static void error(org.jboss.logging.Logger logger, String className, String methodName, String msg, Throwable ex) {
		if(logger != null){
			logger.error(createOutput(className,methodName,msg), ex);	
		}
	}

	public static void error(Logger logger, String className, String methodName, String msg){
		if(logger != null){
			logger.error(createOutput(className, methodName, msg));
		}
	}
	public static void error(org.jboss.logging.Logger logger, String className, String methodName, String msg){
		if(logger != null){
			logger.error(createOutput(className, methodName, msg));
		}
	}

	/**
	 * 
	 * @param className
	 * @param methodName
	 * @param msg
	 * @return
	 * @throws TracerException
	 */
	private static String createOutput(String className, String methodName, String msg){


		int index = className.lastIndexOf(".");
		if(index != -1){
			className = className.substring(index + 1, className.length());

		}
		StringBuffer sb = new StringBuffer("[" + className);
		sb.append(separator);
		sb.append(methodName);
		sb.append("]");
		sb.append(" ");
		if (msg!=null) {
			sb.append(msg);	
		}
		return sb.toString();		
	}

}
