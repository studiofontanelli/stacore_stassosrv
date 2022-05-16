package it.csi.stacore.stassosrv.business.adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.csi.stacore.stassosrv.api.dto.Sportello;
import it.csi.stacore.stassosrv.business.adapter.CassaAdapter;
import it.csi.stacore.stassosrv.business.adapter.SportelloAdapter;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.adapter.CommonDtoAdapter;
import it.csi.stacore.stassosrv.util.adapter.exception.DtoConversionException;

@Component
public class SportelloAdapterImpl extends CommonDtoAdapter<it.csi.stacore.stassosrv.integration.bo.utente.Sportello, it.csi.stacore.stassosrv.api.dto.Sportello> implements SportelloAdapter {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private CassaAdapter cassaAdapter;

	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public Sportello convertTo(it.csi.stacore.stassosrv.integration.bo.utente.Sportello t) throws DtoConversionException {
		final String method = "convertTo";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		try {
			
			Sportello sportello =  super.convertTo(t);
			sportello.setId((int)t.getId().getId());
			if(t.getCassaList() != null) {
				if(LOG.isErrorEnabled()) {
					Tracer.debug(LOG, getClass().getName(), method, "collegate " + t.getCassaList().size() + " casse allo sportello + " + sportello.getId());
				}
				
			}
			sportello.setElencoCassa(cassaAdapter.convertTo(t.getCassaList()));
			return sportello;
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new DtoConversionException("Errore in fase di conversione ", e);
		}
		finally {
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}
	}

	

	

}
