package it.csi.stacore.stassosrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import it.csi.stacore.stassosrv.api.dto.Abilitazione;
import it.csi.stacore.stassosrv.api.dto.Cassa;
import it.csi.stacore.stassosrv.api.dto.Ente;
import it.csi.stacore.stassosrv.api.dto.Profilo;
import it.csi.stacore.stassosrv.api.dto.Sportello;
import it.csi.stacore.stassosrv.api.dto.TipoUtente;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="Utente")

public class Utente  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private String nome = null;
  private String cognome = null;
  private String descrizione = null;
  private String codiceFiscale = null;
  private TipoUtente tipoUtente = null;
  private Ente ente = null;
  private Profilo profilo = null;
  private Abilitazione abilitazione = null;
  private List<Cassa> elencoCassa = new ArrayList<>();
  private List<Sportello> elencoSportello = new ArrayList<>();

  /**
   * Nome Utente
   **/
  
  @ApiModelProperty(value = "Nome Utente")

  // nome originario nello yaml: nome 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Cognome Utente
   **/
  
  @ApiModelProperty(value = "Cognome Utente")

  // nome originario nello yaml: cognome 
  public String getCognome() {
    return cognome;
  }
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * descrizione Utente
   **/
  
  @ApiModelProperty(value = "descrizione Utente")

  // nome originario nello yaml: descrizione 
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   * codice fiscale
   **/
  
  @ApiModelProperty(value = "codice fiscale")

  // nome originario nello yaml: codiceFiscale 
  public String getCodiceFiscale() {
    return codiceFiscale;
  }
  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")

  // nome originario nello yaml: tipoUtente 
  public TipoUtente getTipoUtente() {
    return tipoUtente;
  }
  public void setTipoUtente(TipoUtente tipoUtente) {
    this.tipoUtente = tipoUtente;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")

  // nome originario nello yaml: ente 
  public Ente getEnte() {
    return ente;
  }
  public void setEnte(Ente ente) {
    this.ente = ente;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")

  // nome originario nello yaml: profilo 
  public Profilo getProfilo() {
    return profilo;
  }
  public void setProfilo(Profilo profilo) {
    this.profilo = profilo;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")

  // nome originario nello yaml: abilitazione 
  public Abilitazione getAbilitazione() {
    return abilitazione;
  }
  public void setAbilitazione(Abilitazione abilitazione) {
    this.abilitazione = abilitazione;
  }

  /**
   * Elenco casse
   **/
  
  @ApiModelProperty(value = "Elenco casse")

  // nome originario nello yaml: elencoCassa 
  public List<Cassa> getElencoCassa() {
    return elencoCassa;
  }
  public void setElencoCassa(List<Cassa> elencoCassa) {
    this.elencoCassa = elencoCassa;
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
    Utente utente = (Utente) o;
    return Objects.equals(nome, utente.nome) &&
        Objects.equals(cognome, utente.cognome) &&
        Objects.equals(descrizione, utente.descrizione) &&
        Objects.equals(codiceFiscale, utente.codiceFiscale) &&
        Objects.equals(tipoUtente, utente.tipoUtente) &&
        Objects.equals(ente, utente.ente) &&
        Objects.equals(profilo, utente.profilo) &&
        Objects.equals(abilitazione, utente.abilitazione) &&
        Objects.equals(elencoCassa, utente.elencoCassa) &&
        Objects.equals(elencoSportello, utente.elencoSportello);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, cognome, descrizione, codiceFiscale, tipoUtente, ente, profilo, abilitazione, elencoCassa, elencoSportello);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Utente {\n");
    
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    codiceFiscale: ").append(toIndentedString(codiceFiscale)).append("\n");
    sb.append("    tipoUtente: ").append(toIndentedString(tipoUtente)).append("\n");
    sb.append("    ente: ").append(toIndentedString(ente)).append("\n");
    sb.append("    profilo: ").append(toIndentedString(profilo)).append("\n");
    sb.append("    abilitazione: ").append(toIndentedString(abilitazione)).append("\n");
    sb.append("    elencoCassa: ").append(toIndentedString(elencoCassa)).append("\n");
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

