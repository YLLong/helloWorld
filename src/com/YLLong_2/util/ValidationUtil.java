package com.YLLong_2.util;

import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by YLL on 2015/10/31.
 */
public class ValidationUtil {
    //校对输入考试时间 如：2015-10-31
    public static boolean validationTestTimeFormat(String testTime) {
        String regx = "([123]\\d{3}-(([0][1-9])|([1][0-2]))-(([0][1-9])|([12]//d)|([3][01])))";
        Pattern pattern = Pattern.compile(regx);//解析regx正则表达式
        Matcher matcher = pattern.matcher(testTime);//匹配正则表达式
        if(!matcher.matches()) {
            return false;
        }else {
            String[] time = testTime.split("-");
            Integer year = Integer.parseInt(time[0]);
            Integer month = Integer.parseInt(time[1]);
            Integer day = Integer.parseInt(time[2]);
            GregorianCalendar calendar = new GregorianCalendar();
            if(calendar.isLeapYear(year) && (month==2) && (day > 29)) {
                return false;
            }else if(!calendar.isLeapYear(year) && (month==2) && (day > 28)) {
                return false;
            }else {
                switch (month) {
                    case 4:;
                    case 6:;
                    case 9:;
                    case 11:
                        if(day >30) {
                            return false;
                        }else {
                            return true;
                        }
                    default:
                        return true;
                }
            }
        }
    }
    //校对学生班级（第一位数0为初中，1为高中；第二位数是年级1,2,3；第三位是班级） 如：0123 初中一年级23班
    public static boolean validationStuClassFormat(String stuClass) {
        String regx = "[01][123](([0][1-9])|([12][0-5]))";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(stuClass);
        if(!matcher.matches()) {
            return false;
        }else {
            return true;
        }
    }
    //校对学生成绩分数（0-100） 如：99
    public static boolean validationScoreFormat(String score) {
        String regx = "(\\d{2})|([1][0][0])";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(score);
        if(!matcher.matches()) {
            return false;
        }else {
            return true;
        }
    }
}
