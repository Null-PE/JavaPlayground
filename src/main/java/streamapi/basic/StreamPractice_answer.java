package streamapi.basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import common.Person;

/**
 * Java SE8 StreamAPIの練習
 * 今日の課題は： no for-loop
 */
public class StreamPractice_answer {
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
		people.forEach(System.out::println);

		/*
		問題２ 20才未満の人の情報を出力する
		 */
		people.stream().filter(p -> p.getAge() < 20).forEach(System.out::println);
		/*
		問題３ 年齢昇順でリストを出力する
		 */
		people.stream().sorted(Comparator.comparingInt(Person::getAge))
				.forEach(System.out::println);

		/*
		問題４ 全員の名前をカンマ(,)区切りで出力する
		 */
		System.out.println(people.stream()
				.map(Person::getName).collect(Collectors.joining(",")));

		/*
		最終問題
		"Charlie"はリストに入っているかを確認する時、一番いい方法は？その理由は？
		 */
		System.out.println(people.stream().anyMatch(p -> p.getName().equals("Charlie")));

		/**
         * 考えてみて
		 */
		lastOne(people);
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


	/**
	 * 出力結果は？
	 */
	private static void lastOne(List<Person> people) {
		people.stream()
				.peek(System.out::println)
				.filter(p -> p.getAge() < 20)
				.limit(1)
				.forEach(System.out::println);
	}

}
