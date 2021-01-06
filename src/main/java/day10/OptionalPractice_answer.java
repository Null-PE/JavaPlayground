package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import common.Employee;

/**
 * OptionalPractice2の模範解答です
 * @see OptionalPractice2
 */
public class OptionalPractice_answer {

	Optional<Employee> findEmployee(String name) {
		Employee employee = EmployeeFactory2.query(name);
		// 課題１: 下記の行を修正し、メソッドを完成する
		// NG: return Optional.of(employee);
		return Optional.ofNullable(employee);
	}

	/**
	 * Employeeオブジェクトを見つけます
	 * @param name 取得するEmployeeの名前
	 * @param defaultEmployee 存在しない場合に返すEmployeeオブジェクト
	 * @return nullを返しません
	 */
	Employee findEmployeeOrDefault(String name, Employee defaultEmployee) {
		// 課題２: 下記の行を修正し、findEmployeeメソッドを呼び出した上で、メソッドを完成する
		return findEmployee(name).orElse(defaultEmployee);
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

		// orElseは効率が悪い: return findEmployee(name).orElse(new Employee(defaultName, defaultAge));
		return findEmployee(name).orElseGet(() -> new Employee(defaultName, defaultAge));
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

			// NG: GoldCoin goldCoin = GoldCoinFactory.getCoin().orElse(GoldCoinFactory.mine());

			GoldCoin goldCoin = GoldCoinFactory.getCoin().orElseGet(() -> GoldCoinFactory.mine());
			// 別解: メソッド参照を利用した場合
			// GoldCoin goldCoin = GoldCoinFactory.getCoin().orElseGet(GoldCoinFactory::mine);

			coins.add(goldCoin);
		}
		return coins;
	}
}
