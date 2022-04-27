
package it.csi.stacore.stassosrv.util;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

public class CacheKeyGenerator implements KeyGenerator {

	private static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".cache";
	protected final static Logger LOG = LoggerFactory.getLogger(LOGGER_PREFIX);


	@Override
	public Object generate(Object target, Method method, Object... params) {

		String key = target.getClass().getName() + "_" + method.getName() + "_" + StringUtils.arrayToDelimitedString(params, "_");
		Tracer.info(LOG, target.getClass().getName(), method.getName(), "key_cache= " + key);
		return key;
	}
}
