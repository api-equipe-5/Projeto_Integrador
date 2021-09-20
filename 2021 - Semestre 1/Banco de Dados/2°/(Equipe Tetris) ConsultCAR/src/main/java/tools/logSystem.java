package tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogSystem {
	
	public void logWriter(String text) throws IOException {
		File file = new File(("C:\\Users\\Davi Machado\\Desktop\\ConsultCar\\log.txt"));
		
		FileWriter fw = new FileWriter(file, true); 
        BufferedWriter br = new BufferedWriter(fw); 
        
        br.append("[" + Data() + "]" + ":" + text);
        br.newLine();
        br.close();
        fw.close();
	}
	
	public static String Data() {
		Date dataLog = new Date();
		SimpleDateFormat formatoData = new SimpleDateFormat();
	    
		formatoData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    
	    return formatoData.format(dataLog);
		
	}
	
}