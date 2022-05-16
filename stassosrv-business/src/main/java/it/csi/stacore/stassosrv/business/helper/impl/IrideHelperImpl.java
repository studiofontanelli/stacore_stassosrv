package it.csi.stacore.stassosrv.business.helper.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.csi.iride2.policy.base.nmsf.stub.base.entity.Identita;
import it.csi.iride2.policy.base.nmsf.stub.base.entity.UseCase;
import it.csi.stacore.stassosrv.api.dto.Utente;
import it.csi.stacore.stassosrv.business.adapter.UtenteAdapter;
import it.csi.stacore.stassosrv.business.dto.AutorizzazioneDto;
import it.csi.stacore.stassosrv.business.dto.ErrorDetailDto;
import it.csi.stacore.stassosrv.business.exception.HelperException;
import it.csi.stacore.stassosrv.business.exception.ValidationException;
import it.csi.stacore.stassosrv.business.helper.IrideHelper;
import it.csi.stacore.stassosrv.integration.bo.factory.UtenteFactory;
import it.csi.stacore.stassosrv.integration.dao.UtenteDao;
import it.csi.stacore.stassosrv.integration.exception.IntegrationException;
import it.csi.stacore.stassosrv.integration.service.IrideService;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.XmlSerializer;

@Service("irideHelper")
public class IrideHelperImpl extends CommonHelperImpl implements IrideHelper {



	private Map<String, List> abilitazioniByUseCase;

	@Autowired 
	//@Qualifier("irideService")
	@Qualifier("irideServiceMock")
	
	private IrideService irideService;
	
	@Autowired 
	private UtenteDao utenteDao;
	
	@Autowired 
	private UtenteAdapter utenteAdapter;
	
