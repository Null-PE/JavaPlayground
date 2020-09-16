package day11;

import java.util.ArrayList;
import java.util.List;

public class StringPlusPerformanceCompare {

	private static final String S1 = "s";

	public static void main(String[] args) {

		int size = 1500000;

		// logConcat(size);
		// logPlus(size);
		// logStringBuffer(size);
		// logStringBufferWithCapacitySpecified(size);

		// logStringBuilder(size);
		// logStringBuilderCapacitySpecified(size);

		// logSizeByNewStr(size);
		// logSizeByCachedStr(size);

	}

	public static void logSizeByCachedStr(int size) {

		List<String> l = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			l.add(S1);
		}

		long free = Runtime.getRuntime().freeMemory() / 1024;
		long total = Runtime.getRuntime().totalMemory() / 1024;
		long using = total - free;
		System.out.println(using);

	}

	public static void logSizeByNewStr(int size) {

		List<String> l = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			l.add(new String("1"));
		}

		long free = Runtime.getRuntime().freeMemory() / 1024;
		long total = Runtime.getRuntime().totalMemory() / 1024;
		long using = total - free;

		System.out.println(using);

	}

	public static void logStringBuilder(int size) {

		long startTime = System.currentTimeMillis();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(S1);
		}
		sb.toString();

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

	}

	public static void logStringBuilderCapacitySpecified(int size) {

		long startTime = System.currentTimeMillis();

		StringBuilder sb = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			sb.append(S1);
		}
		sb.toString();

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

	}

	public static void logPlus(int size) {

		long startTime = System.currentTimeMillis();

		String s = "";
		for (int i = 0; i < size; i++) {
			s = s + S1;
		}

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

	}

	public static void logStringBuffer(int size) {

		long startTime = System.currentTimeMillis();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			sb.append(S1);
		}
		sb.toString();

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

	}

	public static void logStringBufferWithCapacitySpecified(int size) {

		long startTime = System.currentTimeMillis();

		StringBuffer sb = new StringBuffer(size);
		for (int i = 0; i < size; i++) {
			sb.append(S1);
		}
		sb.toString();

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

	}

	public static void logConcat(int size) {

		long startTime = System.currentTimeMillis();

		String s = "";
		for (int i = 0; i < size; i++) {
			s = s.concat(S1);
		}

		long endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);

	}

}
