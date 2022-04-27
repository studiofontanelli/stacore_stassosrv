package it.csi.stacore.stassosrv.business.exception;

import java.util.List;

import it.csi.stacore.stassosrv.business.dto.ErrorDetailDto;



/**
 * @author andreafontanelli
 *
 */
public class NoDataFoundException extends HelperException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1857783336963631825L;

	public NoDataFoundException() {
		super();
	}

	public NoDataFoundException(List<ErrorDetailDto> errorDetails) {
		super();
		this.errorDetails = errorDetails;
	}

	public NoDataFoundException(String message, List<ErrorDetailDto> errorDetails) {
		super(message);
		this.errorDetails = errorDetails;

	}

	public NoDataFoundException(String message) {
		super(message);

	}
}