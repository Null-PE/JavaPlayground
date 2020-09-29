package day18;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPerformance {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 100001; i++) {
			list.add(String.valueOf(i));
		}

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime + "ミリ秒");

		startTime = System.currentTimeMillis();
		List<String> list2 = new ArrayList<String>(100000);
		for (int i = 0; i < 100001; i++) {
			list2.add(String.valueOf(i));
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime + "ミリ秒");

	}

}
