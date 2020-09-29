package day18;

public class SimplifiedStringArrayList {

	private String[] data;
	private int lastIndex;

	private static final int DEFAULT_CAPACITY = 10;

	public SimplifiedStringArrayList() {
		data = new String[DEFAULT_CAPACITY];
	}

	public SimplifiedStringArrayList(int defaultCapacity) {
		if (defaultCapacity > DEFAULT_CAPACITY) {
			data = new String[defaultCapacity];
		} else {
			data = new String[DEFAULT_CAPACITY];
		}
	}

	public boolean add(String element) {
		// TODO
		return true;
	}

	public String get(int index) {
		// TODO
		return null;
	}

	public String toString() {
		// TODO
		return null;
	}

}
