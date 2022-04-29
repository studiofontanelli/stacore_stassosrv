import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

import it.csi.iride2.policy.base.nmsf.stub.base.entity.Identita;
import it.csi.stacore.stassosrv.util.XmlSerializer;

public class ParseIdentita {
	
	
	public static void main(String [] args) {
		
		String token = "AAAAAA00A11C000K/Csi Piemonte/Demo 22/IPA/20220428182942/2/VNE8kD8mvnsKxgMu9xtU6g==";
		System.out.println("token= " + token);
		
		
		Identita identita = new Identita();
		StringTokenizer st = new StringTokenizer(token,"/");
		
		
		while(st.hasMoreElements()) {
			
			String sss = (String)st.nextElement();
			
			System.out.println("sss= " + sss);
		}
		
		
		
		String [] record = StringUtils.split(token, "/");
		
		identita.setCodFiscale(record[0]);
		identita.setNome(record[1]);
		identita.setCognome(record[2]);
		identita.setIdProvider(record[3]);
		identita.setTimestamp(record[4]);
		identita.setLivelloAutenticazione(new Integer(record[5]));
		identita.setRappresentazioneInterna(record[6]);
		
		System.out.println("identita\n " + XmlSerializer.objectToXml(identita));
		
	}

}
