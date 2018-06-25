package com.example.wmi.print.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class CimClass implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6806143614583327279L;

	String CimSuperClassName;
	
	String CimSuperClass;
	
	//List<CimInstanceProperties> CimInstanceProperties;
	
	CimSystemProperties cimSystemProperties;
	
	String Name;
	
	String ComputerName;
	
	String Datatype;
	
	String DriverName;
	
	String Location;
	
	String PortName;
	
	String PrintProcessor;
	
	boolean Published;
	
	boolean Shared;
	
	String ShareName;

}
