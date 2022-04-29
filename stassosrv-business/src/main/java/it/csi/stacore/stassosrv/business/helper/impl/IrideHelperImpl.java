package it.csi.stacore.stassosrv.business.helper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.csi.iride2.policy.base.nmsf.stub.base.entity.Identita;
import it.csi.iride2.policy.base.nmsf.stub.base.entity.UseCase;
import it.csi.stacore.stassosrv.business.dto.ErrorDetailDto;
import it.csi.stacore.stassosrv.business.dto.Utente;
import it.csi.stacore.stassosrv.business.exception.HelperException;
import it.csi.stacore.stassosrv.business.exception.ValidationException;
import it.csi.stacore.stassosrv.business.helper.IrideHelper;
import it.csi.stacore.stassosrv.integration.exception.IntegrationException;
import it.csi.stacore.stassosrv.integration.service.IrideService;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.XmlSerializer;

@Service("irideHelper")
public class IrideHelperImpl extends CommonHelperImpl implements IrideHelper {




	@Autowired 
	@Qualifier("irideService")
	private IrideService irideService;

	@PostConstruct
	public void init() {
		final String method = "init";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");




		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception "  +e);
		}
		finally {

		}

	}

	
	private Identita parseToken(String token) throws Exception {
		final String method = "parseToken";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "token= "  + token);
			if(StringUtils.isBlank(token)) {
				throw new Exception("token non valorizzato");
			}
			//AAAAAA00A11C000K/Csi Piemonte/Demo 22/IPA/20220428182942/2/VNE8kD8mvnsKxgMu9xtU6g==
			
			Identita identita = new Identita();
			String [] record = StringUtils.split(token, "/");
			identita.setCodFiscale(record[0]);
			identita.setNome(record[1]);
			identita.setCognome(record[2]);
			identita.setIdProvider(record[3]);
			identita.setTimestamp(record[4]);
			identita.setLivelloAutenticazione(new Integer(record[5]));
			identita.setMac(record[6]);
			
			
			Tracer.debug(LOG, getClass().getName(), method, "rappresentazione interna= "  + identita.getRappresentazioneInterna());
			
			
			if(LOG.isDebugEnabled()) {
				Tracer.debug(LOG, getClass().getName(), method, "identita= "  + XmlSerializer.objectToXml(identita));
			}
			
			return identita;
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new Exception("Impossibile identificare l'identità dell'utente");
		}
	}
	
	
	
	@Override
	public boolean testResources() throws HelperException {
		final String method = "testResources";
		boolean result = true;
		try {

			Tracer.debug(LOG, getClass().getName(), method, "CALLED");

			String token = "AAAAAA00A11C000K/Csi Piemonte/Demo 22/IPA/20220429092538/2/mZuVehNgN+fTR7i5OaxBGg==";
			Identita identita = parseToken(token);
			List<UseCase> useCases = irideService.findUseCasesForPersonaInApplication(identita);
			
			if(useCases != null) {
				Tracer.debug(LOG, getClass().getName(), method, "found " + useCases.size() + " useCase(s)");
			}
			
			//Tracer.info(LOG, getClass().getName(), method, "useCases\n " + XmlSerializer.objectToXml(useCases));

		} catch (IntegrationException e) {
			Tracer.error(LOG, getClass().getName(), method, "IntegrationException " + e);
			throw new HelperException(e.getMessage());
		}
		catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new HelperException(e.getMessage());
		}
		finally {
			Tracer.debug(LOG, getClass().getName(), method, "FINE");
		}
		return result;
	}
	

	@Override
	public Utente getUtente(String token) throws HelperException {
		final String method = "getUtente";
		Utente  utente = null;
		try {

			List<ErrorDetailDto> errors = new ArrayList<>();
			if (StringUtils.isBlank(token)) {
				errors.add(new ErrorDetailDto("identita", "Identita' iride non valorizzata"));

			}
			if (!errors.isEmpty()) {
				throw new ValidationException("Campi richiesti non valorizzati!", errors);
			}
			Identita identita = parseToken(token);
			List<UseCase> useCases = irideService.findUseCasesForPersonaInApplication(identita);
			
			
			Tracer.info(LOG, getClass().getName(), method, "useCases\n " + XmlSerializer.objectToXml(useCases));

		} catch (IntegrationException e) {
			Tracer.error(LOG, getClass().getName(), method, "IntegrationException " + e);
			throw new HelperException(e.getMessage());
		}
		catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new HelperException(e.getMessage());
		}
		finally {

		}
		return utente;
	}


	



}
