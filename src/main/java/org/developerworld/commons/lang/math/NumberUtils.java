package org.developerworld.commons.lang.math;

/**
 * 数值工具类
 * 
 * @author Roy.Huang
 * @version 20100518
 * 
 */
public class NumberUtils extends org.apache.commons.lang.math.NumberUtils {

	/**
	 * 根据字符数组元素，返回int型数组
	 * 
	 * @param args
	 * @return
	 */
	public static int[] toIntArray(String args[]) {
		int[] rst = new int[args.length];
		for (int i = 0; i < rst.length; i++)
			rst[i] = Integer.parseInt(args[i]);
		return rst;
	}

	/**
	 * 根据字符数组元素，返回Integer型数组
	 * 
	 * @param args
	 * @return
	 */
	public static Integer[] toIntObjectArray(String args[]) {
		Integer[] rst = null;
		if (args != null) {
			rst = new Integer[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = new Integer(args[i]);
		}
		return rst;
	}

	/**
	 * 根据字符数组元素，返回byte型数组
	 * 
	 * @param args
	 * @return
	 */
	public static byte[] toByteArray(String args[]) {
		byte[] rst = null;
		if (args != null) {
			rst = new byte[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = Byte.parseByte(args[i]);
		}
		return rst;
	}

	/**
	 * 根据字符数组元素，返回Byte型数组
	 * 
	 * @param args
	 * @return
	 */
	public static Byte[] toByteObjectArray(String args[]) {
		Byte[] rst = null;
		if (args != null) {
			rst = new Byte[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = new Byte(args[i]);
		}
		return rst;
	}

	/**
	 * 根据字符数组元素，返回short型数组
	 * 
	 * @param args
	 * @return
	 */
	public static short[] toShortArray(String args[]) {
		short[] rst = null;
		if (args != null) {
			rst = new short[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = Short.parseShort(args[i]);
		}
		return rst;
	}

	/**
	 * 根据字符数组元素，返回Short型数组
	 * 
	 * @param args
	 * @return
	 */
	public static Short[] toShortObjectArray(String args[]) {
		Short[] rst = null;
		if (args != null) {
			rst = new Short[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = new Short(args[i]);
		}
		return rst;
	}

	/**
	 * 根据字符数组元素，返回long型数组
	 * 
	 * @param args
	 * @return
	 */
	public static long[] toLongArray(String args[]) {
		long[] rst = null;
		if (args != null) {
			rst = new long[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = Long.parseLong(args[i]);
		}
		return rst;
	}

	/**
	 * 根据字符数组元素，返回Long型数组
	 * 
	 * @param args
	 * @return
	 */
	public static Long[] toLongObjectArray(String args[]) {
		Long[] rst = null;
		if (args != null) {
			rst = new Long[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = new Long(args[i]);
		}
		return rst;
	}

	/**
	 * 根据字符数组元素，返回float型数组
	 * 
	 * @param args
	 * @return
	 */
	public static float[] toFloatArray(String args[]) {
		float[] rst = null;
		if (args != null) {
			rst = new float[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = Float.parseFloat(args[i]);
		}
		return rst;
	}

	/**
	 * 根据字符数组元素，返回Float型数组
	 * 
	 * @param args
	 * @return
	 */
	public static Float[] toFloatObjectArray(String args[]) {
		Float[] rst = null;
		if (args != null) {
			rst = new Float[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = new Float(args[i]);
		}
		return rst;
	}

	/**
	 * 根据字符数组元素，返回double型数组
	 * 
	 * @param args
	 * @return
	 */
	public static double[] toDoubleArray(String args[]) {
		double[] rst = null;
		if (args != null) {
			rst = new double[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = Double.parseDouble(args[i]);
		}
		return rst;
	}

	/**
	 * 根据字符数组元素，返回Double型数组
	 * 
	 * @param args
	 * @return
	 */
	public static Double[] toDoubleObjectArray(String args[]) {
		Double[] rst = null;
		if (args != null) {
			rst = new Double[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = new Double(args[i]);
		}
		return rst;
	}

	/**
	 * 根据字符数组元素，返回boolean型数组
	 * 
	 * @param args
	 * @return
	 */
	public static boolean[] toBooleanArray(String args[]) {
		boolean[] rst = null;
		if (args != null) {
			rst = new boolean[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = Boolean.parseBoolean(args[i]);
		}
		return rst;
	}

	/**
	 * 根据字符数组元素，返回Boolean型数组
	 * 
	 * @param args
	 * @return
	 */
	public static Boolean[] toBooleanObjectArray(String args[]) {
		Boolean[] rst = null;
		if (args != null) {
			rst = new Boolean[args.length];
			for (int i = 0; i < rst.length; i++)
				rst[i] = new Boolean(args[i]);
		}
		return rst;
	}
}
