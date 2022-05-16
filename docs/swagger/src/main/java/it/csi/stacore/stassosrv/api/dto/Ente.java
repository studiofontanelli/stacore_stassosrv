package it.csi.stacore.stassosrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import it.csi.stacore.stassosrv.api.dto.Sportello;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="Ente")

public class Ente  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private Integer id = null;
  private String codice = null;
  private String descrizione = null;
  private String email = null;
  private String indirizzo = null;
  private String civico = null;
  private String cap = null;
  private String comune = null;
  private String codiceFiscale = null;
  private String provincia = null;
  private String sigla = null;
  private Date dataInizioAttivita = null;
  private Boolean abilitazioneRiscossione = null;
  private List<Sportello> elencoSportello = new ArrayList<>();

  /**
   **/
  
  @ApiModelProperty(example = "Id ente", value = "")

  // nome originario nello yaml: id 
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Codice
   **/
  
  @ApiModelProperty(value = "Codice")

  // nome originario nello yaml: codice 
  public String getCodice() {
    return codice;
  }
  public void setCodice(String codice) {
    this.codice = codice;
  }

  /**
   * ACI
   **/
  
  @ApiModelProperty(value = "ACI")

  // nome originario nello yaml: descrizione 
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   * Email
   **/
  
  @ApiModelProperty(value = "Email")

  // nome originario nello yaml: email 
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Indirizzo
   **/
  
  @ApiModelProperty(example = "Indirizzo Ente", value = "Indirizzo")

  // nome originario nello yaml: indirizzo 
  public String getIndirizzo() {
    return indirizzo;
  }
  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  /**
   * Civico
   **/
  
  @ApiModelProperty(example = "Civico Ente", value = "Civico")

  // nome originario nello yaml: civico 
  public String getCivico() {
    return civico;
  }
  public void setCivico(String civico) {
    this.civico = civico;
  }

  /**
   * CAP
   **/
  
  @ApiModelProperty(value = "CAP")

  // nome originario nello yaml: cap 
  public String getCap() {
    return cap;
  }
  public void setCap(String cap) {
    this.cap = cap;
  }

  /**
   * Comune
   **/
  
  @ApiModelProperty(value = "Comune")

  // nome originario nello yaml: comune 
  public String getComune() {
    return comune;
  }
  public void setComune(String comune) {
    this.comune = comune;
  }

  /**
   * Comune
   **/
  
  @ApiModelProperty(value = "Comune")

  // nome originario nello yaml: codiceFiscale 
  public String getCodiceFiscale() {
    return codiceFiscale;
  }
  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  /**
   * Provincia
   **/
  
  @ApiModelProperty(value = "Provincia")

  // nome originario nello yaml: provincia 
  public String getProvincia() {
    return provincia;
  }
  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  /**
   * Sigla provincia
   **/
  
  @ApiModelProperty(value = "Sigla provincia")

  // nome originario nello yaml: sigla 
  public String getSigla() {
    return sigla;
  }
  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  /**
   * Data inizio attività
   **/
  
  @ApiModelProperty(value = "Data inizio attività")

  // nome originario nello yaml: dataInizioAttivita 
  public Date getDataInizioAttivita() {
    return dataInizioAttivita;
  }
  public void setDataInizioAttivita(Date dataInizioAttivita) {
    this.dataInizioAttivita = dataInizioAttivita;
  }

  /**
   * Indica se l&#39;ente è abilitato alla riscossione
   **/
  
  @ApiModelProperty(value = "Indica se l'ente è abilitato alla riscossione")

  // nome originario nello yaml: abilitazioneRiscossione 
  public Boolean isAbilitazioneRiscossione() {
    return abilitazioneRiscossione;
  }
  public void setAbilitazioneRiscossione(Boolean abilitazioneRiscossione) {
    this.abilitazioneRiscossione = abilitazioneRiscossione;
  }

  /**
   * Elenco sportelli
   **/
  
  @ApiModelProperty(value = "Elenco sportelli")

  // nome originario nello yaml: elencoSportello 
  public List<Sportello> getElencoSportello() {
    return elencoSportello;
  }
  public void setElencoSportello(List<Sportello> elencoSportello) {
    this.elencoSportello = elencoSportello;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ente ente = (Ente) o;
    return Objects.equals(id, ente.id) &&
        Objects.equals(codice, ente.codice) &&
        Objects.equals(descrizione, ente.descrizione) &&
        Objects.equals(email, ente.email) &&
        Objects.equals(indirizzo, ente.indirizzo) &&
        Objects.equals(civico, ente.civico) &&
        Objects.equals(cap, ente.cap) &&
        Objects.equals(comune, ente.comune) &&
        Objects.equals(codiceFiscale, ente.codiceFiscale) &&
        Objects.equals(provincia, ente.provincia) &&
        Objects.equals(sigla, ente.sigla) &&
        Objects.equals(dataInizioAttivita, ente.dataInizioAttivita) &&
        Objects.equals(abilitazioneRiscossione, ente.abilitazioneRiscossione) &&
        Objects.equals(elencoSportello, ente.elencoSportello);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, codice, descrizione, email, indirizzo, civico, cap, comune, codiceFiscale, provincia, sigla, dataInizioAttivita, abilitazioneRiscossione, elencoSportello);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ente {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    indirizzo: ").append(toIndentedString(indirizzo)).append("\n");
    sb.append("    civico: ").append(toIndentedString(civico)).append("\n");
    sb.append("    cap: ").append(toIndentedString(cap)).append("\n");
    sb.append("    comune: ").append(toIndentedString(comune)).append("\n");
    sb.append("    codiceFiscale: ").append(toIndentedString(codiceFiscale)).append("\n");
    sb.append("    provincia: ").append(toIndentedString(provincia)).append("\n");
    sb.append("    sigla: ").append(toIndentedString(sigla)).append("\n");
    sb.append("    dataInizioAttivita: ").append(toIndentedString(dataInizioAttivita)).append("\n");
    sb.append("    abilitazioneRiscossione: ").append(toIndentedString(abilitazioneRiscossione)).append("\n");
    sb.append("    elencoSportello: ").append(toIndentedString(elencoSportello)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

