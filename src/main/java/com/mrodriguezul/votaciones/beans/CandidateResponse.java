package com.mrodriguezul.votaciones.beans;

import java.io.Serializable;

public class CandidateResponse implements Serializable{
private static final long serialVersionUID = 1L;
	
	private String cod;
	private String msg;	
	
	public CandidateResponse(String cod, String msg) {
		super();
		this.cod = cod;
		this.msg = msg;
	}

	public String getCod() {
		return cod;
	}	
	
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
