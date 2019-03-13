package teksteditor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileManager {

	public static String readFile(String path) throws IOException{
		 BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "Cp1250"));
         String s = "";

		    int c;
		    while ((c = reader.read()) != -1) s += (char) c;
		 
		
		String text = new String(Files.readAllBytes(Paths.get(path)));
		return s;
	}

	public static void saveFile(String path, String text) throws IOException{
		Files.write(Paths.get(path), text.getBytes(StandardCharsets.UTF_8), 
				StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
	}
	
	
}
