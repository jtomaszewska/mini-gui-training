package threadsinshopsystem;

import java.util.concurrent.LinkedBlockingQueue;

public class DaneDzielone {

	private LinkedBlockingQueue<Towary> powstaleTowary = new LinkedBlockingQueue<>();

	public void putTowar(Towary t) {
		try {
			powstaleTowary.put(t);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		synchronized (this) {
			notifyAll();
		}

	}

	public Towary takeTowar() {
		while (powstaleTowary.isEmpty()) {
			try {
				synchronized (this) {
					wait();
				}
			} catch (InterruptedException exc) {
			}
		}
		Towary t;
		try {
			t = powstaleTowary.take();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		synchronized (this) {
			notifyAll();
		}
		return t;
	}

}
