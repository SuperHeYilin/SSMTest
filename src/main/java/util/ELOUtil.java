package util;

import java.math.BigDecimal;

/**
 * 等级分工具类
 */
public class ELOUtil {
    private static final int WIN = 1;
    public static final double SAME = 0.5;
    public static final int LOST = 0;
    public static final int K = 32;

    public static void main(String[] args) {
        countRange(1500, 1000, 0);
    }

    /**
     * a对比的胜率期望值
     * @param a 自己
     * @param b  对手
     * @return
     */
    public static double winHope(int a, int b) {
//        BigDecimal big = new BigDecimal(Math.pow(10, (b - a)/400D));
//        return new BigDecimal(1).divide(new BigDecimal(1).add(big), 20, BigDecimal.ROUND_HALF_UP);
        double hope = 1 / (1 + Math.pow(10, (b - a)/400D));
        System.out.println(Math.pow(10, (b - a)/400D));
        System.out.println(a + " 对 " + b + " 胜率期望：" + hope);
        return hope;
    }

    /**
     * 改变等级分
     * @param range 当前的等级分 默认1500
     * @param trueScore 比赛中的真实得分
     * @param hopeScore  期望值
     * @return  调整后的等级分
     */
    public static double changeRange(int range, double trueScore, double hopeScore) {
//        BigDecimal b1 = new BigDecimal(trueScore);
//        int a1 = new BigDecimal(Math.round(hopeScore)).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
//        return new BigDecimal(range).add(new BigDecimal(K).multiply(b1.subtract(hopeScore)));
        double ran = range + K * (trueScore - hopeScore);
        return ran;
    }

    /**
     * 根据传入两个对手的等级分 和比赛结果 返回改变后的数据
     * @param a
     * @param b
     * @param trueScore  比赛结果是针对前者  后者为相反
     * @return
     */
    public static int[] countRange(int a, int b, double trueScore) {

        double trueBScore = 0D;

        if (trueScore == 0.5) {
            trueBScore = 0.5D;
        }
        if (trueScore == 0) {
            trueBScore = 1.0D;
        }

        int[] temp = {0, 0};

        // a 改变后的等级分
//        BigDecimal aTempRange = changeRange(a, trueScore, winHope(a, b));
        double aTempRange = changeRange(a, trueScore, winHope(a, b));
        // b 改变后的等级分   注意结果和a相反
//        BigDecimal bTempRange = changeRange(b, trueBScore, winHope(b, a));
        double bTempRange = changeRange(b, trueBScore, winHope(b, a));

        int aRange = new BigDecimal(Double.toString(aTempRange)).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();

        int bRange = new BigDecimal(Double.toString(bTempRange)).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();

        temp[0] = aRange;
        temp[1] = bRange;
        System.out.println(aRange + " : " + bRange);
        return temp;
    }


}
