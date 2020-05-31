package com.app.pojos;

public class Response {
	private Object data;
	private String status;
	
	public Response() {
		// TODO Auto-generated constructor stub
	}
	
	public Response(Object data, String status) {
		super();
		this.data = data;
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
