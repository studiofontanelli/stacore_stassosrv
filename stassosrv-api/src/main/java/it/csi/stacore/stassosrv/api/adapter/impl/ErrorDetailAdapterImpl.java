package it.csi.stacore.stassosrv.api.adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.csi.stacore.stassosrv.api.adapter.ErrorDetailAdapter;
import it.csi.stacore.stassosrv.api.dto.ErrorDetail;
import it.csi.stacore.stassosrv.business.dto.ErrorDetailDto;
import it.csi.stacore.stassosrv.util.adapter.CommonDtoAdapter;

@Component
public class ErrorDetailAdapterImpl  extends CommonDtoAdapter<ErrorDetail, ErrorDetailDto> implements ErrorDetailAdapter {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	


}
