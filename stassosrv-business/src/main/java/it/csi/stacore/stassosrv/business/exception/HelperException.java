package it.csi.stacore.stassosrv.business.exception;

import java.util.List;

import it.csi.stacore.stassosrv.business.dto.ErrorDetailDto;



;

/**
 * @author andreafontanelli
 *
 */
public class HelperException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -1924852710233061982L;


	protected List<ErrorDetailDto> errorDetails;

	public HelperException() {
		super();
	}

	public HelperException(List<ErrorDetailDto> errorDetails) {
		super();
		this.errorDetails = errorDetails;
	}


	public HelperException(String message, Throwable cause) {
		super(message, cause);

	}
	public HelperException(String message, Throwable cause, List<ErrorDetailDto> errorDetails) {
		super(message, cause);
		this.errorDetails = errorDetails;

	}

	public HelperException(String message) {
		super(message);

	}
	public HelperException(String message, List<ErrorDetailDto> errorDetails) {
		super(message);
		this.errorDetails = errorDetails;
	}


	public HelperException(Throwable cause) {
		super(cause);

	}

	public List<ErrorDetailDto> getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(List<ErrorDetailDto> errorDetails) {
		this.errorDetails = errorDetails;
	}



}