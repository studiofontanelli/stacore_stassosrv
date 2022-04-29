package it.csi.stacore.stassosrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="Ente")

public class Ente  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private String email = null;
  private String indirizzo = null;
  private String civico = null;
  private String cap = null;
  private String comune = null;
  private String codiceFiscale = null;
  private String provincia = null;

  /**
   * Email
   **/
  
  @ApiModelProperty(example = "Email Ente", value = "Email")

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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ente ente = (Ente) o;
    return Objects.equals(email, ente.email) &&
        Objects.equals(indirizzo, ente.indirizzo) &&
        Objects.equals(civico, ente.civico) &&
        Objects.equals(cap, ente.cap) &&
        Objects.equals(comune, ente.comune) &&
        Objects.equals(codiceFiscale, ente.codiceFiscale) &&
        Objects.equals(provincia, ente.provincia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, indirizzo, civico, cap, comune, codiceFiscale, provincia);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ente {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    indirizzo: ").append(toIndentedString(indirizzo)).append("\n");
    sb.append("    civico: ").append(toIndentedString(civico)).append("\n");
    sb.append("    cap: ").append(toIndentedString(cap)).append("\n");
    sb.append("    comune: ").append(toIndentedString(comune)).append("\n");
    sb.append("    codiceFiscale: ").append(toIndentedString(codiceFiscale)).append("\n");
    sb.append("    provincia: ").append(toIndentedString(provincia)).append("\n");
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

