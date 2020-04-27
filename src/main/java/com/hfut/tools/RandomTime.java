package com.hfut.tools;

import java.sql.Timestamp;

/**
 * 随机时间生成器
 *
 * @author Chenzh
 */
public class RandomTime {

    public static void main(String[] args) {
        for (int i = 0; i < 300; i++) {
            System.out.println(randomDate("2013-02-25 00:00:00", "2018-03-01 00:00:00"));
        }
    }

    private static Timestamp randomDate(String startTime, String endTime) {
        try {
            long begin = Timestamp.valueOf(startTime).getTime();
            long end = Timestamp.valueOf(endTime).getTime();
            if (begin >= end) {
                return null;
            }
            return new Timestamp(random(begin, end));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Long random(long begin, long end) {
        long result = begin + (long) (Math.random() * (end - begin));
        if (result == begin || result == end) {
            return random(begin, end);
        }
        return result;
    }
}
