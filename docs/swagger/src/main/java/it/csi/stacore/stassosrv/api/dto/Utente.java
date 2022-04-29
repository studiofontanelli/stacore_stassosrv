package it.csi.stacore.stassosrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import it.csi.stacore.stassosrv.api.dto.Cassa;
import it.csi.stacore.stassosrv.api.dto.Ente;
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
  
  private String id = null;
  private TipoUtente tipoUtente = null;
  private Ente ente = null;
  private List<Cassa> elencoCassa = new ArrayList<>();
  private List<Sportello> elencoSportello = new ArrayList<>();

  /**
   * Id Utente
   **/
  
  @ApiModelProperty(example = "Identificativo Utente", value = "Id Utente")

  // nome originario nello yaml: id 
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
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
    return Objects.equals(id, utente.id) &&
        Objects.equals(tipoUtente, utente.tipoUtente) &&
        Objects.equals(ente, utente.ente) &&
        Objects.equals(elencoCassa, utente.elencoCassa) &&
        Objects.equals(elencoSportello, utente.elencoSportello);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tipoUtente, ente, elencoCassa, elencoSportello);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Utente {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tipoUtente: ").append(toIndentedString(tipoUtente)).append("\n");
    sb.append("    ente: ").append(toIndentedString(ente)).append("\n");
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

