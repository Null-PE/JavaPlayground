package streamapi.badsream;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import streamapi.badsream.lib.VersionDao;
import streamapi.badsream.lib.VersionPo;

public class BigLambdaInSreamExample {

	private VersionDao versionDao;
	
	/**
	 * プロダクトコードと環境IDを取得して通常バージョンのみを抜き出す処理
	 */
	private List<VersionPo> getValidRemoteNormalVersion(String productCd, int environmentId) throws SQLException {

	    List<VersionPo> versions = versionDao.getValidRemoteNormal(productCd, environmentId);

	    return versions.stream()
	            .filter(t -> {
	                try {
	                    return matchBaseNormal(t);
	                } catch (SQLException e) {
	                    // logger.error(LoggerServer.CU, e);//ロガーも省略
	                    throw (new RuntimeException(e));
	                }
	            })
	            .collect(Collectors.toList());
	}

	private boolean matchBaseNormal(VersionPo t) throws SQLException {
		// DBアクセスを伴う複雑な処理（省略）
		return false;
	}

}
