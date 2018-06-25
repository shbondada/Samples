package com.example.wmi.print.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class PrinterTest {

	public static void main(String[] args) {
		/* System.out.println(
		            WMI4Java
		                .get()
		                .properties(Arrays.asList("Name", "WorkOffline"))
		                .filters(Arrays.asList("$_.WorkOffline -eq 0"))
		                .getRawWMIObjectOutput(WMIClass.WIN32_PRINTER)
		        );	*/
		
		String addPrinter="\"Add Printer connection suceeded!\"";
		String addPrinterWithReturnValue= "\"Add Printer connection failed with $($code.returnvalue)\"";
		String printpath="\"\\10.99.39.79\\HR-NPIAFCE19\"";
		//ProcessBuilder builder = new ProcessBuilder("powershell.exe", "get-wmiobject -class win32_printer | Select-Object Name, PrinterState, PrinterStatus | where {$_.PrinterState -eq 0 -And $_.PrinterStatus -eq 3}");
		//ProcessBuilder builder = new ProcessBuilder("powershell.exe","Function Get-SuccessCode($code){ if($code.ReturnValue -eq 0)  { Write-Host -foregroundcolor green "+ addPrinter +" } Else  { Write-Host -foregroundcolor red " + addPrinterWithReturnValue +" } } #end get-successcode");
		ProcessBuilder builder = new ProcessBuilder("powershell.exe","Get-Content -Path "+"C:\\PrinterTest\\SchedulerApplication.docx" +" | Out-Printer");//working
		//ProcessBuilder builder = new ProcessBuilder("powershell.exe","Start-Process -FilePath "+"C:\\PrinterTest\\SchedulerApplication.docx " +"-Verb print ");
		String fullStatus = null;
	    Process reg;
	    builder.redirectErrorStream(true);
	    try {
	        reg = builder.start();
	        fullStatus = getStringFromInputStream(reg.getInputStream());
	        reg.destroy();
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    }
	    System.out.print(fullStatus);
	}
	
	public static String getStringFromInputStream(InputStream is) {
	    ByteArrayOutputStream result = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024];
	    int length;
	    try {
	        while ((length = is.read(buffer)) != -1) {
	            result.write(buffer, 0, length);
	        }
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    }
	    // StandardCharsets.UTF_8.name() > JDK 7
	    String finalResult = "";
	    try {
	        finalResult = result.toString("UTF-8");
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	    return finalResult;
	}

}
