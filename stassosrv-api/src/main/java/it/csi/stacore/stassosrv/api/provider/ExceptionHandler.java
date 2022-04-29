package it.csi.stacore.stassosrv.api.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.spi.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import it.csi.stacore.stassosrv.api.adapter.ErrorDetailAdapter;
import it.csi.stacore.stassosrv.api.dto.ErrorDto;
import it.csi.stacore.stassosrv.business.exception.NoDataFoundException;
import it.csi.stacore.stassosrv.business.exception.ValidationException;
import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.XmlSerializer;



@Provider
public class ExceptionHandler implements ExceptionMapper<RuntimeException> {

	private Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);

	@Autowired
	private ErrorDetailAdapter errorDetailAdapter;

	public Response toResponse(RuntimeException exception) {
		String method = "toResponse";

		Tracer.info(LOG, getClass().getName(), method, "Exception " + exception);

		ErrorDto e = new ErrorDto();
		e.setDescription(exception.getMessage());

		HttpStatus httpStatus = null;

		if(exception instanceof ValidationException) {
			httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
			
			if(((ValidationException)exception).getErrorDetails() != null)
				e.setErrorDetails(errorDetailAdapter.convertFrom(((ValidationException)exception).getErrorDetails()));
			
		}
		else if(exception instanceof UnauthorizedException) {
			httpStatus = HttpStatus.UNAUTHORIZED;
		}

		else if(exception instanceof NoDataFoundException) {
			httpStatus = HttpStatus.NOT_FOUND;
		}

		else {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}


		e.setStatus(httpStatus.value());
		e.setCode(httpStatus.getReasonPhrase());


		Tracer.info(LOG, getClass().getName(), method, "ExceptionDto\n " + XmlSerializer.objectToXml(e));

		return Response.status(e.getStatus()).entity(e).build();
	}
}