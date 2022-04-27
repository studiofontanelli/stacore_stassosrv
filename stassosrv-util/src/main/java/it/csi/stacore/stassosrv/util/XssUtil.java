package it.csi.stacore.stassosrv.util;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class XssUtil {
	
	protected final static Logger LOG = LoggerFactory.getLogger(Constants.APPLICATION_CODE);

	public static String cleanXSS(String param) {
		final String method = "cleanXSS";
		Tracer.debug(LOG, XssUtil.class.getName(), method, "in= " + param);
		
		if(param == null)
			return null;
		
		String str = param;
		str = str.replaceAll("\000", "");
		Pattern localPattern = Pattern.compile("<script>(.*?)</script>", 2);
		str = localPattern.matcher(str).replaceAll("");
		localPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\'(.*?)\\'", 42);
		str = localPattern.matcher(str).replaceAll("");
		localPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", 42);
		str = localPattern.matcher(str).replaceAll("");
		localPattern = Pattern.compile("</script>", 2);
		str = localPattern.matcher(str).replaceAll("");
		localPattern = Pattern.compile("<script(.*?)>", 42);
		str = localPattern.matcher(str).replaceAll("");
		localPattern = Pattern.compile("eval\\((.*?)\\)", 42);
		str = localPattern.matcher(str).replaceAll("");
		localPattern = Pattern.compile("expression\\((.*?)\\)", 42);
		str = localPattern.matcher(str).replaceAll("");
		localPattern = Pattern.compile("javascript:", 2);
		str = localPattern.matcher(str).replaceAll("");
		localPattern = Pattern.compile("vbscript:", 2);
		str = localPattern.matcher(str).replaceAll("");
		localPattern = Pattern.compile("onload(.*?)=", 42);
		str = localPattern.matcher(str).replaceAll("");
		str = str.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		str = str.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		
		
		Tracer.debug(LOG, XssUtil.class.getName(), method, "out= " + str);
		return str;
	}
	
	
}
