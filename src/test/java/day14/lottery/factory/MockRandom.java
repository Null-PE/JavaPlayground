package day14.lottery.factory;

import java.util.Iterator;
import java.util.Random;

public class MockRandom extends Random {

	private Iterator<Integer> iterator;
	private int callCount;

	public MockRandom(Iterator<Integer> iterator) {
		this.iterator = iterator;
	}

	@Override
	public int nextInt(int bound) {
		if( bound != 9 ) {
			throw new IllegalArgumentException("bound must be 9 but found " + bound);
		}
		callCount++;
		return iterator.next();
	}

	public int getCallCount() {
		return callCount;
	}


}
