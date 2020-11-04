package chohan;

public interface ChohanGame {

	/**
	 * 判定をおこないます
	 * @param player
	 * @return playerの勝利: true, playerの敗北: false
	 */
	boolean game(Player player);

}