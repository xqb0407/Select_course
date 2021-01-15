package xyz.herther.Test;

import org.junit.Test;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;

/**
  *   验证码测试工程
 * @author 34675
 * 2020/12/2
 */
public class veriTest {
	
	@Test
	public void verify() {
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(106, 34);
		lineCaptcha.write("d:/line.png");
		Console.log(lineCaptcha.getCode());
	}
	
	
}
	