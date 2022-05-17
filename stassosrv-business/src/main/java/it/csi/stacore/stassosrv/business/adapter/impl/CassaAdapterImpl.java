package it.csi.stacore.stassosrv.business.adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.csi.stacore.stassosrv.api.dto.Cassa;
import it.csi.stacore.stassosrv.business.adapter.CassaAdapter;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.adapter.CommonDtoAdapter;
import it.csi.stacore.stassosrv.util.adapter.exception.DtoConversionException;

@Component
public class CassaAdapterImpl extends CommonDtoAdapter<it.csi.stacore.stassosrv.integration.bo.utente.Cassa, it.csi.stacore.stassosrv.api.dto.Cassa> implements CassaAdapter {

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

	@Override
	public Cassa convertTo(it.csi.stacore.stassosrv.integration.bo.utente.Cassa t) throws DtoConversionException {
		final String method = "convertTo";
		try {
			Cassa cassa =  super.convertTo(t);
			cassa.setId(t.getIdCassa().intValue());
			return cassa;
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new DtoConversionException("Errore in fase di conversione ", e);
		}
	}

	

	

}
