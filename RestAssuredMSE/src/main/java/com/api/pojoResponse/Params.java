package com.api.pojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Params {
	private String resmsgid;
	private String msgid;
	private String err;
	private String status;
	private String errmsg;


	// Getter Methods 

	public String getResmsgid() {
		return resmsgid;
	}

	public String getMsgid() {
		return msgid;
	}

	public String getErr() {
		return err;
	}

	public String getStatus() {
		return status;
	}

	public String getErrmsg() {
		return errmsg;
	}

	// Setter Methods 

	public void setResmsgid(String resmsgid) {
		this.resmsgid = resmsgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
