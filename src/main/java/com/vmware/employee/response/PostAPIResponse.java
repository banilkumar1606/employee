package com.vmware.employee.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new post API response.
 */
@NoArgsConstructor
public class PostAPIResponse {
	
	/** The transaction id. */
	private String transactionId;
}
