package com.personal.message.dto;

import java.io.Serializable;

public class Message implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String header;
	private String desc;
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
