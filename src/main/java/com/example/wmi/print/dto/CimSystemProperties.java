package com.example.wmi.print.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CimSystemProperties implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3360954599722696455L;
	String Namespace;
	String ServerName;
	String ClassName;

}
