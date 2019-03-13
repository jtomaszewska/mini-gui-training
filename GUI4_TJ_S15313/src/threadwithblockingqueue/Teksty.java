package threadwithblockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class Teksty {

	private class StringWrapper {
		String value;

		public StringWrapper(String value) {
			super();
			this.value = value;
		}

	}

	LinkedBlockingQueue<StringWrapper> txt = new LinkedBlockingQueue<>();
	// StringWrapper poisonPill = new StringWrapper(null);

	// Metoda ustalaj�ca tekst - wywo�uje Autor
	void setTextToWrite(String s) {
		try {
			txt.put(new StringWrapper(s));
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		synchronized (this) {
			notifyAll();
		}
	}

	// Metoda pobrania tekstu - wywo�uje Writer
	String getTextToWrite() {
		while (txt.isEmpty()) {
			try {
				synchronized (this) {
					wait();
				}	
			} catch (InterruptedException exc) {
			}
		}
		String napis;
		try {
			napis = txt.take().value;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		synchronized (this) {
			notifyAll();
		}
		return napis;
	}
}
