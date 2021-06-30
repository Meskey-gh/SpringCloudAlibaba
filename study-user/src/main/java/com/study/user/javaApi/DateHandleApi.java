package com.study.user.javaApi;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * 此类Java中时间类型的处理方式
 * @author 刘祖鸿
 */
@Slf4j
public class DateHandleApi {

    public static void main(String[] args) throws ParseException {

        java8Date();

        simpleDateFormat();

    }

    private static void java8Date() {
        /**
         * java8提供  获取年月日 已经格式化  example 2021-06-22
         */
        LocalDate today = LocalDate.now();
        // newDay: 2021-06-22  today.compareTo(newDay)==0
        LocalDate newDay = LocalDate.of(2021,6,22);
        // year:2021  month:6  day:22  month1: JUNE
        int year = today.getYear();     int month = today.getMonthValue();
        int day = today.getDayOfMonth();    Month month1 = today.getMonth();

        // 在当前时间上增加一年一周三日
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS)
                .plus(1,ChronoUnit.WEEKS).plus(3,ChronoUnit.DAYS);

        // 在当前时间上减去一年一周三日
        LocalDate lastYear = today.minus(1, ChronoUnit.YEARS)
                .minus(1,ChronoUnit.WEEKS).minus(3,ChronoUnit.DAYS);

        //时间比较  以下两个皆为true
        boolean type1 = nextYear.isAfter(lastYear);
        boolean type2 = lastYear.isBefore(nextYear);

        // 将字符串格式化成LocalDate类型  formatDate1: 2021-06-22 formatDate2:2021-06-22T10:10:10
        String dateS1 = "2021-06-22";
        LocalDate formatDate1 = LocalDate.parse(dateS1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String dateS2 = "2021-06-22 10:10:10";
        LocalDateTime formatDate2 = LocalDateTime.parse(dateS2,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        /**
         * 获取当前时间戳  2021-06-22T22:51:55.036
         */
        LocalDateTime arrivalDate  = LocalDateTime.now();
        // 将时间格式成当前年-月-日 时-分-秒 字符串类型  landing: 2021-06-22 22:59:35
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String landing = arrivalDate.format(dtf);

        /**
         * java8 获取当前时间 时分秒纳秒 22:18:17.094 hour, minutes, seconds, nano seconds
         */
        LocalTime time = LocalTime.now();
        // for example .....
        int hour = time.getHour();
        // 在现有基础上增加2小时5分钟  for example ...
        LocalTime newTime = time.plusHours(2).plusMinutes(5);
        // 在现有基础上减少2小时5分钟  for example ...
        LocalTime newTime2 = time.minusHours(2).minusMinutes(5);

    }

    private static void simpleDateFormat() throws ParseException {
        // String 转成 Date类型  date: Tue Jun 22 23:07:17 CST 2021
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "2021-06-22 23:07:17";
        Date date = sdf.parse(time);

        //Date转化成 String  time1:2021-06-22 23:08:45
        Date date1 = new Date();
        String time1 = sdf.format(date1);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        // Calendar时间加减方法 分别代表 增加一年，减少一个月...   for example ...
        //calendar.getTime() 得到Date类型时间   sdf.format(calendar.getTime()) 转化成字符串
        calendar.add(Calendar.YEAR,1);
        calendar.add(Calendar.MONTH,-1);
        calendar.add(Calendar.DATE,5);
        calendar.add(Calendar.HOUR,1);



    }

}