package day4;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringPractice_answer {
    public static void main(String[] args) {
        // 1.文字の長さを出力する length
        String s1 = "123";
        // 文字の長さを出力
        System.out.println(s1.length());
        // 2.文字の位置を出力する
        String s2 = "0123.5689.";
        // 最初の.のインデックスを出力 indexOf indexは１文字目は0
        System.out.println(s2.indexOf("."));
        // 最後.のインデックスを出力 lastIndexOf
        System.out.println(s2.lastIndexOf("."));
        // 3.部分文字列を出力する substring(int beginIndex　開始する位置,int endIndex　最後の次のもじ) substring(int endIndex)
        String s3 = "01234567";
        // 012を出力
        System.out.println(s3.substring(0, 3));
        // 3を出力
        System.out.println(s3.substring(3, 4));
        // 4567を出力
        System.out.println(s3.substring(4));
        String s4 = "1";
        System.err.println(s4.substring(1));
        // 4.大文字化 toUpperCase
        String lowerCase = "japan";
        System.out.println(lowerCase.toUpperCase());
        // 5.小文字化 toLowerCase
        String UpperCase = "JAPAN";
        System.out.println(UpperCase.toLowerCase());
        // 6. 前後の半角スペースを削除 trim *全角スペースは対象になりません。
        String withBlank = " blank ";
        System.out.println(withBlank.trim());

        System.out.println(changeDomain("xxxx@worksap-hi.co.jp", "@gmail.com"));
        System.out.println(createMail("sun", "Xin", 2, "gmail.com"));
        System.out.println(splitSub("jimi suBN marShaL", "-"));
    }

    private static String changeDomain(String mailAddress, String domain) {
        int begin = mailAddress.indexOf("@");
        String mailDomain = mailAddress.substring(begin);
        return mailAddress.replace(mailDomain, domain);
    }

    private static String createMail(String firstName, String lastName, int length, String domain) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName.toLowerCase());
        sb.append("_");
        String last = lastName.length() > length ? lastName.substring(0, length).toLowerCase() : lastName.toLowerCase();
        sb.append(last);
        return sb.append("@").append(domain).toString();
    }

    private static String splitSub(String target, String delimiter) {
        return Arrays.stream(target.toLowerCase().split("\\s"))
                .map(StringUtils::capitalize).collect(Collectors.joining(delimiter));
    }
}

