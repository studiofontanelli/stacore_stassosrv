package it.csi.stacore.stassosrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import it.csi.stacore.stassosrv.api.dto.Cassa;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="Abilitazione")

public class Abilitazione  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private List<Cassa> elencoCasse = new ArrayList<>();

  /**
   * Elenco casse
   **/
  
  @ApiModelProperty(value = "Elenco casse")

  // nome originario nello yaml: elencoCasse 
  public List<Cassa> getElencoCasse() {
    return elencoCasse;
  }
  public void setElencoCasse(List<Cassa> elencoCasse) {
    this.elencoCasse = elencoCasse;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Abilitazione abilitazione = (Abilitazione) o;
    return Objects.equals(elencoCasse, abilitazione.elencoCasse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elencoCasse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Abilitazione {\n");
    
    sb.append("    elencoCasse: ").append(toIndentedString(elencoCasse)).append("\n");
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

