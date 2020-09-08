package day5;

import com.google.common.base.Splitter;

public class GuavaPractice {
    public static void main(String[] args) {
        test1("kobayashi,yamamoto,sun",",");
        test1("kobayashi,yamamoto,sun",".");
    }

    private static void test1(String str, String delimiter) {
        Splitter.on(delimiter).split(str).forEach(System.out::println);
    }
}
