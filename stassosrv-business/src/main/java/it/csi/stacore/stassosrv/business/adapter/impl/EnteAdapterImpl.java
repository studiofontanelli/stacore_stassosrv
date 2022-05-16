package it.csi.stacore.stassosrv.business.adapter.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.csi.stacore.stassosrv.business.adapter.EnteAdapter;
import it.csi.stacore.stassosrv.business.adapter.SportelloAdapter;
import it.csi.stacore.stassosrv.integration.bo.utente.Ente;
import it.csi.stacore.stassosrv.integration.bo.utente.Sportello;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.adapter.CommonDtoAdapter;
import it.csi.stacore.stassosrv.util.adapter.exception.DtoConversionException;

@Component
public class EnteAdapterImpl extends CommonDtoAdapter<Ente, it.csi.stacore.stassosrv.api.dto.Ente> implements EnteAdapter {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private SportelloAdapter sportelloAdapter;
	
	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public it.csi.stacore.stassosrv.api.dto.Ente convertTo(it.csi.stacore.stassosrv.integration.bo.utente.Ente t) throws DtoConversionException {
		final String method = "convertTo";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		try {
			
			it.csi.stacore.stassosrv.api.dto.Ente ente =  super.convertTo(t);
			ente.setId((int) t.getId().getId());
			ente.setElencoSportello(sportelloAdapter.convertTo(t.getSportello()));
			
			return ente;
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
