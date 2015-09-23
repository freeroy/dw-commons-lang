package org.developerworld.commons.lang;

import org.apache.commons.lang.math.RandomUtils;

/**
 * 随机字符类
 * 
 * @author Roy Huang
 * @version 20101208
 * 
 */
public class RandomStringUtils extends
		org.apache.commons.lang.RandomStringUtils {

	/**
	 * 从数组中，随机选择一个元素
	 * 
	 * @param source
	 * @return
	 */
	public final static String random(String[] source) {
		return random(1,source);
	}

	/**
	 * 从数组中，随机选择指定个数元素
	 * @param count
	 * @param source
	 * @return
	 */
	public final static String random(int count, String[] source) {
		StringBuffer rst = new StringBuffer();
		if (source != null && count > 0) {
			for (int i = 0; i < count; i++) {
				rst.append(source[RandomUtils.nextInt(source.length)]);
			}
		}
		return rst.toString();
	}

	public final static void main(String args[]) {
		System.out.println(RandomStringUtils.randomNumeric(10));
//		System.out.println(RandomStringUtils.randomAscii(123));
	}
}
