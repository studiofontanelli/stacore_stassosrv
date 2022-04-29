package it.csi.stacore.stassosrv.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Environment {



	@Value("${iride_service_endpoint_url}")
	private String irideEndpoint;

	public String getIrideEndpoint() {
		return irideEndpoint;
	}

	public void setIrideEndpoint(String irideEndpoint) {
		this.irideEndpoint = irideEndpoint;
	}

	




}
