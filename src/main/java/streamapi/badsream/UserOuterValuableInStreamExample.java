package streamapi.badsream;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import streamapi.badsream.lib.BusinessSchemaDto;
import streamapi.badsream.lib.DbConfig;
import streamapi.badsream.lib.DbUtils;

public class UserOuterValuableInStreamExample {
    public static  final String DB_URL = "DB_URL";
    public static  final String DB_USER = "DB_USER";
    public static  final String DB_PASS = "DB_PASS";
	
    /**
     * 共通スキーマーからプロダクトごとの接続情報を持ってくる
     */
	public List<Map<String, String>> getBusinessSchemas(String jdbcurl, String username, String password) throws SQLException {
	    List<Map<String, String>> res = new ArrayList<Map<String, String>>();
	    BusinessSchemaDto dto = DbUtils.getBusinessSchemas(new DbConfig(jdbcurl, username, password));
	    dto.getSchemas().stream().forEach(schemaMap -> {
	        Map<String, String> temp = new HashMap<String, String>();
	        temp.put(DB_URL, jdbcurl);
	        temp.put(DB_USER, schemaMap.get(dto.SCHM_CD));
	        temp.put(DB_PASS, schemaMap.get(dto.SCHM_PASS));
	        res.add(temp);
	    });
	    return res;
	}
}
