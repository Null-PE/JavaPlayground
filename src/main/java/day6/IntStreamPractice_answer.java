package day6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamPractice_answer {
    public static void main(String[] args) {
        /*
        事前知識：IntStreamをゲットする方法
        IntStream.range(1, 6).forEach(System.out::println);
        IntStream.of(1,2,3,4,5).forEach(System.out::println);
        IntStream.iterate(0, i -> i * 2).limit(5).forEach(System.out::println);
        IntStream.generate(() -> (int)(Math.random()*100)).limit(5).forEach(System.out::println);
        Arrays.stream("1,2,3,4,5".split(",")).mapToInt(Integer::parseInt).forEach(System.out::println);
         */

        /*
        課題１ 標準出力System.out.println()を使って、1から100までカウント
         */
        IntStream.range(1,101).forEach(System.out::println);
        /*
        課題２ 50以上100以下3の倍数を配列int[]に保存する
         */
        int[] arr = IntStream.range(50, 100).filter(i -> i % 3 == 0).toArray();

        /*
        課題３ 文字列strに入っている数字の合計を取得
         */
        String str = "5,2,10,50,16,1,20";
        int sum = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).sum();

        /*
        課題４　社員リストから平均年齢を計算する
         */
        List<Employee> EmployeeList = getEmployeeList();
        EmployeeList.stream().mapToInt(Employee::getAge).average().ifPresent(System.out::println);

        /*
         最終問題：配列aとbを合併して、重複なし+昇順で出力する
         */
        int[] a = {10, 5, 31, 9, 5};
        int[] b = {2, 32, 5, 15, 9};
        Stream.of(a,b).flatMapToInt(IntStream::of).distinct().sorted().forEach(System.out::println);

    }


    /**
     * 課題用のリストを作る
     */
    private static List<Employee> getEmployeeList() {
        return IntStream.range(20,50)
                .mapToObj(i -> new Employee(i+"さん",i))
                .collect(Collectors.toList());
    }
}
