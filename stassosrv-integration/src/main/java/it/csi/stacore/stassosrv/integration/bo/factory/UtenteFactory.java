package it.csi.stacore.stassosrv.integration.bo.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.csi.iride2.policy.base.nmsf.stub.base.entity.Identita;
import it.csi.iride2.policy.base.nmsf.stub.base.entity.UseCase;
import it.csi.stacore.stassosrv.integration.bo.utente.Autorizzazione;
import it.csi.stacore.stassosrv.integration.bo.utente.Profilo;
import it.csi.stacore.stassosrv.integration.bo.utente.TipoUtente;
import it.csi.stacore.stassosrv.integration.bo.utente.Utente;
import it.csi.stacore.stassosrv.util.Constants;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class UtenteFactory implements java.io.Serializable {
	
	
	protected final static Logger LOG = LoggerFactory.getLogger(Constants.APPLICATION_CODE);

	private static final long serialVersionUID = 121212121L;

	/**
	 * @uml.property  name="abilitazioniByUseCase"
	 * @uml.associationEnd  qualifier="constant:java.lang.String java.util.List"
	 */
	private Map abilitazioniByUseCase;

	//~ Static fields/initializers ===============================================

	private static UtenteFactory istance = new UtenteFactory();

	//~ Constructors =============================================================

	private UtenteFactory() {

		// Inizializzazione della matrice UseCase/Autorizzazione
		// TODO Spostare in un file di configurazione
		abilitazioniByUseCase = new HashMap();

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

		listaAutorizzazioni_GESTIONE_AVVISI.add(new Autorizzazione("home"));
		listaAutorizzazioni_GESTIONE_AVVISI.add(new Autorizzazione("avvisi.nuovaSegnalazione"));
		listaAutorizzazioni_GESTIONE_AVVISI.add(new Autorizzazione("avvisi.consultareSegnalazioni"));
		listaAutorizzazioni_GESTIONE_AVVISI.add(new Autorizzazione("avvisi.consultareAvvisiScadenza"));
		listaAutorizzazioni_GESTIONE_AVVISI.add(new Autorizzazione("avvisi.consultareAvvisiAccertamento"));
//		listaAutorizzazioni_GESTIONE_AVVISI.add(new Autorizzazione("avvisi.consultareAvvisiBonario"));
		listaAutorizzazioni_GESTIONE_AVVISI.add(new Autorizzazione("avvisiBonifica"));
		
		listaAutorizzazioni_RISCOSSIONE_S.add(new Autorizzazione("home"));
		listaAutorizzazioni_RISCOSSIONE_S.add(new Autorizzazione("riscossioneGenerico"));
		listaAutorizzazioni_RISCOSSIONE_S.add(new Autorizzazione("riscossione.riscuotereTributo"));
		listaAutorizzazioni_RISCOSSIONE_S.add(new Autorizzazione("riscossione.consultarePagamenti"));
		listaAutorizzazioni_RISCOSSIONE_S.add(new Autorizzazione("riscossione.consultareRiepiloghi"));
		listaAutorizzazioni_RISCOSSIONE_S.add(new Autorizzazione("riscossione.assegnareCassa"));
		listaAutorizzazioni_RISCOSSIONE_S.add(new Autorizzazione("riscossioneInserimento"));

		listaAutorizzazioni_STATISTICHE_ADMIN.add(new Autorizzazione("home"));
		listaAutorizzazioni_STATISTICHE_ADMIN.add(new Autorizzazione("gestionale.statisticheDatiFiscali"));
		listaAutorizzazioni_STATISTICHE_ADMIN.add(new Autorizzazione("gestionale.statisticheDatiTecnici"));
		listaAutorizzazioni_STATISTICHE_ADMIN.add(new Autorizzazione("gestionale.statisticheEnti"));
		listaAutorizzazioni_STATISTICHE_ADMIN.add(new Autorizzazione("gestionale.operazioniBonifica"));
		// SB60
		listaAutorizzazioni_STATISTICHE_ADMIN.add(new Autorizzazione("gestionale.documentazioneBonifiche"));
		listaAutorizzazioni_STATISTICHE_ADMIN.add(new Autorizzazione("gestionale.reportBonifiche"));

		listaAutorizzazioni_BONIFICA_ESE_ADMIN.add(new Autorizzazione("home"));
		listaAutorizzazioni_BONIFICA_ESE_ADMIN.add(new Autorizzazione("gestionale.agevolazione"));
		listaAutorizzazioni_BONIFICA_ESE_ADMIN.add(new Autorizzazione("esenzioniAdmin"));
		// SB60
		listaAutorizzazioni_BONIFICA_ESE_ADMIN.add(new Autorizzazione("gestionale.documentazioneBonifiche"));
		//listaAutorizzazioni_BONIFICA_ESE_ADMIN.add(new Autorizzazione("gestionale.reportBonifiche"));

		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("home"));
		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionaleGenerico"));
		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionale.posizione"));
		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionale.scadenza"));
		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionale.bollettino"));
		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionale.agevolazione"));
		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionale.calcoloTassa"));
//		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionale.operazioniBonifica"));
		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionale.statisticheDatiFiscali"));
		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionale.statisticheDatiTecnici"));
		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionale.statisticheEnti"));
		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionaleBonifica"));
//		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionale.tracciamenti"));
		// SB60
		listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionale.documentazioneBonifiche"));
		//listaAutorizzazioni_GESTIONALE_S.add(new Autorizzazione("gestionale.reportBonifiche"));

		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("home"));
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("gestionaleGenerico"));
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("gestionale.posizione"));
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("gestionale.scadenza"));
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("gestionale.bollettino"));
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("gestionale.agevolazione"));
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("gestionale.calcoloTassa"));
//		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("gestionale.operazioniBonifica"));
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("gestionale.statisticheDatiFiscali"));
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("gestionale.statisticheDatiTecnici"));
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("gestionale.statisticheEnti"));
		// SB60
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("gestionale.documentazioneBonifiche"));
		//listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("gestionale.reportBonifiche"));
		// SB28
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("avvisi.consultareAvvisiScadenza"));
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("avvisi.consultareAvvisiAccertamento"));
		listaAutorizzazioni_GESTIONALE_V.add(new Autorizzazione("GESTIONALE_V"));

		listaAutorizzazioni_STATISTICHE_USER.add(new Autorizzazione("home"));
		listaAutorizzazioni_STATISTICHE_USER.add(new Autorizzazione("gestionale.statisticheDatiFiscali"));
		listaAutorizzazioni_STATISTICHE_USER.add(new Autorizzazione("gestionale.statisticheDatiTecnici"));
		listaAutorizzazioni_STATISTICHE_USER.add(new Autorizzazione("gestionale.statisticheEnti"));
		// SB60
		listaAutorizzazioni_STATISTICHE_USER.add(new Autorizzazione("gestionale.documentazioneBonifiche"));
		//listaAutorizzazioni_STATISTICHE_USER.add(new Autorizzazione("gestionale.reportBonifiche"));

		listaAutorizzazioni_BONIFICA_ESE_USERA.add(new Autorizzazione("home"));
		listaAutorizzazioni_BONIFICA_ESE_USERA.add(new Autorizzazione("gestionale.agevolazione"));
		listaAutorizzazioni_BONIFICA_ESE_USERA.add(new Autorizzazione("esenzioniUserA"));
		// SB60
		listaAutorizzazioni_BONIFICA_ESE_USERA.add(new Autorizzazione("gestionale.documentazioneBonifiche"));
		//listaAutorizzazioni_BONIFICA_ESE_USERA.add(new Autorizzazione("gestionale.reportBonifiche"));

		listaAutorizzazioni_BONIFICA_ESE_USERB.add(new Autorizzazione("home"));
		listaAutorizzazioni_BONIFICA_ESE_USERB.add(new Autorizzazione("gestionale.agevolazione"));
		listaAutorizzazioni_BONIFICA_ESE_USERB.add(new Autorizzazione("esenzioniUserB"));
		// SB60
		listaAutorizzazioni_BONIFICA_ESE_USERB.add(new Autorizzazione("gestionale.documentazioneBonifiche"));
		//listaAutorizzazioni_BONIFICA_ESE_USERB.add(new Autorizzazione("gestionale.reportBonifiche"));

		listaAutorizzazioni_RISCOSSIONE_V.add(new Autorizzazione("home"));
		listaAutorizzazioni_RISCOSSIONE_V.add(new Autorizzazione("riscossioneGenerico"));
		listaAutorizzazioni_RISCOSSIONE_V.add(new Autorizzazione("riscossione.riscuotereTributo"));

		listaAutorizzazioni_GESTIONE_RIMBORSI.add(new Autorizzazione("home"));
		listaAutorizzazioni_GESTIONE_RIMBORSI.add(new Autorizzazione("rimborsiGenerico"));
		listaAutorizzazioni_GESTIONE_RIMBORSI.add(new Autorizzazione("rimborsi.creareIstanza"));
		listaAutorizzazioni_GESTIONE_RIMBORSI.add(new Autorizzazione("rimborsi.consultareIstanza"));
		listaAutorizzazioni_GESTIONE_RIMBORSI.add(new Autorizzazione("rimborsi.creareDetermina"));
		listaAutorizzazioni_GESTIONE_RIMBORSI.add(new Autorizzazione("rimborsi.consultareDetermina"));
		//sb28
		listaAutorizzazioni_GESTIONE_RIMBORSI.add(new Autorizzazione("GESTIONE_RIMBORSI"));

		//SB28
		listaAutorizzazioni_USER_CONS_RIM.add(new Autorizzazione("home"));
		listaAutorizzazioni_USER_CONS_RIM.add(new Autorizzazione("rimborsiGenerico"));
		listaAutorizzazioni_USER_CONS_RIM.add(new Autorizzazione("rimborsi.consultareIstanza"));
		listaAutorizzazioni_USER_CONS_RIM.add(new Autorizzazione("USER_CONS_RIM"));

		listaAutorizzazioni_GESTIONE_ESENZIONI.add(new Autorizzazione("home"));
		listaAutorizzazioni_GESTIONE_ESENZIONI.add(new Autorizzazione("esenzioniGenerico"));
		listaAutorizzazioni_GESTIONE_ESENZIONI.add(new Autorizzazione("esenzioni.nuovaIstruttoriaDisabili"));
		listaAutorizzazioni_GESTIONE_ESENZIONI.add(new Autorizzazione("esenzioni.nuovaIstruttoriaEsenzioni"));
		listaAutorizzazioni_GESTIONE_ESENZIONI.add(new Autorizzazione("esenzioni.consultarePraticheDisabili"));
		listaAutorizzazioni_GESTIONE_ESENZIONI.add(new Autorizzazione("esenzioni.consultareAltrePratiche"));
		listaAutorizzazioni_GESTIONE_ESENZIONI.add(new Autorizzazione("esenzioni.allineareSistema"));

		listaAutorizzazioni_GESTIONE_INTERMEDIARI.add(new Autorizzazione("home"));
		listaAutorizzazioni_GESTIONE_INTERMEDIARI.add(new Autorizzazione("ginGenerico"));
		listaAutorizzazioni_GESTIONE_INTERMEDIARI.add(new Autorizzazione("intermediari.gin"));
		listaAutorizzazioni_GESTIONE_INTERMEDIARI.add(new Autorizzazione("intermediari.consultareAgenzie"));

		listaAutorizzazioni_GESTIONE_SAP.add(new Autorizzazione("home"));
		listaAutorizzazioni_GESTIONE_SAP.add(new Autorizzazione("gestionale.gestioneSmartCard"));

		listaAutorizzazioni_SERVIZIO_SAP.add(new Autorizzazione("home"));
		listaAutorizzazioni_SERVIZIO_SAP.add(new Autorizzazione("gestionale.gestioneSmartCard"));
		listaAutorizzazioni_SERVIZIO_SAP.add(new Autorizzazione("gestionale.richiestaSmartCard"));
		// SB60
		listaAutorizzazioni_SERVIZIO_SAP.add(new Autorizzazione("gestionale.documentazioneBonifiche"));
		//listaAutorizzazioni_SERVIZIO_SAP.add(new Autorizzazione("gestionale.reportBonifiche"));
		
		listaAutorizzazioni_CONSULTAREAVVISIBONARIO.add(new Autorizzazione("home"));
		listaAutorizzazioni_CONSULTAREAVVISIBONARIO.add(new Autorizzazione("avvisi.consultareAvvisiBonario"));
		
		listaAutorizzazioni_GESTIONE_CONT.add(new Autorizzazione("home"));
		listaAutorizzazioni_GESTIONE_CONT.add(new Autorizzazione("avvisi.contenziosoPuntuale"));
		
		listaAutorizzazioni_GESTIONE_ICAR.add(new Autorizzazione("home"));
		listaAutorizzazioni_GESTIONE_ICAR.add(new Autorizzazione("gestionale.tracciamenti"));
		// SB60
		listaAutorizzazioni_GESTIONE_ICAR.add(new Autorizzazione("gestionale.documentazioneBonifiche"));
		//listaAutorizzazioni_GESTIONE_ICAR.add(new Autorizzazione("gestionale.reportBonifiche"));
		
		listaAutorizzazioni_USER_SITCONT_A.add(new Autorizzazione("home"));
		listaAutorizzazioni_USER_SITCONT_A.add(new Autorizzazione("gestionale.situazioneContributiva"));
		// SB60
		listaAutorizzazioni_USER_SITCONT_A.add(new Autorizzazione("gestionale.documentazioneBonifiche"));
		//listaAutorizzazioni_USER_SITCONT_A.add(new Autorizzazione("gestionale.reportBonifiche"));
		
		listaAutorizzazioni_USER_SITCONT_B.add(new Autorizzazione("home"));
		listaAutorizzazioni_USER_SITCONT_B.add(new Autorizzazione("gestionale.situazioneContributiva"));
		listaAutorizzazioni_USER_SITCONT_B.add(new Autorizzazione("situazioneContributivaExportExcel"));
		// SB60
		listaAutorizzazioni_USER_SITCONT_B.add(new Autorizzazione("gestionale.documentazioneBonifiche"));
		//listaAutorizzazioni_USER_SITCONT_B.add(new Autorizzazione("gestionale.reportBonifiche"));
		
		// non ha nessuna voce di menu specifica associata, ma solo funzionalita'
		listaAutorizzazioni_STATO_SOSPESO.add(new Autorizzazione("home")); 
		listaAutorizzazioni_STATO_SOSPESO.add(new Autorizzazione("statoSospeso")); 
		
		listaAutorizzazioni_GESTIONE_CARTOLINE.add(new Autorizzazione("home"));
		listaAutorizzazioni_GESTIONE_CARTOLINE.add(new Autorizzazione("gestioneCartoline")); 
		
	}

	//~ Methods ==================================================================

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static UtenteFactory getInstance() {
		if (istance == null) {
			istance = new UtenteFactory();
		}

		return istance;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param codiceFiscale DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public Utente buildByIdentificativoFiscale(String identificativoFiscale) {
		Utente utente = new Utente(identificativoFiscale, // identificativoFiscale
				null, null, TipoUtente.TIPO_UTENTE_OPERATORE, null, null, null, null, null, null);

		return utente;
	}

	/**
	 * Costruisce un utente applicativo dato l'identificativo
	 *
	 * @param idUtente DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public Utente buildUtenteApplicativoByIdUtente(String idUtente) {
		Utente utente = new Utente(idUtente, null, null, TipoUtente.TIPO_UTENTE_APPLICATIVO, null, null, null, null, null, null);

		return utente;
	}

	/**
	 * Costruisce un utente batch dato l'identificativo
	 *
	 * @param idUtente DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public Utente buildUtenteBatchByIdUtente(String idUtente) {
		Utente utente = new Utente(idUtente, null, null, TipoUtente.TIPO_UTENTE_BATCH, null, null, null, null, null, null);

		return utente;
	}
	
	public Utente buildUtenteGEC() {
		Utente utente = new Utente("STAGEC", null, null, TipoUtente.TIPO_UTENTE_OPERATORE, null, null, null, null, null, null);
		
		return utente;
	}
	
	/**
	 * Costruisce un utente interregionale dato l'identificativo
	 *
	 * @param idUtente DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public Utente buildUtenteInterregionaleByIdUtente(String idUtente) {
		// TODO [Ivano Canella] Da togliere l'identita iride
		
		Utente utente = new Utente(
				idUtente,
				null,
				null,
				TipoUtente.TIPO_UTENTE_INTERREGIONALE,
				null,
				null,
				null,
				null,
				"AAAAAA00B77B000F/CSI PIEMONTE/DEMO 20/IPA/20060407085530/2/ASIgguwOqvrqdHya7R0N1w==",
				null);
		
		return utente;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param identita DOCUMENT ME!
	 * @param useCases DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public Utente buildByIdentitaAndUseCases(Identita identita, List<UseCase> useCases) {
		Set autorizzazioneSet = new HashSet();

		//getLogger().debug("Identita " + identita.getCodFiscale() + " abilitata sui seguenti UC: ");
		
		for (UseCase useCase: useCases) {
			
			List autorizzazioni = (List) abilitazioniByUseCase.get(useCase.getId());
			//getLogger().debug(" UC id: " + useCase.getId() + " (Autorizzazioni: " + autorizzazioni + ")");
			if (autorizzazioni != null) autorizzazioneSet.addAll(autorizzazioni);
		}
		// Converte Set in Array
		Autorizzazione[] autorizzazioneArray = new Autorizzazione[autorizzazioneSet.size()];
		//    int j=0;
		//    for (Iterator iter = autorizzazioneSet.iterator(); iter.hasNext();) {
		//      Autorizzazione autorizzazione = (Autorizzazione) iter.next();
		//      autorizzazioneArray[j++]=autorizzazione;
		//    }
		autorizzazioneArray = (Autorizzazione[]) autorizzazioneSet.toArray(autorizzazioneArray);

		// Crea il profilo con le autorizzazioni
		Profilo profilo = new Profilo(autorizzazioneArray);

		Utente utente = new Utente(identita.getCodFiscale(), identita.getCognome(), identita.getNome(), TipoUtente.TIPO_UTENTE_OPERATORE, null,// ente (solo su DB)
				null,//descrizione (solo su DB)
				null,// abilitazione (solo su DB)
				profilo, identita.toString(), null);

		return utente;
	}

	public Utente buildByIdentita(Identita identita) {
		Utente utente = new Utente(identita.getCodFiscale(), identita.getCognome(), identita.getNome(), TipoUtente.TIPO_UTENTE_OPERATORE, null,// ente (solo su DB)
				null,//descrizione (solo su DB)
				null,// abilitazione (solo su DB)
				null, identita.toString(), null);
		
		return utente;
	}
	
	

	public Utente getUtenteEmergenza() {
		Set autorizzazioneSet = new HashSet();

		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("GESTIONE_AVVISI"));
		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("RISCOSSIONE_S"));
		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("STATISTICHE_ADMIN"));
		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("BONIFICA_ESE_ADMIN"));
		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("GESTIONALE_S"));
		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("GESTIONALE_V"));
		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("STATISTICHE_USER"));
		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("BONIFICA_ESE_USERA"));
		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("BONIFICA_ESE_USERB"));
		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("RISCOSSIONE_V"));
		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("GESTIONE_RIMBORSI"));
		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("GESTIONE_ESENZIONI"));
		autorizzazioneSet.addAll((List) abilitazioniByUseCase.get("GESTIONE_INTERMEDIARI"));

		Autorizzazione[] autorizzazioneArray = new Autorizzazione[autorizzazioneSet.size()];
		autorizzazioneArray = (Autorizzazione[]) autorizzazioneSet.toArray(autorizzazioneArray);

		Profilo profilo = new Profilo(autorizzazioneArray);

		Utente result = new Utente("SOSSOS00S00S000S", "Utente Emergenza", "Utente Emergenza", TipoUtente.TIPO_UTENTE_OPERATORE, null,// ente (solo su DB)
				null,//descrizione (solo su DB)
				null,// abilitazione (solo su DB)
				profilo, "IDENTITA-IRIDE", null);

		return result;
	}

}
