/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package scanfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String fname = System.getProperty("user.home") + "/tab.txt";
		ArrayList<Integer> numbers = new ArrayList<>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fname));
			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					numbers.add(scanner.nextInt());
				} else {
					System.out.println("***");
					return;
				}
			}
			Integer[] array = convertToArray(numbers);
			ArrayList<Integer> maxValueIndices = findMaxValueIndices(array);

			System.out.println(arrayListToString(numbers));
			System.out.println(array[maxValueIndices.get(0)]);
			System.out.println(arrayListToString(maxValueIndices));
		} catch (FileNotFoundException e) {
			System.out.println("***");
			return;
		} finally {
			if (scanner != null)
				scanner.close();
		}

	}

	private static String arrayListToString(ArrayList<Integer> arrayList) {
		StringBuilder stringB = new StringBuilder();
		for (int i = 0; i < arrayList.size(); i++) {
			stringB.append(arrayList.get(i) + " ");
		}
		return stringB.toString();
	}

	private static ArrayList<Integer> findMaxValueIndices(Integer[] array) {
		int maxValIndex = 0;
		ArrayList<Integer> maxValueIndices = new ArrayList<>();
		maxValueIndices.add(maxValIndex);
		for (int i = 1; i < array.length; i++) {
			if (array[maxValIndex] < array[i]) {
				maxValueIndices.clear();
				maxValIndex = i;
				maxValueIndices.add(maxValIndex);
			} else if (array[maxValIndex] == array[i]) {
				maxValIndex = i;
				maxValueIndices.add(maxValIndex);
			}
		}
		return maxValueIndices;
	}

	private static Integer[] convertToArray(ArrayList<Integer> numbers) {
		Integer[] array = new Integer[numbers.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = numbers.get(i);
		}
		return array;
	}

}
