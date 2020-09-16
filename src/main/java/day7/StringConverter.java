package day7;

public class StringConverter {

    /**
     * 引数に含まれる[a-z0-9]以外の文字を置換してください
     * 仕様1: [a-z0-9]の文字は置換しないでください
     * 仕様2: 空白文字はまとめてハイフン（-）に置換してください
     *       (例: @{code: "hoge  \nfuga"}は @{code: "hoge-fuga"})
     * 仕様3: 大文字は小文字にしてください
     * 仕様4: それ以外の文字は１文字ずつアンダースコア(_)に置換してください
     * @param name
     * @return @{code: "[a-z0-9_-]*"}のみを含む文字列
     */
    public String sanitizeName(String name) {
    	StringBuilder sb = new StringBuilder();
    	boolean prevCharIsSpace = false;;
    	for(int i = 0; i < name.length(); i++) {
    		char current = name.charAt(i);
    		if( '0' <= current && current <= '9') {
    			sb.append(current);
    		}else if( 'a' <= current && current <= 'z' ) {
    			sb.append(current);
    		}else if( 'A' <= current && current <= 'Z' ) {
    			sb.append(Character.toLowerCase(current));
    		}else if( Character.isWhitespace(current) ) {
    			if( !prevCharIsSpace) {
					sb.append('-');
    			}
    		}else {
    			sb.append('_');
    		}
			prevCharIsSpace = Character.isWhitespace(current);
    	}
        return sb.toString();
    }
}
