package it.csi.stacore.stassosrv.business.dto;

import java.io.Serializable;
import java.util.Date;

public class AuditMessageDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4672553880736570054L;

	private String utente = null;
	private String indirizzoIp = null;
	private String codiceOperazione = null;
	private String codiceUnitaInstallazione = null;
	private String oggettoOperazione = null;
	private String chiaveOperazione = null;
	private Date dataOperazione = null;
	private Date dataInserimento = null;
	
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	public String getIndirizzoIp() {
		return indirizzoIp;
	}
	public void setIndirizzoIp(String indirizzoIp) {
		this.indirizzoIp = indirizzoIp;
	}
	public String getCodiceOperazione() {
		return codiceOperazione;
	}
	public void setCodiceOperazione(String codiceOperazione) {
		this.codiceOperazione = codiceOperazione;
	}
	public String getCodiceUnitaInstallazione() {
		return codiceUnitaInstallazione;
	}
	public void setCodiceUnitaInstallazione(String codiceUnitaInstallazione) {
		this.codiceUnitaInstallazione = codiceUnitaInstallazione;
	}
	public String getOggettoOperazione() {
		return oggettoOperazione;
	}
	public void setOggettoOperazione(String oggettoOperazione) {
		this.oggettoOperazione = oggettoOperazione;
	}
	public String getChiaveOperazione() {
		return chiaveOperazione;
	}
	public void setChiaveOperazione(String chiaveOperazione) {
		this.chiaveOperazione = chiaveOperazione;
	}
	public Date getDataOperazione() {
		return dataOperazione;
	}
	public void setDataOperazione(Date dataOperazione) {
		this.dataOperazione = dataOperazione;
	}
	public Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	


}
