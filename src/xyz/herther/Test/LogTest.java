package xyz.herther.Test;
/**
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-18 14:58:36
* ��˵��
*/

import org.junit.Test;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.level.Level;

public class LogTest {
	
	@Test
	public void LogTest1() {
		Log log = LogFactory.get();
		
		log.debug("This is {} log", Level.DEBUG);
		log.info("This is {} log", Level.INFO);
		log.warn("This is {} log", Level.WARN);
		
	}
}

