/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.stacore.stassosrv.api.service;

import it.csi.stacore.stassosrv.api.dto.*;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import it.csi.stacore.stassosrv.api.dto.ErrorDto;
import it.csi.stacore.stassosrv.api.dto.GenericResponse;

import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/test")


@io.swagger.annotations.Api(description = "the test API")

public interface TestApi  {
   
    @GET
    @Path("/resources")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Test resources", notes = "Effettua il test dei servizi richiamati", response = GenericResponse.class, tags={ "test", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    public Response testResources(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders );
}
