package it.csi.stacore.stassosrv.util;

import java.io.InputStream;
import java.io.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;





public class XmlSerializer {

	private static XStream xstream = new XStream(new DomDriver());

	protected final static Logger LOG = LoggerFactory.getLogger(Constants.APPLICATION_CODE);

	public XmlSerializer(){

	}
	public static String objectToXml(Object obj){
		String method = "objectToXml";
		String s = null;
		try{
			s= xstream.toXML(obj);
		}
		catch(Exception e){
			Tracer.error(LOG, XmlSerializer.class.getName(), method, "objectToXml error " + e.getMessage());
		}
		return s;
	}
	public static Object xmlToObject(String xml){
		String method = "xmlToObject";
		Object obj=null;
		try{
		obj  = xstream.fromXML(xml);
		}
		catch(Exception e){
			Tracer.error(LOG, XmlSerializer.class.getName(), method, "xmlToObject error " + e.getMessage());
		}
		return obj;
	}
	public static Object xmlToObject(InputStream is){
		String method = "xmlToObject";
		Object obj=null;
		try{
			obj = xstream.fromXML(is);
		}
		catch(Exception e){
			Tracer.error(LOG, XmlSerializer.class.getName(), method, "xmlToObject error " + e.getMessage());
		}
		return obj;
	}
	public static Object xmlToObject(Reader reader){
		String method = "xmlToObject";
		Object obj=null;
		try{
			obj = xstream.fromXML(reader);
		}
		catch(Exception e){
			Tracer.error(LOG, XmlSerializer.class.getName(), method, "xmlToObject error " + e.getMessage());
		}
		return obj;
	}
}
