package leetcode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) throws Exception {
        String rowkey = "3565e0cc1ff99214";
        Test test = new Test();
        long ms = test.getMillsecondsfromRowKey(rowkey);
        Date date = new Date(ms);

        Calendar calendar = Calendar.getInstance();
        //calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);

        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH");
        String f_hour = df.format(new Date(ms));
        String yearBegin = f_hour.substring(0, 4);
        calendar.setTime(df.parse(yearBegin + "010100"));
        long delta = ms - calendar.getTimeInMillis();
        System.out.println((delta / (24 * 3600 * 1000)) / 7 + 1);
        //System.out.println(yearBegin);
        System.out.println(f_hour);


    }

    public long getMillsecondsfromRowKey(String rowKey) {
        String seconds = rowKey.substring(3, 11);
        String millseconds = rowKey.substring(11, 14);
        long seconds_long;
        int millseconds_int;
        try {
            seconds_long = Long.parseLong(seconds, 16);
        } catch (NumberFormatException e) {
            return -1;
        }
        try {
            millseconds_int = Integer.parseInt(millseconds);
        } catch (NumberFormatException e) {
            return -1;
        }
        return (seconds_long * 1000 + millseconds_int);
    }

}

