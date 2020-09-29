package day18;

import java.util.Arrays;

public class SimplifiedStringArrayList_Answer {

	private String[] data;
	private int lastIndex = -1;
	private static final int DEFAULT_CAPACITY = 10;

	public SimplifiedStringArrayList_Answer() {
		data = new String[DEFAULT_CAPACITY];
	}

	public SimplifiedStringArrayList_Answer(int defaultCapacity) {
		this.data = new String[defaultCapacity];
	}

	public boolean add(String element) {

		lastIndex++;

		if (lastIndex == data.length) {
			grow();
		}

		data[lastIndex] = element;
		return true;
	}

	public String get(int index) {

		return data[index];
	}

	public String toString() {
		return String.join("", data);
	}

	private void grow() {
		data = Arrays.copyOf(data, data.length + (data.length >> 1));
	}

}
