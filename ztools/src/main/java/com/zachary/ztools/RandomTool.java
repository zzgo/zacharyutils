package com.zachary.ztools;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Title:
 * @Author:Zachary
 * @Desc:随机数生成类
 * @Date:2019/2/13
 **/
public class RandomTool {
    private static final Random random = new Random();

    /**
     * 随机数生成日期
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 返回随机日期
     */
    public static Date randomDate(String start, String end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startTime = sdf.parse(start);
            Date endTime = sdf.parse(end);
            long date = random(startTime.getTime(), endTime.getTime());
            return new Date(date);
        } catch (ParseException e) {

        }
        return null;
    }

    /**
     * 随机数
     *
     * @param s 开始数
     * @param e 结束数
     * @return 返回数
     */
    private static long random(long s, long e) {
        long m = s + (long) (Math.random() * (e - s));
        if (m == s || m == e) {
            return random(s, e);
        }
        return m;
    }

    /**
     * BigDecimal随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return 返回一个数
     */
    public static BigDecimal randomBigDecimal(float min, float max) {
        BigDecimal db = new BigDecimal(Math.random() * (max - min) + min);
        return db.setScale(2, BigDecimal.ROUND_HALF_UP);// 保留30位小数并四舍五入
    }

    /**
     * 返回一个Random单例
     */
    public static Random randomInstance() {
        return random;
    }

    /**
     * 返回一个Random实例
     *
     * @param isNew 是不是一个新的实例
     * @return
     */
    public static Random randomInstance(boolean isNew) {
        if (isNew) return new Random();
        return randomInstance();
    }

}
