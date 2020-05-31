package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@Table(name = "T_ERROR_LOGS")
public class ErrorLog {

	private Integer errId;
	private String source, method;
	private Date errorOn; 	
	private String message, stackTrace;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "errId")
	public Integer getErrId() {
		return errId;
	}
	public void setErrId(Integer errId) {
		this.errId = errId;
	}
	
	@Column(length =150)
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	@Column(length =150)
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "errorOn")
	public Date getErrorOn() {
		return errorOn;
	}
	public void setErrorOn(Date errorOn) {
		this.errorOn = errorOn;
	}
	
	@Column(length =250)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Column(name = "stackTrace")
	public String getStackTrace() {
		return stackTrace;
		}
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	
	
}