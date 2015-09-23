package org.developerworld.commons.lang;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 
 * @author Roy.Huang
 * @version 20110111
 * 
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

	public final static int UNICODE_Number_SIZE = 4;

	private final static char HEX_NUMBER[] = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	private final static String HEX_NUMBER_STR = "0123456789ABCDEF";

	/**
	 * 将BYTE转换为带部位的十六进制数字
	 * 
	 * @param b
	 * @return
	 */
	public static String byteToHex(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHex(b[i]));
		return resultSb.toString();
	}

	/**
	 * 将BYTE转换为带部位的十六进制数字
	 * 
	 * @param b
	 * @return
	 */
	public static String byteToHex(byte b) {
		return HEX_NUMBER[(b & 0xf0) >> 4] + "" + HEX_NUMBER[b & 0xf];
	}

	/**
	 * 十六进制字符串转换为byte
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] hexToByte(String hexStr) {
		return hexToByte(hexStr.toCharArray());
	}

	/**
	 * 十六进制字符集转换为byte
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] hexToByte(char hexStr[]) {
		byte[] rst = new byte[hexStr.length / 2];
		for (int i = 0; i < rst.length; i++) {
			int temp = HEX_NUMBER_STR.indexOf(hexStr[2 * i]) * 16;
			temp += HEX_NUMBER_STR.indexOf(hexStr[2 * i + 1]);
			rst[i] = (byte) (temp & 0xff);
		}
		return rst;
	}

	/**
	 * 获取字符的位长度
	 * 
	 * @param value
	 * @return
	 */
	public static int getByteLength(String value) {
		return value == null ? 0 : value.getBytes().length;
	}

	/**
	 * 获取指定长度的字符串
	 * 
	 * @param target
	 * @param maxLength
	 * @param other
	 * @param charset
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String subMaxString(String target, int maxLength) {
		if (target == null)
			return target;
		else if (maxLength <= 0)
			return "";
		StringBuffer rst = new StringBuffer();
		int index = 0;
		int length = 0;
		while (index < target.length()) {
			length += getByteLength(target.substring(index, index + 1));
			if (length > maxLength)
				break;
			rst.append(target.substring(index, index + 1));
			++index;
		}
		return rst.toString();
	}

	/**
	 * 获取指定长度的字符串，过长的自动补位
	 * 
	 * @param target
	 * @param maxLength
	 * @param other
	 * @return
	 */
	public static String subMaxString(String target, int maxLength, String other) {
		if (target == null)
			return null;
		int len = getByteLength(target);
		if (len > maxLength) {
			maxLength -= getByteLength(other);
			if (maxLength <= 0)
				return other;
			return subMaxString(target, maxLength) + other;
		}
		return target;
	}

	/**
	 * 将字符串转为Unicode编码
	 * 
	 * @param temp
	 * @return
	 */
	public static String toUnicode(String temp) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < temp.length(); i++) {
			int c = (char) temp.charAt(i);
			StringBuffer sbtemp = new StringBuffer(Integer.toHexString(c));
			while (sbtemp.length() < UNICODE_Number_SIZE)
				sbtemp.insert(0, "0");
			sb.append("\\u" + sbtemp);
		}
		return sb.toString();
	}

	/**
	 * 将int数组转为字符数组
	 * 
	 * @param args
	 * @return
	 */
	public static String[] toStringArray(int args[]) {
		String rst[] = new String[args.length];
		for (int i = 0; i < rst.length; i++)
			rst[i] = args[i] + "";
		return rst;
	}

	/**
	 * 将对象数组转为字符数组
	 * 
	 * @param args
	 * @return
	 */
	public static String[] toStringArray(Object args[]) {
		String rst[] = new String[args.length];
		for (int i = 0; i < rst.length; i++)
			rst[i] = args[i].toString();
		return rst;
	}

	/**
	 * 通配符匹配
	 * 
	 * @param expression
	 *            表达式
	 * @param str
	 *            检查对象
	 * @return
	 */
	public static boolean wildcardCapture(String expression, String str) {
		boolean rst = false;
		expression = expression.replace('.', '#');
		expression = expression.replaceAll("#", "\\\\.");
		expression = expression.replace('*', '#');
		expression = expression.replaceAll("#", ".*");
		expression = expression.replace('?', '#');
		expression = expression.replaceAll("#", ".?");
		expression = "^" + expression + "$";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(str);
		rst = matcher.matches();
		return rst;
	}

	/**
	 * 编码转换
	 * 
	 * @param str
	 *            源字符串
	 * @param origCharset
	 *            源编码
	 * @param destCharset
	 *            目标编码
	 * @return
	 */
	public static String transcode(String str, String origCharset,
			String destCharset) throws UnsupportedEncodingException {
		String rst = str;
		if (isNotBlank(rst)
				&& (isNotBlank(origCharset) || isNotBlank(destCharset))) {
			byte[] bytes = null;
			if (isNotBlank(origCharset))
				bytes = rst.getBytes(origCharset);
			else
				bytes = rst.getBytes();
			if (isNotBlank(destCharset))
				rst = new String(bytes, destCharset);
			else
				rst = new String(bytes);
		}
		return rst;
	}

	/**
	 * 驼峰转下划线
	 * 
	 * @param str

	 * @return
	 */
	public static String camelToUnderling(String str) {
		if (StringUtils.isBlank(str))
			return str;
		StringBuilder rst = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			boolean nextUpperCase = true;
			if (i < (str.length() - 1))
				nextUpperCase = Character.isUpperCase(str.charAt(i + 1));
			if ((i >= 0) && Character.isUpperCase(c)) {
				if ((!upperCase || !nextUpperCase) && i > 0)
					rst.append("_");
				upperCase = true;
			} else
				upperCase = false;
			rst.append(Character.toLowerCase(c));
		}
		return rst.toString();
	}

	/**
	 * 下划线转驼峰
	 * 
	 * @param str

	 * @return
	 */
	public static String underlingToCamel(String str) {
		if (StringUtils.isBlank(str))
			return str;
		str = str.toLowerCase();
		StringBuilder rst = new StringBuilder(str.length());
		boolean upperCase = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '_')
				upperCase = true;
			else if (upperCase) {
				rst.append(Character.toUpperCase(c));
				upperCase = false;
			} else
				rst.append(c);
		}
		return rst.toString();
	}

	public final static void main(String args[])
			throws UnsupportedEncodingException {
		// String url = "http://localhost/pwa/d.jsp";
		// String exp = "*/pwa/*";
		// System.out.println(wildcardCapture(exp, url));
		// String[] charsets = new String[] { null, "GBK", "GB2312", "UTF-8",
		// "ISO-8859-1" };
		// for (String charetA : charsets) {
		// for (String charetB : charsets) {
		// System.out.println(charetA + "->" + charetB);
		// System.out.println(transcode("你好", charetA, charetB));
		// }
		// }

//		String expression = "a:b:1:2";
//		String text = "a:b:1:?";
//		System.out.println(wildcardCapture(expression, text));
//		System.out.println(wildcardCapture(text, expression));
		
		System.out.println(underlingToCamel("_asd+f_safd_sad"));
		System.out.println(camelToUnderling("sdfAdsfAsfd_vasdfFAS"));
	}

}
