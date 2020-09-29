package day18;

import java.util.Arrays;

public class ArrayTutorial {

	public static void main(String[] args) {

		String[] array1 = new String[] { "a", "b", "c" };

		// array1から別のarrayを作成 Arrays.copyOf　コピー元と新たに作成されるサイズを引数
		String[] array2 = Arrays.copyOf(array1, 5);

		for (int s = 0; s < array2.length; s++) {
			System.out.println(array2[s]);
		}

	}

}
