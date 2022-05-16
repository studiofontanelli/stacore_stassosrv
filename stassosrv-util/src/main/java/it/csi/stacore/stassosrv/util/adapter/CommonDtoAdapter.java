package it.csi.stacore.stassosrv.util.adapter;


import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.adapter.exception.DtoConversionException;


public abstract class CommonDtoAdapter<T, V> implements DtoAdapterInterface <T, V> {

	protected static final Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);

	/**
	 *
	 */
	private static final long serialVersionUID = -5629485852400260343L;


	
	public abstract ApplicationContext getApplicationContext() ;

	public Mapper getMapper(){
		return (Mapper)getApplicationContext().getBean("mapper");
	}

	private Class<T> tClazz;
	private Class<V> vClazz;



	public CommonDtoAdapter () throws DtoConversionException {
		String method = "COSTRUTTORE";
		try{
			this.tClazz  = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			this.vClazz = (Class<V>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
			/*
			if(LOG.isDebugEnabled()){
				Tracer.debug(LOG, getClass().getSimpleName(), method, "tClazz= " + tClazz);
				Tracer.debug(LOG, getClass().getSimpleName(), method, "vClazz= " + vClazz);
			}
			*/
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new DtoConversionException(e.getMessage(), e);
		}
	}

	public V convertTo(T t) throws DtoConversionException{
		String method = "convertTo";
		V v = null;
		try{
			if(t != null) {
				v = getMapper().map(t, vClazz);
			}
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new DtoConversionException(e.getMessage(), e);
		}
		return v;
	}


	public List<V> convertTo(List<T> tList) throws DtoConversionException{
		List<V> vList = null;
		if(!CollectionUtils.isEmpty(tList)) {
			vList = new ArrayList<V>();
			for (T t : tList) {
				vList.add(convertTo(t));
			}
		}
		return vList;
	}


	public T convertFrom(V v) throws DtoConversionException{
		String method = "convertFrom";
		T t = null;
		try{
			if(v != null) {
				Tracer.debug(LOG, getClass().getSimpleName(), method, "converting object " +  v.getClass().getSimpleName());
				t = getMapper().map(v, tClazz);
			}
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new DtoConversionException(e.getMessage(), e);
		}
		return t;
	}


	public List<T> convertFrom(List<V> vList) throws DtoConversionException{
		String method = "convertFrom";
		List<T> tList = null;

		if(!CollectionUtils.isEmpty(vList)) {
			Tracer.debug(LOG, getClass().getSimpleName(), method, "converting # " + vList.size() + " objects");
			tList = new ArrayList<T>();
			for (V v : vList) {
				tList.add(convertFrom(v));
			}
			Tracer.debug(LOG, getClass().getSimpleName(), method, "tList # " + tList.size() + " size");
		}
		return tList;
	}
}
