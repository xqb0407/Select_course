 package xyz.herther.utils;
/**
  *   ��֤�Ƿ�Ϊ�� 
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
