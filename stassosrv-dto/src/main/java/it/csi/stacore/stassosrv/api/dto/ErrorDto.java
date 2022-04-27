package it.csi.stacore.stassosrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import it.csi.stacore.stassosrv.api.dto.ErrorDetail;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="Rappresenta l'errore restituito da servizio")

public class ErrorDto  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private Integer status = null;
  private String code = null;
  private String description = null;
  private List<ErrorDetail> errorDetails = new ArrayList<>();

  /**
   * status http restituito
   **/
  
  @ApiModelProperty(example = "500, 400, ecc", value = "status http restituito")

  // nome originario nello yaml: status 
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * code http restituito
   **/
  
  @ApiModelProperty(example = "Internal server error, ecc", value = "code http restituito")

  // nome originario nello yaml: code 
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
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

  /**
   * i dettagli errore
   **/
  
  @ApiModelProperty(value = "i dettagli errore")

  // nome originario nello yaml: errorDetails 
  public List<ErrorDetail> getErrorDetails() {
    return errorDetails;
  }
  public void setErrorDetails(List<ErrorDetail> errorDetails) {
    this.errorDetails = errorDetails;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDto errorDto = (ErrorDto) o;
    return Objects.equals(status, errorDto.status) &&
        Objects.equals(code, errorDto.code) &&
        Objects.equals(description, errorDto.description) &&
        Objects.equals(errorDetails, errorDto.errorDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, code, description, errorDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDto {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    errorDetails: ").append(toIndentedString(errorDetails)).append("\n");
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

