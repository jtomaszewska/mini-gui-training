package threadsrace;

import java.util.ArrayList;

public class Letters {

	ArrayList<Thread> threads = new ArrayList<>();

	public Letters(String s) {
		char[] lettersArray = s.toCharArray();
		for (char letter : lettersArray) {
			this.threads.add(new Thread(() -> {
				while (true) {
					System.out.print(letter);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						//System.out.println("koniec dzialania watku " + letter);
						return;
					}
				}
			}, new String("Thread " + letter)));
		}
	}

	public ArrayList<Thread> getThreads() {
		return threads;
	}

}
