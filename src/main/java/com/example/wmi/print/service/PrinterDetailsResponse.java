package com.example.wmi.print.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrinterDetailsResponse {
	
	private List<String> name;
	
	private String computerName;
	
	private String type;
	
	private List<String> driverName;
	
	private List<String> portName;
	
	private boolean shared;
	
	private boolean published;
	
	private String deviceType;
	
	
	
	

}
