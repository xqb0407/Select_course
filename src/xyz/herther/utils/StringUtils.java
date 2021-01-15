 package xyz.herther.utils;
/**
  *   验证是否为空 
 * @author 34675
 *
 */
public class StringUtils {
	public static boolean isEmpty(String str) {
		
		if(str==null||str.trim().isEmpty()) {
			return true;
		}
		return false;
	}
}
