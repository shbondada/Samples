package com.example.wmi.print.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CimInstanceProperties implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3517025580067415095L;
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
