/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package regexfromfile;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {

	public String text;

	public Finder(String fname) throws Exception {
		FileReader file = null;
		try {
			file = new FileReader(fname);
			
			StringBuffer t = new StringBuffer();

			int i;
			while ((i = file.read()) != -1) {
				t.append((char) i);
			}
			text = t.toString();
		}
		finally {
			if (file != null)
				file.close();
		}

	}

	public int getIfCount() {
		Pattern commentPattern = Pattern.compile("\\/\\/+[^\\n]+|\\/\\*+[^\\*]+\\*\\/|\"[^\"]+\"");
		Matcher commentMatcher = commentPattern.matcher(text);
		String newText = commentMatcher.replaceAll("");

		Pattern ifPattern = Pattern.compile("[^if]if[\\s]*[(]");
		Matcher ifMatcher = ifPattern.matcher(newText);
		int valueOfInt = 0;
		while (ifMatcher.find()) {
			valueOfInt++;
		}

		return valueOfInt;
	}

	public int getStringCount(String argument) {
		Pattern p = Pattern.compile(argument);
		Matcher m = p.matcher(text);
		int counter = 0;
		while (m.find()) {
			counter++;

		}
		return counter;
	}
}
