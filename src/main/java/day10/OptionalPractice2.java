package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import day6.Employee;

/**
 * 対になるJUnit TestCaseが用意されています
 * Denebを利用している場合はCtrl+9で切り替え可能です
 * @see OptionalPractice2Test
 */
public class OptionalPractice2 {

	Optional<Employee> findEmployee(String name) {
		Employee employee = EmployeeFactory2.query(name);
		// 課題１: 下記の行を修正し、メソッドを完成する
		return null;
	}

	/**
	 * Employeeオブジェクトを見つけます
	 * @param name 取得するEmployeeの名前
	 * @param defaultEmployee 存在しない場合に返すEmployeeオブジェクト
	 * @return nullを返しません
	 */
	Employee findEmployeeOrDefault(String name, Employee defaultEmployee) {
		// 課題２: 下記の行を修正し、findEmployeeメソッドを呼び出した上で、メソッドを完成する
		return null;
	}

	/**
	 * Employeeオブジェクトを見つけます
	 * @param name 取得するEmployeeの名前
	 * @param defaultName 存在しない場合に返すEmployeeオブジェクトのname
	 * @param defaultAge存在しない場合に返すEmployeeオブジェクトのage
	 * @return nullを返しません
	 */
	Employee findEmployeeOrDefaultNameAndAge(String name, String defaultName, int defaultAge) {
		// 課題３: 下記の行を修正し、findEmployeeメソッドを呼び出した上で、メソッドを完成する
		return null;
	}

	/**
	 * GoldCoinのリストを取得します
	 */
	List<GoldCoin> getGoldCoin() {
		List<GoldCoin> coins = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			// 課題４: GoldCoinFactoryを通して、(このメソッドの初回呼び出し時において)8秒以内に5枚のGoldCoinを手に入れなさい
			// GoldCoinFactoryの実装を変更したり、直接GoldCoinをnewすることは禁止します
			// また、if文を使うことも禁止します
		}
		return coins;
	}
}
