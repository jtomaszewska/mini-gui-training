/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package stringcount;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CountWords {

	String text;

	public CountWords(String fname) throws Exception {
		FileReader file = null;
		try {
			file = new FileReader(fname);

			StringBuffer t = new StringBuffer();

			int i;
			while ((i = file.read()) != -1) {
				t.append((char) i);
			}
			text = t.toString();
		} finally {
			if (file != null)
				file.close();
		}
	}

	public List<String> getResult() {

		LinkedHashMap<String, Integer> wordCounts = new LinkedHashMap<>();
		for (String word : text.split("\\W+")) {
			if (wordCounts.containsKey(word)) {
				wordCounts.put(word, wordCounts.get(word) + 1);
			} else {
				wordCounts.put(word, 1);
			}
		}
		ArrayList<String> words = new ArrayList<String>();
		for (String word : wordCounts.keySet()) {
			words.add(word + " " + wordCounts.get(word));
		}

		return words;
	}
}
