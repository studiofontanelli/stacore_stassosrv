package it.csi.stacore.stassosrv.business.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ProfiloDto {
	
	
	private Map<String, AutorizzazioneDto > mapAbilitazioni = null;
	

	public ProfiloDto(List<AutorizzazioneDto> autorizzazioni) {
		mapAbilitazioni = new HashMap<String, AutorizzazioneDto>();
		for(AutorizzazioneDto auth : autorizzazioni) {
			mapAbilitazioni.put(auth.getCodice(), auth);	
		}	
	}
	
}
