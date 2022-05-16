package it.csi.stacore.stassosrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import it.csi.stacore.stassosrv.api.dto.Abilitazione;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="Profilo Utente")

public class Profilo  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private List<Abilitazione> elencoAbilitazione = new ArrayList<>();

  /**
   * Elenco casse
   **/
  
  @ApiModelProperty(value = "Elenco casse")

  // nome originario nello yaml: elencoAbilitazione 
  public List<Abilitazione> getElencoAbilitazione() {
    return elencoAbilitazione;
  }
  public void setElencoAbilitazione(List<Abilitazione> elencoAbilitazione) {
    this.elencoAbilitazione = elencoAbilitazione;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Profilo profilo = (Profilo) o;
    return Objects.equals(elencoAbilitazione, profilo.elencoAbilitazione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elencoAbilitazione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Profilo {\n");
    
    sb.append("    elencoAbilitazione: ").append(toIndentedString(elencoAbilitazione)).append("\n");
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

