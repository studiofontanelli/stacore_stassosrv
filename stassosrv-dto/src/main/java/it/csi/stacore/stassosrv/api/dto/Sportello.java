package it.csi.stacore.stassosrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="Cassa")

public class Sportello  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private String codice = null;

  /**
   * Codice Utente
   **/
  
  @ApiModelProperty(example = "OP-Operatore, AP-Applicativo, BA-Batch", value = "Codice Utente")

  // nome originario nello yaml: codice 
  public String getCodice() {
    return codice;
  }
  public void setCodice(String codice) {
    this.codice = codice;
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
    return Objects.equals(codice, sportello.codice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sportello {\n");
    
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
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

