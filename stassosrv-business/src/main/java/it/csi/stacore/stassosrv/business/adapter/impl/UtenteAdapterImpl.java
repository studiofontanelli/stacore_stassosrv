package it.csi.stacore.stassosrv.business.adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.csi.stacore.stassosrv.api.dto.Utente;
import it.csi.stacore.stassosrv.business.adapter.AbilitazioneAdapter;
import it.csi.stacore.stassosrv.business.adapter.EnteAdapter;
import it.csi.stacore.stassosrv.business.adapter.UtenteAdapter;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.adapter.CommonDtoAdapter;
import it.csi.stacore.stassosrv.util.adapter.exception.DtoConversionException;

@Component
public class UtenteAdapterImpl extends CommonDtoAdapter<it.csi.stacore.stassosrv.integration.bo.utente.Utente, it.csi.stacore.stassosrv.api.dto.Utente> implements UtenteAdapter {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private EnteAdapter enteAdapter;

	@Autowired
	private AbilitazioneAdapter abilitazioneAdapter;
	
	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public Utente convertTo(it.csi.stacore.stassosrv.integration.bo.utente.Utente t) throws DtoConversionException {
		final String method = "convertTo";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		try {
			
			Utente utente =  super.convertTo(t);
			utente.setCodiceFiscale(t.getIdUtente());
			utente.setEnte(enteAdapter.convertTo(t.getEnte()));
			utente.setAbilitazione(abilitazioneAdapter.convertTo(t.getAbilitazione()));
			return utente;
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
