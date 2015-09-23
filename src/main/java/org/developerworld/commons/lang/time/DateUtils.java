package org.developerworld.commons.lang.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author Roy Huang
 * @version 20120309
 * 
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static SimpleDateFormat datetimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat(
			"HH:mm:ss");

	/**
	 * 获取指定日期日期部分
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateBeginDateTime(Date date) {
		Date rst = null;
		try {
			if (date == null)
				return date;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			rst = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rst;
	}

	/**
	 * 获取指定日期最后时刻
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateEndDateTime(Date date) {
		if (date == null)
			return date;
		Date rst = getDateBeginDateTime(date);
		rst.setTime(rst.getTime() + (24 * 60 * 60 * 1000 - 1));
		return rst;
	}

	/**
	 * 获取指定日期周开始日
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getWeekBeginDateTime(Date date) {
		if (date == null)
			return date;
		Date rst = getDateBeginDateTime(date);
		rst.setTime(rst.getTime() - rst.getDay() * (24 * 60 * 60 * 1000));
		return rst;
	}

	/**
	 * 获取指定日期周结束日
	 * 
	 * @param date
	 * @return
	 */
	public static Date getWeekEndDateTime(Date date) {
		if (date == null)
			return date;
		Date rst = getWeekBeginDateTime(date);
		rst.setTime(rst.getTime() + (7 * 24 * 60 * 60 * 1000 - 1));
		return rst;
	}

	/**
	 * 获取指定日期月开始日
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthBeginDateTime(Date date) {
		Date rst = getDateBeginDateTime(date);
		rst.setDate(1);
		return rst;
	}

	/**
	 * 获取指定日期月结束日
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthEndDateTime(Date date) {
		Date rst = getMonthBeginDateTime(date);
		rst.setMonth(rst.getMonth() + 1);
		rst.setTime(rst.getTime() - 1);
		return rst;
	}

	/**
	 * 获取指定日期年开始日
	 * 
	 * @param date
	 * @return
	 */
	public static Date getYearBeginDateTime(Date date) {
		Date rst = getDateBeginDateTime(date);
		rst.setMonth(0);
		rst.setDate(1);
		return rst;
	}

	/**
	 * 获取指定日期年结束日
	 * 
	 * @param date
	 * @return
	 */
	public static Date getYearEndDateTime(Date date) {
		Date rst = getYearBeginDateTime(date);
		rst.setYear(rst.getYear() + 1);
		rst.setTime(rst.getTime() - 1);
		return rst;
	}

	public static String formatDate(Date date) {
		return dateFormat.format(date);
	}

	public static String formatTime(Date date) {
		return timeFormat.format(date);
	}

	public static String formatDatetime(Date date) {
		return datetimeFormat.format(date);
	}
}
