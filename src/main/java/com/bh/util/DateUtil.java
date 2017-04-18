package com.bh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

public class DateUtil {

	private static DateUtil classInstance = new DateUtil();

	public static final int DATE_DAYS = 0;

	public static final int DATE_HOURS = 1;

	public static final int DATE_MINUTES = 2;

	public static final int DATE_SECONDS = 3;

	public static DateUtil getInstance() {
		return classInstance;
	}

	
	
	public static String formatDate(Date date, String pattern) {
		if (date == null) {
			date = new Date(System.currentTimeMillis());
		}

		if (pattern == null) {
			pattern = "yyyy-MM-dd HH:mm";
		}
		return DateFormatUtils.format(date, pattern);
	}

	public static String defaultFormat(Date date) {
		return formatDate(date, null);
	}

	public static String defaultFormatYMD(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}

	public static Date parseDateFormat() {
		SimpleDateFormat fo = new SimpleDateFormat();
		Date date = new java.util.Date(System.currentTimeMillis());
		fo.applyPattern("yyyy-MM-dd");

		try {
			date = fo.parse(DateFormatUtils.format(date, "yyyy-MM-dd"));
		} catch (Exception e) {
		}

		return date;
	}

	public static Date parseDateFormat(String dateString, String pattern) {
		SimpleDateFormat fo = new SimpleDateFormat();
		fo.applyPattern(pattern);

		try {
			return fo.parse(dateString);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据类型返回日期格式
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate2String(Date date, String pattern) {
		if (pattern == null) {
			pattern = "yyyy-MM-dd HH:mm";
		}
		return DateFormatUtils.format(date, pattern);
	}

	public static Date string2Date(String str) {
		if (StringUtils.isEmpty(str))
			return new Date();
		return java.sql.Date.valueOf(str);
	}

	/**
	 * 字符串格式时间转换到对象时间
	 * 
	 * @param str
	 * @return
	 */
	public static Date string2DateTime(String str) {
		if (StringUtils.isEmpty(str))
			return new Date();
		SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		try {
			date = fo.parse(str);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 字符串格式时间转换到对象时间,时分秒
	 * 
	 * @param str
	 * @return
	 */
	public static Date stringDateTime(String str) {
		if (StringUtils.isEmpty(str))
			return new Date();
		SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = fo.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 字符串格式时间转换到对象时间
	 * 
	 * @param str
	 * @return
	 */
	public static Date stringDate(String str) {
		if (StringUtils.isEmpty(str))
			return new Date();
		SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = fo.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 返回星期几
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekDayString(Date date) {
		String weekString = "";
		final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
				"星期六" };
		Calendar calendar = Calendar.getInstance();
		if (date == null)
			date = new Date();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		weekString = dayNames[dayOfWeek - 1];
		return weekString;

	}

	public static boolean between(Date srcDate, Date startDate, Date endDate) {
		if (startDate.after(srcDate))
			return false;
		if (endDate.before(srcDate))
			return false;
		return true;
	}

	/**
	 * 返回两时间比较
	 * 
	 * @param startDate
	 * @param endDate
	 * @return true:开始时间小于结束时间 false:开始时间大于结束时间
	 */
	public static boolean between(Date startDate, Date endDate) {
		if (startDate.compareTo(endDate) <= 0)
			return true;
		return false;
	}

	/**
	 * 返回createDate+2天是否在当天之前
	 * 
	 * @param createDate
	 *            创建时间
	 * @return true:当前时间小于创建时间 false:当前时间大于创建时间
	 */
	public static boolean isBeforeNow(Date createDate) {
		return between(new Date(), addDays(createDate, 2));
	}

	/**
	 * 获得剩余时间
	 * 
	 * @param overTime
	 *            过期时间
	 * @return 剩余时间
	 */
	public static String marginTimeFormat(Date overTime) {
		String marginTimeFormat = "";
		// 过期日期
		Calendar overDate = Calendar.getInstance();
		overDate.setTime(overTime);
		// 现在的日期
		Calendar nowDate = Calendar.getInstance();
		// 到现在一共的剩余多少秒
		long seconds = (overDate.getTime().getTime() - nowDate.getTime()
				.getTime()) / 1000;
		if (seconds <= 0)
			return "过期";
		// 1(day)*24(hour)*60(minite)*60(seconds)
		// 天
		long dayMargin = seconds / 86400;
		// 小时
		seconds = seconds - (dayMargin * 86400);
		long hourMargin = seconds / 3600;
		// 分钟
		seconds = seconds - (hourMargin * 3600);
		long minuteMargin = seconds / 60;
		// 秒
		seconds = seconds - (minuteMargin * 60);
		// long secondMargin = seconds;

		// 双位显示,如: 01小时02分01秒
		// hstr = String.valueOf(hourMargin);
		// mstr = String.valueOf(minuteMargin);
		// sstr = String.valueOf(secondMargin);
		// hstr = String.valueOf(hourMargin).length() < 2 ? ("0" + hstr) : hstr;
		// mstr = String.valueOf(minuteMargin).length() < 2 ? ("0" + mstr) :
		// mstr;
		// sstr = String.valueOf(secondMargin).length() < 2 ? ("0" + sstr) :
		// sstr;

		if (dayMargin > 0) {
			marginTimeFormat = dayMargin + "天";
			return marginTimeFormat;
		} else if (hourMargin > 0) {
			marginTimeFormat = hourMargin + "小时";
			return marginTimeFormat;
		} else if (minuteMargin > 0) {
			marginTimeFormat = minuteMargin + "分钟";
			return marginTimeFormat;
		} else {
			marginTimeFormat = 1 + "分钟";
			return marginTimeFormat;
		}
	}

	/**
	 * 获得剩余时间
	 * 
	 * @param overTime
	 *            过期时间
	 * @return 剩余时间
	 */
	public static String marginTimeFormat(Date overTime, int pattern) {
		StringBuilder result = new StringBuilder();
		// 过期日期
		Calendar overDate = Calendar.getInstance();
		overDate.setTime(overTime);
		// 现在的日期
		Calendar nowDate = Calendar.getInstance();
		// 到现在一共的剩余多少秒
		long seconds = (overDate.getTime().getTime() - nowDate.getTime()
				.getTime()) / 1000;

		// 天
		long dayMargin = seconds / 86400;
		// 小时
		seconds = seconds - (dayMargin * 86400);
		long hourMargin = seconds / 3600;
		// 分钟
		seconds = seconds - (hourMargin * 3600);
		long minuteMargin = seconds / 60;
		// 秒
		seconds = seconds - (minuteMargin * 60);
		long secondMargin = seconds;
		switch (pattern) {
		case DATE_SECONDS:
			result.append(concat2(dayMargin, "天"))
					.append(concat2(hourMargin, "小时"))
					.append(concat2(minuteMargin, "分钟"))
					.append(concat2(secondMargin, "秒"));
			break;
		case DATE_MINUTES:
			result.append(concat2(dayMargin, "天"))
					.append(concat2(hourMargin, "小时"))
					.append(concat2(minuteMargin, "分钟"));
			break;
		case DATE_HOURS:
			result.append(concat2(dayMargin, "天")).append(
					concat2(hourMargin, "小时"));
			break;
		case DATE_DAYS:
		default:
			result.append(concat2(dayMargin, "天"));
		}
		return result.toString();
	}

	/**
	 * 获取今天还剩下多少秒
	 * @return
	 */
	public static int marginSecond(){
		Calendar curDate = Calendar.getInstance();
		Calendar tommorowDate = new GregorianCalendar(curDate
				.get(Calendar.YEAR), curDate.get(Calendar.MONTH), curDate
				.get(Calendar.DATE) + 1, 0, 0, 0);
		return (int)(tommorowDate.getTimeInMillis() - curDate .getTimeInMillis()) / 1000;
	}
	public static void main(String[] args) {
		System.out.println(DateUtil.marginSecond());
	}
	/**
	 * 双位显示,如: 01小时
	 * 
	 * @param time
	 * @param pattern
	 * @return String
	 */
	private static String concat2(long time, String pattern) {
		String timeStr = String.valueOf(time);
		return timeStr.length() >= 2 ? (timeStr + pattern)
				: ("0" + timeStr + pattern);
	}

	/**
	 * 根据当前时间增加小时分
	 * 
	 * @param date
	 * @return
	 */
	public static Date addDateHM(Date date) {
		Calendar cal = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
		return calendar.getTime();
	}

	/**
	 * 增加修改小时 添加的时间为 h 分钟为当前时间
	 * 
	 * @param date
	 * @param h
	 * @return
	 */
	public static Date addDateHMMinus1(Date date, int h) {
		Calendar cal = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, h);
		calendar.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
		return calendar.getTime();
	}

	/**
	 * 增加修改小时
	 * 
	 * @param date
	 * @param h
	 * @return
	 */
	public static Date addDateHM(Date date, int h) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, h);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();
	}

	/**
	 * 增加天
	 * 
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date addDays(Date date, int i) {
		return org.apache.commons.lang.time.DateUtils.addDays(date, i);
	}

	/**
	 * 增加月
	 * 
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date addMonths(Date date, int i) {
		return org.apache.commons.lang.time.DateUtils.addMonths(date, i);
	}

	/**
	 * 增加年
	 * 
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date addYears(Date date, int i) {
		return org.apache.commons.lang.time.DateUtils.addYears(date, i);
	}

	/**
	 * 增加小时
	 * 
	 * @param date
	 * @param h
	 * @return
	 */
	public static Date addHours(Date date, int h) {
		return org.apache.commons.lang.time.DateUtils.addHours(date, h);
	}

	/**
	 * 由于用24小时 返回时间+1
	 * 
	 * @param date
	 * @return
	 */
	public static int getHoursAdd1(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY) + 1;
	}

	/**
	 * 返回小时
	 * 
	 * @param date
	 * @return
	 */
	public static int getHours(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 返回当天时间 只到天 2008-05-20 00:00
	 * 
	 * @return
	 */
	public static Date getNowDate() {
		return org.apache.commons.lang.time.DateUtils.truncate(new Date(),
				Calendar.DATE);
	}

	/**
	 * 返回date时间 只到天 2008-05-20 00:00
	 * 
	 * @return
	 */
	public static Date getNoHHMMDate(Date date) {
		return org.apache.commons.lang.time.DateUtils.truncate(date,
				Calendar.DATE);
	}

	/**
	 * 有效时间为某天的最后时刻
	 * 
	 * @param date
	 *            选择的时间
	 * @return Date
	 */
	public static Date getOverTime(Date date) {
		Date time = addDateHM(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();

	}

	/**
	 * 返回 分钟
	 * 
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 时间是否相等 true:相等 false:不等
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean equalsDate(Date startDate, Date endDate) {
		if (startDate.compareTo(endDate) == 0)
			return true;
		return false;
	}

	/**
	 * 是否周末
	 * 
	 * @param day
	 * @return
	 */
	public static boolean isWeekend(Date day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		int tmp = cal.get(Calendar.DAY_OF_WEEK);
		return (Calendar.SATURDAY == tmp || Calendar.SUNDAY == tmp) ? true
				: false;
	}

	/**
	 * 获取日期差
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int getSubDays(Date startTime, Date endTime) {
		int day = 0;
		day = (int) ((endTime.getTime() - startTime.getTime()) / 86400000); // 24
																			// *
																			// 60
																			// *
																			// 60
																			// *
																			// 1000
		return day;
	}
	
	/**
	 * 求时间差
	* @Title: subtractDate 
	* @Description: TODO
	* @param @param now
	* @param @param date
	* @param @return
	* @return String
	* @author:zyy
	* @date:2016年4月28日
	* @throws
	 */
	public static Map<String,Long> subtractDate(Date now,Date date){
		Map<String,Long> dateMap=new HashMap<String, Long>();
		  Calendar calendar=Calendar.getInstance();
		   calendar.add(Calendar.DATE, 1);
		   long l=now.getTime()-date.getTime();
		   long day=l/(24*60*60*1000);
		   long hour=(l/(60*60*1000)-day*24);
		   long min=((l/(60*1000))-day*24*60-hour*60);
		   long second=(l/1000-day*24*60*60-hour*60*60-min*60);
		   dateMap.put("day", day);
		   dateMap.put("hour",hour);
		   dateMap.put("minute", min);
		   dateMap.put("second", second);
		   return dateMap;
	}
	
	/**
	 * 判断时间onlineTime是否在过去days天以内
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static boolean isWithin(Date date, int days) {
		if (null == date) {
			return false;
		}
		return addDays(date, days).after(new Date());
	}
	/**
	 * 判断时间类型
	* @Title: isStringToDate 
	* @Description: TODO
	* @param @param dateString
	* @param @param pattern
	* @param @return
	* @return boolean
	* @author:zyy
	* @date:2016年5月16日
	* @throws
	 */
	public static boolean isStringToDate(String dateString, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(false);
		try {
			sdf.parse(dateString);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}


	public static String timeStamp2Date(String seconds, String format) {
		if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
			return "";
		}
		if (format == null || format.isEmpty())
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		return sdf.format(new Date(Long.valueOf(seconds + "000")));
	}
	


	/**
	 * 获取上月月份
	 * @param date
	 * @return
	 */
	public static Date getLastDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}
	
	public static Date getNextDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, +1);
		return cal.getTime();
	}
	/**
	 * 判读时间格式
	* @Title: isTimeLegal 
	* @Description: TODO
	* @param @param patternString
	* @param @return
	* @return boolean
	* @author:zyy
	* @date:2016年6月3日
	* @throws
	 */
	 public static boolean isTimeLegal(String patternString) {
         Pattern a=Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$"); 
         Matcher b=a.matcher(patternString); 
         if(b.matches()) {
               return true;
         } else {
               return false;
         }
    }
	 /** 
	     * @author LuoB. 
	     * @param oldTime 较小的时间 
	     * @param newTime 较大的时间 (如果为空   默认当前时间 ,表示和当前时间相比) 
	     * @return -1 ：同一天.    0：昨天 .   1 ：至少是前天. 
	     * @throws ParseException 转换异常 
	     */  
	    public static int isYeaterday(Date oldTime,Date newTime) throws ParseException{  
	        if(newTime==null){  
	            newTime=new Date();  
	        }  
	               //将下面的 理解成  yyyy-MM-dd 00：00：00 更好理解点  
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	        String todayStr = format.format(newTime);  
	        Date today = format.parse(todayStr);  
	        //昨天 86400000=24*60*60*1000 一天  
	        if((today.getTime()-oldTime.getTime())>0 && (today.getTime()-oldTime.getTime())<=86400000) {  
	            return 0;  
	        }  
	        else if((today.getTime()-oldTime.getTime())<=0){ //至少是今天  
	            return -1;  
	        }  
	        else{ //至少是前天  
	            return 1;  
	        } 
	    }
	 
}
