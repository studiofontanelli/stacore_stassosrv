package it.csi.stacore.stassosrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="rappresenta il dettaglio errore restituito in caso di errori di validazione sui campi di input")

public class ErrorDetail  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private String field = null;
  private String error = null;
  private String description = null;

  /**
   * il nome del campo per cui è falita la validazione
   **/
  
  @ApiModelProperty(example = "name, surname", value = "il nome del campo per cui è falita la validazione")

  // nome originario nello yaml: field 
  public String getField() {
    return field;
  }
  public void setField(String field) {
    this.field = field;
  }

  /**
   * l&#39;errore di validazione effettivo
   **/
  
  @ApiModelProperty(example = "campo obbligatorio, ecc", value = "l'errore di validazione effettivo")

  // nome originario nello yaml: error 
  public String getError() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }

  /**
   * la descrizione dell&#39;errore
   **/
  
  @ApiModelProperty(example = "Internal server error, ecc", value = "la descrizione dell'errore")

  // nome originario nello yaml: description 
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDetail errorDetail = (ErrorDetail) o;
    return Objects.equals(field, errorDetail.field) &&
        Objects.equals(error, errorDetail.error) &&
        Objects.equals(description, errorDetail.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, error, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDetail {\n");
    
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

