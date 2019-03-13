package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Hailstone implements Iterable<Integer>, Iterator<Integer> {

	private int currentElement;
	private boolean isFirst;

	public Hailstone(int beginning) {
		isFirst = true;
		currentElement = beginning;
	}

	@Override
	public Iterator<Integer> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return currentElement > 1;
	}

	@Override
	public Integer next() {
		if (isFirst){
			isFirst = false;
			return currentElement;
		}
		if (hasNext()) {
			if (currentElement % 2 != 0) {
				currentElement = 3 * currentElement + 1;
				return currentElement;
			}
			currentElement = currentElement / 2;
			return currentElement;
		}
		throw new NoSuchElementException();
	}

}
