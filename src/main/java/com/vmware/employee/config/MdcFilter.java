package com.vmware.employee.config;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.vmware.employee.constants.EmployeeConstants;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class MdcFilter.
 */
@Component

/** The Constant log. */
@Slf4j
public class MdcFilter implements Filter {

    
    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            // Setup MDC data:
        	final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        	String currentTraceId = httpServletRequest.getHeader(EmployeeConstants.TRACE_ID);
        	
        	

            if(StringUtils.isEmpty(currentTraceId)) {
            	currentTraceId = UUID.randomUUID().toString().replaceAll("-", "");
                 log.trace("No traceId found in Header. Generated : " + currentTraceId);
            }

            MDC.put(EmployeeConstants.TRACE_ID, currentTraceId);
            chain.doFilter(request, response);
            
        }catch(Exception e)
        {
            
        }finally {
           MDC.clear( );
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
    }
}
