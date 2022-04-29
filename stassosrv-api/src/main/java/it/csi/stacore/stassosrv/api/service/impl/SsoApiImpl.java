package it.csi.stacore.stassosrv.api.service.impl;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.stacore.stassosrv.api.dto.GenericResponse;
import it.csi.stacore.stassosrv.api.service.SsoApi;
import it.csi.stacore.stassosrv.business.helper.IrideHelper;
import it.csi.stacore.stassosrv.business.helper.TestResourceHelper;



@Component("ssoApi")
public class SsoApiImpl implements SsoApi {

	@Autowired
	private TestResourceHelper testResourceHelper;
	
	@Autowired
	private IrideHelper irideHelper;

	public Response testResources(SecurityContext securityContext, HttpHeaders httpHeaders ) {
		GenericResponse response = new GenericResponse();
		boolean testResource = testResourceHelper.testResources();
		if(testResource)
			response.setMessage("TUTTO OK");
		else
			response.setMessage("TEST RESOURCE KO");

		return Response.ok().entity(response).build();
	}

	@Override
	public Response getUtente(@NotNull String identita, SecurityContext securityContext, HttpHeaders httpHeaders) {
		return Response.ok().entity(irideHelper.getUtente(identita)).build();
	}

}
