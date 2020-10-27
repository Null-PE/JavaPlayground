package designpattern.facade.answer;

public interface IRepositoryCommand {

	/**
	 * Gitの窓口として、シンプルなAPIを用意する。
	 */
	void upload();

}