	@PostConstruct
	public void init() {
		final String method = "init";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");

			abilitazioniByUseCase = new HashMap<String, List>();

			List listaAutorizzazioni_GESTIONE_AVVISI = new ArrayList();
			List listaAutorizzazioni_RISCOSSIONE_S = new ArrayList();
			List listaAutorizzazioni_STATISTICHE_ADMIN = new ArrayList();
			List listaAutorizzazioni_BONIFICA_ESE_ADMIN = new ArrayList();
			List listaAutorizzazioni_GESTIONALE_S = new ArrayList();
			List listaAutorizzazioni_GESTIONALE_V = new ArrayList();
			List listaAutorizzazioni_STATISTICHE_USER = new ArrayList();
			List listaAutorizzazioni_BONIFICA_ESE_USERA = new ArrayList();
			List listaAutorizzazioni_BONIFICA_ESE_USERB = new ArrayList();
			List listaAutorizzazioni_RISCOSSIONE_V = new ArrayList();
			List listaAutorizzazioni_GESTIONE_RIMBORSI = new ArrayList();
			List listaAutorizzazioni_USER_CONS_RIM = new ArrayList();
			List listaAutorizzazioni_GESTIONE_ESENZIONI = new ArrayList();
			List listaAutorizzazioni_GESTIONE_INTERMEDIARI = new ArrayList();

			List listaAutorizzazioni_GESTIONE_SAP = new ArrayList();
			List listaAutorizzazioni_SERVIZIO_SAP = new ArrayList();
			
			List listaAutorizzazioni_GESTIONE_ICAR = new ArrayList();

			List listaAutorizzazioni_CONSULTAREAVVISIBONARIO = new ArrayList();
			List listaAutorizzazioni_GESTIONE_CONT = new ArrayList();
			List listaAutorizzazioni_USER_SITCONT_A = new ArrayList();
			List listaAutorizzazioni_USER_SITCONT_B = new ArrayList();
			List listaAutorizzazioni_STATO_SOSPESO = new ArrayList();
			List listaAutorizzazioni_GESTIONE_CARTOLINE = new ArrayList();
			
			
			abilitazioniByUseCase.put("GESTIONE_AVVISI", listaAutorizzazioni_GESTIONE_AVVISI);
			abilitazioniByUseCase.put("RISCOSSIONE_S", listaAutorizzazioni_RISCOSSIONE_S);
			abilitazioniByUseCase.put("STATISTICHE_ADMIN", listaAutorizzazioni_STATISTICHE_ADMIN);
			abilitazioniByUseCase.put("BONIFICA_ESE_ADMIN", listaAutorizzazioni_BONIFICA_ESE_ADMIN);
			abilitazioniByUseCase.put("GESTIONALE_S", listaAutorizzazioni_GESTIONALE_S);
			abilitazioniByUseCase.put("GESTIONALE_V", listaAutorizzazioni_GESTIONALE_V);
			abilitazioniByUseCase.put("STATISTICHE_USER", listaAutorizzazioni_STATISTICHE_USER);
			abilitazioniByUseCase.put("BONIFICA_ESE_USERA", listaAutorizzazioni_BONIFICA_ESE_USERA);
			abilitazioniByUseCase.put("BONIFICA_ESE_USERB", listaAutorizzazioni_BONIFICA_ESE_USERB);
			abilitazioniByUseCase.put("RISCOSSIONE_V", listaAutorizzazioni_RISCOSSIONE_V);
			abilitazioniByUseCase.put("GESTIONE_RIMBORSI", listaAutorizzazioni_GESTIONE_RIMBORSI);
			abilitazioniByUseCase.put("USER_CONS_RIM", listaAutorizzazioni_USER_CONS_RIM);
			abilitazioniByUseCase.put("GESTIONE_ESENZIONI", listaAutorizzazioni_GESTIONE_ESENZIONI);
			abilitazioniByUseCase.put("GESTIONE_INTERMEDIARI", listaAutorizzazioni_GESTIONE_INTERMEDIARI);
			abilitazioniByUseCase.put("GESTIONE_SAP", listaAutorizzazioni_GESTIONE_SAP);
			abilitazioniByUseCase.put("SERVIZIO_SAP", listaAutorizzazioni_SERVIZIO_SAP);
			abilitazioniByUseCase.put("GESTIONE_ICAR", listaAutorizzazioni_GESTIONE_ICAR);

			abilitazioniByUseCase.put("CONSULTAREAVVISIBONARIO", listaAutorizzazioni_CONSULTAREAVVISIBONARIO);
			abilitazioniByUseCase.put("GESTIONE_CONT", listaAutorizzazioni_GESTIONE_CONT);
			abilitazioniByUseCase.put("USER_SITCONT_A", listaAutorizzazioni_USER_SITCONT_A);
			abilitazioniByUseCase.put("USER_SITCONT_B", listaAutorizzazioni_USER_SITCONT_B);
			abilitazioniByUseCase.put("STATO SOSPESO", listaAutorizzazioni_STATO_SOSPESO);
			abilitazioniByUseCase.put("GESTIONE_CARTOLINE", listaAutorizzazioni_GESTIONE_CARTOLINE);

			listaAutorizzazioni_GESTIONE_AVVISI.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_GESTIONE_AVVISI.add(new AutorizzazioneDto("avvisi.nuovaSegnalazione"));
			listaAutorizzazioni_GESTIONE_AVVISI.add(new AutorizzazioneDto("avvisi.consultareSegnalazioni"));
			listaAutorizzazioni_GESTIONE_AVVISI.add(new AutorizzazioneDto("avvisi.consultareAvvisiScadenza"));
			listaAutorizzazioni_GESTIONE_AVVISI.add(new AutorizzazioneDto("avvisi.consultareAvvisiAccertamento"));
//			listaAutorizzazioni_GESTIONE_AVVISI.add(new AutorizzazioneDto("avvisi.consultareAvvisiBonario"));
			listaAutorizzazioni_GESTIONE_AVVISI.add(new AutorizzazioneDto("avvisiBonifica"));
			
			listaAutorizzazioni_RISCOSSIONE_S.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_RISCOSSIONE_S.add(new AutorizzazioneDto("riscossioneGenerico"));
			listaAutorizzazioni_RISCOSSIONE_S.add(new AutorizzazioneDto("riscossione.riscuotereTributo"));
			listaAutorizzazioni_RISCOSSIONE_S.add(new AutorizzazioneDto("riscossione.consultarePagamenti"));
			listaAutorizzazioni_RISCOSSIONE_S.add(new AutorizzazioneDto("riscossione.consultareRiepiloghi"));
			listaAutorizzazioni_RISCOSSIONE_S.add(new AutorizzazioneDto("riscossione.assegnareCassa"));
			listaAutorizzazioni_RISCOSSIONE_S.add(new AutorizzazioneDto("riscossioneInserimento"));

			listaAutorizzazioni_STATISTICHE_ADMIN.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_STATISTICHE_ADMIN.add(new AutorizzazioneDto("gestionale.statisticheDatiFiscali"));
			listaAutorizzazioni_STATISTICHE_ADMIN.add(new AutorizzazioneDto("gestionale.statisticheDatiTecnici"));
			listaAutorizzazioni_STATISTICHE_ADMIN.add(new AutorizzazioneDto("gestionale.statisticheEnti"));
			listaAutorizzazioni_STATISTICHE_ADMIN.add(new AutorizzazioneDto("gestionale.operazioniBonifica"));
			// SB60
			listaAutorizzazioni_STATISTICHE_ADMIN.add(new AutorizzazioneDto("gestionale.documentazioneBonifiche"));
			listaAutorizzazioni_STATISTICHE_ADMIN.add(new AutorizzazioneDto("gestionale.reportBonifiche"));

			listaAutorizzazioni_BONIFICA_ESE_ADMIN.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_BONIFICA_ESE_ADMIN.add(new AutorizzazioneDto("gestionale.agevolazione"));
			listaAutorizzazioni_BONIFICA_ESE_ADMIN.add(new AutorizzazioneDto("esenzioniAdmin"));
			// SB60
			listaAutorizzazioni_BONIFICA_ESE_ADMIN.add(new AutorizzazioneDto("gestionale.documentazioneBonifiche"));
			//listaAutorizzazioni_BONIFICA_ESE_ADMIN.add(new AutorizzazioneDto("gestionale.reportBonifiche"));

			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionaleGenerico"));
			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionale.posizione"));
			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionale.scadenza"));
			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionale.bollettino"));
			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionale.agevolazione"));
			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionale.calcoloTassa"));
//			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionale.operazioniBonifica"));
			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionale.statisticheDatiFiscali"));
			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionale.statisticheDatiTecnici"));
			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionale.statisticheEnti"));
			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionaleBonifica"));
//			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionale.tracciamenti"));
			// SB60
			listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionale.documentazioneBonifiche"));
			//listaAutorizzazioni_GESTIONALE_S.add(new AutorizzazioneDto("gestionale.reportBonifiche"));

			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("gestionaleGenerico"));
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("gestionale.posizione"));
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("gestionale.scadenza"));
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("gestionale.bollettino"));
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("gestionale.agevolazione"));
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("gestionale.calcoloTassa"));
//			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("gestionale.operazioniBonifica"));
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("gestionale.statisticheDatiFiscali"));
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("gestionale.statisticheDatiTecnici"));
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("gestionale.statisticheEnti"));
			// SB60
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("gestionale.documentazioneBonifiche"));
			//listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("gestionale.reportBonifiche"));
			// SB28
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("avvisi.consultareAvvisiScadenza"));
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("avvisi.consultareAvvisiAccertamento"));
			listaAutorizzazioni_GESTIONALE_V.add(new AutorizzazioneDto("GESTIONALE_V"));

			listaAutorizzazioni_STATISTICHE_USER.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_STATISTICHE_USER.add(new AutorizzazioneDto("gestionale.statisticheDatiFiscali"));
			listaAutorizzazioni_STATISTICHE_USER.add(new AutorizzazioneDto("gestionale.statisticheDatiTecnici"));
			listaAutorizzazioni_STATISTICHE_USER.add(new AutorizzazioneDto("gestionale.statisticheEnti"));
			// SB60
			listaAutorizzazioni_STATISTICHE_USER.add(new AutorizzazioneDto("gestionale.documentazioneBonifiche"));
			//listaAutorizzazioni_STATISTICHE_USER.add(new AutorizzazioneDto("gestionale.reportBonifiche"));

			listaAutorizzazioni_BONIFICA_ESE_USERA.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_BONIFICA_ESE_USERA.add(new AutorizzazioneDto("gestionale.agevolazione"));
			listaAutorizzazioni_BONIFICA_ESE_USERA.add(new AutorizzazioneDto("esenzioniUserA"));
			// SB60
			listaAutorizzazioni_BONIFICA_ESE_USERA.add(new AutorizzazioneDto("gestionale.documentazioneBonifiche"));
			//listaAutorizzazioni_BONIFICA_ESE_USERA.add(new AutorizzazioneDto("gestionale.reportBonifiche"));

			listaAutorizzazioni_BONIFICA_ESE_USERB.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_BONIFICA_ESE_USERB.add(new AutorizzazioneDto("gestionale.agevolazione"));
			listaAutorizzazioni_BONIFICA_ESE_USERB.add(new AutorizzazioneDto("esenzioniUserB"));
			// SB60
			listaAutorizzazioni_BONIFICA_ESE_USERB.add(new AutorizzazioneDto("gestionale.documentazioneBonifiche"));
			
			listaAutorizzazioni_RISCOSSIONE_V.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_RISCOSSIONE_V.add(new AutorizzazioneDto("riscossioneGenerico"));
			listaAutorizzazioni_RISCOSSIONE_V.add(new AutorizzazioneDto("riscossione.riscuotereTributo"));

			listaAutorizzazioni_GESTIONE_RIMBORSI.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_GESTIONE_RIMBORSI.add(new AutorizzazioneDto("rimborsiGenerico"));
			listaAutorizzazioni_GESTIONE_RIMBORSI.add(new AutorizzazioneDto("rimborsi.creareIstanza"));
			listaAutorizzazioni_GESTIONE_RIMBORSI.add(new AutorizzazioneDto("rimborsi.consultareIstanza"));
			listaAutorizzazioni_GESTIONE_RIMBORSI.add(new AutorizzazioneDto("rimborsi.creareDetermina"));
			listaAutorizzazioni_GESTIONE_RIMBORSI.add(new AutorizzazioneDto("rimborsi.consultareDetermina"));
			//sb28
			listaAutorizzazioni_GESTIONE_RIMBORSI.add(new AutorizzazioneDto("GESTIONE_RIMBORSI"));

			//SB28
			listaAutorizzazioni_USER_CONS_RIM.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_USER_CONS_RIM.add(new AutorizzazioneDto("rimborsiGenerico"));
			listaAutorizzazioni_USER_CONS_RIM.add(new AutorizzazioneDto("rimborsi.consultareIstanza"));
			listaAutorizzazioni_USER_CONS_RIM.add(new AutorizzazioneDto("USER_CONS_RIM"));

			listaAutorizzazioni_GESTIONE_ESENZIONI.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_GESTIONE_ESENZIONI.add(new AutorizzazioneDto("esenzioniGenerico"));
			listaAutorizzazioni_GESTIONE_ESENZIONI.add(new AutorizzazioneDto("esenzioni.nuovaIstruttoriaDisabili"));
			listaAutorizzazioni_GESTIONE_ESENZIONI.add(new AutorizzazioneDto("esenzioni.nuovaIstruttoriaEsenzioni"));
			listaAutorizzazioni_GESTIONE_ESENZIONI.add(new AutorizzazioneDto("esenzioni.consultarePraticheDisabili"));
			listaAutorizzazioni_GESTIONE_ESENZIONI.add(new AutorizzazioneDto("esenzioni.consultareAltrePratiche"));
			listaAutorizzazioni_GESTIONE_ESENZIONI.add(new AutorizzazioneDto("esenzioni.allineareSistema"));

			listaAutorizzazioni_GESTIONE_INTERMEDIARI.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_GESTIONE_INTERMEDIARI.add(new AutorizzazioneDto("ginGenerico"));
			listaAutorizzazioni_GESTIONE_INTERMEDIARI.add(new AutorizzazioneDto("intermediari.gin"));
			listaAutorizzazioni_GESTIONE_INTERMEDIARI.add(new AutorizzazioneDto("intermediari.consultareAgenzie"));

			listaAutorizzazioni_GESTIONE_SAP.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_GESTIONE_SAP.add(new AutorizzazioneDto("gestionale.gestioneSmartCard"));

			listaAutorizzazioni_SERVIZIO_SAP.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_SERVIZIO_SAP.add(new AutorizzazioneDto("gestionale.gestioneSmartCard"));
			listaAutorizzazioni_SERVIZIO_SAP.add(new AutorizzazioneDto("gestionale.richiestaSmartCard"));
			// SB60
			listaAutorizzazioni_SERVIZIO_SAP.add(new AutorizzazioneDto("gestionale.documentazioneBonifiche"));
			//listaAutorizzazioni_SERVIZIO_SAP.add(new AutorizzazioneDto("gestionale.reportBonifiche"));
			
			listaAutorizzazioni_CONSULTAREAVVISIBONARIO.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_CONSULTAREAVVISIBONARIO.add(new AutorizzazioneDto("avvisi.consultareAvvisiBonario"));
			
			listaAutorizzazioni_GESTIONE_CONT.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_GESTIONE_CONT.add(new AutorizzazioneDto("avvisi.contenziosoPuntuale"));
			
			listaAutorizzazioni_GESTIONE_ICAR.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_GESTIONE_ICAR.add(new AutorizzazioneDto("gestionale.tracciamenti"));
			// SB60
			listaAutorizzazioni_GESTIONE_ICAR.add(new AutorizzazioneDto("gestionale.documentazioneBonifiche"));
			//listaAutorizzazioni_GESTIONE_ICAR.add(new AutorizzazioneDto("gestionale.reportBonifiche"));
			
			listaAutorizzazioni_USER_SITCONT_A.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_USER_SITCONT_A.add(new AutorizzazioneDto("gestionale.situazioneContributiva"));
			// SB60
			listaAutorizzazioni_USER_SITCONT_A.add(new AutorizzazioneDto("gestionale.documentazioneBonifiche"));
			//listaAutorizzazioni_USER_SITCONT_A.add(new AutorizzazioneDto("gestionale.reportBonifiche"));
			
			listaAutorizzazioni_USER_SITCONT_B.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_USER_SITCONT_B.add(new AutorizzazioneDto("gestionale.situazioneContributiva"));
			listaAutorizzazioni_USER_SITCONT_B.add(new AutorizzazioneDto("situazioneContributivaExportExcel"));
			// SB60
			listaAutorizzazioni_USER_SITCONT_B.add(new AutorizzazioneDto("gestionale.documentazioneBonifiche"));
			//listaAutorizzazioni_USER_SITCONT_B.add(new AutorizzazioneDto("gestionale.reportBonifiche"));
			
			// non ha nessuna voce di menu specifica associata, ma solo funzionalita'
			listaAutorizzazioni_STATO_SOSPESO.add(new AutorizzazioneDto("home")); 
			listaAutorizzazioni_STATO_SOSPESO.add(new AutorizzazioneDto("statoSospeso")); 
			
			listaAutorizzazioni_GESTIONE_CARTOLINE.add(new AutorizzazioneDto("home"));
			listaAutorizzazioni_GESTIONE_CARTOLINE.add(new AutorizzazioneDto("gestioneCartoline")); 


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
	
	private it.csi.stacore.stassosrv.integration.bo.utente.Utente componiUtentiIrideETau(it.csi.stacore.stassosrv.integration.bo.utente.Utente utenteDaIride, it.csi.stacore.stassosrv.integration.bo.utente.Utente utenteDaTau) {
		it.csi.stacore.stassosrv.integration.bo.utente.Utente utente = new it.csi.stacore.stassosrv.integration.bo.utente.Utente(utenteDaIride.getIdUtente(), utenteDaIride.getCognome(), utenteDaIride.getNome(), utenteDaIride.getTipoUtente(),
				utenteDaTau == null ? null : utenteDaTau.getEnte(), utenteDaTau == null ? "NON SU TAU" : utenteDaTau.getDescrizione(),
				utenteDaTau == null ? null : utenteDaTau.getAbilitazione(), utenteDaIride.getProfilo(), utenteDaIride.getIdentitaIrideString(),
				utenteDaTau == null ? null : utenteDaTau.hasAbilitazionePagamentoManuale() ? "S" : null);
		return utente;
	}
	
	
	@Override
	public Utente getUtente(String token) throws HelperException {
		final String method = "getUtente";
		Utente  utente = new Utente();
		Set autorizzazioneSet = new HashSet();
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
			
			
			if (useCases == null || useCases.isEmpty()) {
				throw new HelperException("Nessun caso d'uso associato", errors);
			}
			
			it.csi.stacore.stassosrv.integration.bo.utente.Utente  utenteIride  = UtenteFactory.getInstance().buildByIdentitaAndUseCases(identita, useCases);
			
			it.csi.stacore.stassosrv.integration.bo.utente.Utente utenteTau = utenteDao.loadUtenteById(identita.getCodFiscale());
			
			//Tracer.debug(LOG, getClass().getName(), method, "utenteIride\n " + XmlSerializer.objectToXml(utenteIride));
			//Tracer.debug(LOG, getClass().getName(), method, "utenteTau\n " + XmlSerializer.objectToXml(utenteTau));
			
			it.csi.stacore.stassosrv.integration.bo.utente.Utente utenteBo = componiUtentiIrideETau(utenteIride, utenteTau);

			Tracer.debug(LOG, getClass().getName(), method, "utenteBo\n " + XmlSerializer.objectToXml(utenteBo));
			
			
			utente = utenteAdapter.convertTo(utenteBo);
			
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
