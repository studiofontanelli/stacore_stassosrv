package it.csi.stacore.stassosrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="Cassa")

public class Cassa  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private Integer id = null;
  private String codice = null;
  private String descrizione = null;
  private String denominazione = null;
  private String idUtente = null;

  /**
   **/
  
  @ApiModelProperty(value = "")

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
   * Descrizione cassa
   **/
  
  @ApiModelProperty(value = "Descrizione cassa")

  // nome originario nello yaml: descrizione 
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   * Denominazione cassa
   **/
  
  @ApiModelProperty(value = "Denominazione cassa")

  // nome originario nello yaml: denominazione 
  public String getDenominazione() {
    return denominazione;
  }
  public void setDenominazione(String denominazione) {
    this.denominazione = denominazione;
  }

  /**
   * Id utente
   **/
  
  @ApiModelProperty(value = "Id utente")

  // nome originario nello yaml: idUtente 
  public String getIdUtente() {
    return idUtente;
  }
  public void setIdUtente(String idUtente) {
    this.idUtente = idUtente;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cassa cassa = (Cassa) o;
    return Objects.equals(id, cassa.id) &&
        Objects.equals(codice, cassa.codice) &&
        Objects.equals(descrizione, cassa.descrizione) &&
        Objects.equals(denominazione, cassa.denominazione) &&
        Objects.equals(idUtente, cassa.idUtente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, codice, descrizione, denominazione, idUtente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cassa {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    denominazione: ").append(toIndentedString(denominazione)).append("\n");
    sb.append("    idUtente: ").append(toIndentedString(idUtente)).append("\n");
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

