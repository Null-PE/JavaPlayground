package day3;

import java.util.ArrayList;
import java.util.List;

/**
 * Java SE8 StreamAPIの練習
 * 今日の課題は： no for-loop
 */
public class StreamPractice {
	public static void main(String... arg) {
		/*
		 1. リストpeopleに五人の情報が保存しています。
		 2. クラスPersonには、名前(name)と年齢(age)二つの属性があります。
		 3. Person.toString()メソッドはオーバーライトずみ、
		   System.out.println((Person)person)で情報を出力することができます。
		 */
		List<Person> people = createList();
		/*
		問題１ 全員の情報を出力する
		 */

		/*
		問題２ 20才未満の人の情報を出力する
		 */

		/*
		問題３ 年齢昇順でリストを出力する
		 */

		/*
		問題４ 全員の名前をカンマ(,)区切りで出力する
		 */

		/*
		最終問題
		"Charlie"はリストに入っているかを確認する時、一番いい方法は？その理由は？
		 */


	}

	/**
	 * 練習用のリストを作成するためのメソッド
	 */
	private static List<Person> createList() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Alice", 22));
		people.add(new Person("Bob", 9));
		people.add(new Person("Charlie", 17));
		people.add(new Person("David", 15));
		people.add(new Person("Even", 13));
		return people;
	}


}
