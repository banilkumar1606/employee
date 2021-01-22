package com.vmware.employee.exceptions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Gets the message.
 *
 * @return the message
 */
@Getter

/**
 * Sets the message.
 *
 * @param message the new message
 */
@Setter

/**
 * Instantiates a new log ref class.
 *
 * @param logRef the log ref
 * @param status the status
 * @param message the message
 */
@AllArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder
public class LogRefClass {

    /** The log ref. */
    private String  logRef;
    
    /** The status. */
    private Integer status;
    
    /** The message. */
    private String  message;

}