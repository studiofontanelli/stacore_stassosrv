package it.csi.stacore.stassosrv.business.adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.csi.stacore.stassosrv.api.dto.Abilitazione;
import it.csi.stacore.stassosrv.business.adapter.AbilitazioneAdapter;
import it.csi.stacore.stassosrv.business.adapter.CassaAdapter;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.adapter.CommonDtoAdapter;
import it.csi.stacore.stassosrv.util.adapter.exception.DtoConversionException;

@Component
public class AbilitazioneAdapterImpl extends CommonDtoAdapter<it.csi.stacore.stassosrv.integration.bo.utente.Abilitazione, it.csi.stacore.stassosrv.api.dto.Abilitazione> implements AbilitazioneAdapter {

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
	public Abilitazione convertTo(it.csi.stacore.stassosrv.integration.bo.utente.Abilitazione t) throws DtoConversionException {
		final String method = "convertTo";
		try {
			Abilitazione abilitazione =  super.convertTo(t);
			abilitazione.setElencoCasse(cassaAdapter.convertTo(t.getCassaList()));
			return abilitazione;
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new DtoConversionException("Errore in fase di conversione ", e);
		}
		
	}

	

	

}
