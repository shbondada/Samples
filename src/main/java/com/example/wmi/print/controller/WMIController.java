package com.example.wmi.print.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.copart.json.CopartGson;
import com.example.wmi.print.dto.CimClass;
import com.example.wmi.print.service.WMIClass;
import com.example.wmi.print.service.WMIService;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "v1")
@Slf4j
public class WMIController {

	@Autowired
	public WMIService wmiJava;

	private Gson gson = CopartGson.getCopartGson();

	@RequestMapping(value = "/listWMIObjects")
	@ResponseBody
	public ResponseEntity<String> testRemoteMachine(@RequestParam String wmiClass) {
		List<Map<String, String>> response = wmiJava.getWMIObjectList(WMIClass.valueOf(wmiClass));
		return new ResponseEntity<>(gson.toJson(response), null, HttpStatus.OK);
	}

	/*
	 * @GetMapping(value = "/print")
	 * 
	 * @ResponseBody public ResponseEntity<String> printDocument(@RequestParam
	 * String attachedDocument) {
	 * 
	 * String response = wmiJava.printObject(attachedDocument); return new
	 * ResponseEntity<>(gson.toJson(response), null, HttpStatus.OK); }
	 */

	@GetMapping(value = "/list")
	@ResponseBody
	public ResponseEntity<String> printerDetails(@RequestParam String serverName) {
		List<CimClass> cimClassResponse = null;
		try {
			cimClassResponse = wmiJava.listOfPrinterAttributes(serverName);
		} catch (JSONException e) {
			log.error("Exception while getting printer details: " + e.getMessage());
		}
		return new ResponseEntity<>(gson.toJson(cimClassResponse), null, HttpStatus.OK);
	}

	@PostMapping("/print")
	public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {
		String response = null;
		response = wmiJava.printObject(file);

		return new ResponseEntity<>(gson.toJson(response), null, HttpStatus.OK);
	}

}
