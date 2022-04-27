package it.csi.stacore.stassosrv.business.dto;

import java.io.Serializable;

public class ErrorDetailDto  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String field = null;
	private String error = null;
	
	public ErrorDetailDto(String field, String error) {
		this.field = field;
		this.error = error;
	}

	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}


	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}


	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ErrorDetail {\n");
		sb.append("    field: ").append(toIndentedString(field)).append("\n");
		sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

