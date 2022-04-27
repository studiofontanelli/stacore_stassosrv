package it.csi.stacore.stassosrv.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Environment {



	@Value("${index_service_endpoint_url}")
	private String indexEndpoint;

	public String getIndexEndpoint() {
		return indexEndpoint;
	}

	public void setIndexEndpoint(String indexEndpoint) {
		this.indexEndpoint = indexEndpoint;
	}






}
