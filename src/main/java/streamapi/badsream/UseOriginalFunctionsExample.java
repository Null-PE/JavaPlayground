package streamapi.badsream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.base.Function;

public class UseOriginalFunctionsExample {
    public static final String PRODUCT_REGEX = "([A-Z]+)(\\d{5}(\\d{3})?)(_(\\w+))?";
	public static final String PRODUCT_REGEX_NUMBER = "$2";

	/**
	 * バージョン番号順を昇順に並べる。  
	 * 同じバージョン番号だった場合に、バージョン番号に "_" を含むもののほうが後ろとする
	 */
	public static List<String> orderVersion(List<String> versionLst) {
	    return versionLst.stream().sorted(new Comparator<String>() {
	        @Override
	        public int compare(String o1, String o2) {
	            Function<String, Integer> getVerNum = verName -> Integer.valueOf(verName.replaceAll(PRODUCT_REGEX, PRODUCT_REGEX_NUMBER));
	            Predicate<String> isNormalPtf = ptf -> ptf.contains("_");
	            if (getVerNum.apply(o1).intValue() > getVerNum.apply(o2).intValue()) {
	                return 1;
	            } else if (getVerNum.apply(o1).intValue() == getVerNum.apply(o2).intValue()) {
	                return isNormalPtf.test(o1) ? -1 : 1;
	            }
	            return -1;
	        }
	    }).collect(Collectors.toList());
	    
	}
}
