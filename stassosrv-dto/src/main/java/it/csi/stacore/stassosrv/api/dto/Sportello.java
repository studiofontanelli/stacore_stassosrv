package it.csi.stacore.stassosrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import it.csi.stacore.stassosrv.api.dto.Cassa;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="Sportello")

public class Sportello  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private Integer id = null;
  private String codice = null;
  private String descrizione = null;
  private List<Cassa> elencoCassa = new ArrayList<>();

  /**
   * id sportello
   **/
  
  @ApiModelProperty(value = "id sportello")

  // nome originario nello yaml: id 
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Codice sportello
   **/
  
  @ApiModelProperty(value = "Codice sportello")

  // nome originario nello yaml: codice 
  public String getCodice() {
    return codice;
  }
  public void setCodice(String codice) {
    this.codice = codice;
  }

  /**
   * descrizione sportello
   **/
  
  @ApiModelProperty(value = "descrizione sportello")

  // nome originario nello yaml: descrizione 
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sportello sportello = (Sportello) o;
    return Objects.equals(id, sportello.id) &&
        Objects.equals(codice, sportello.codice) &&
        Objects.equals(descrizione, sportello.descrizione) &&
        Objects.equals(elencoCassa, sportello.elencoCassa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, codice, descrizione, elencoCassa);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sportello {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    elencoCassa: ").append(toIndentedString(elencoCassa)).append("\n");
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

