package refactor;

/**
 * 功能说明：计算出租车价格
 * <p/>
 * 初始需求：
 * 1) 在5:00---23:00期间，起步费14元(包括一元的燃油费)，可运营3公里，
 * 超过3公里后每公里2.40元，
 * 总里程超过10公里后超过部分按每公里3.60元计算。
 * 2) 在23:00---到次日5:00期间，起步费18元(包括一元的燃油费)，可运营3公里，
 * 超过3公里后每公里3.10元 ，
 * 总里程超过10公里后超过部分按每公里4.70元计算。
 * <p/>
 * 后续需求：
 * 1) 上海出租车平时每等候1分钟按0.52元计算，凌晨时按0.62元计算.
 * 2) 郊区的话起步价便宜2元，其他一样。
 * <p/>
 * 继续后续需求：
 * 1) 推出会员卡功能：是会员则打9折。
 * 2) 一个月累计乘坐100公里，则打9.5折。
 */

public class TaxiFeeCalculator {

    private int hour;

    private int miles;

    /**
     * 为简便，都取int型
     *
     * @param hour  乘车时间
     * @param miles 乘车里程数
     */
    public TaxiFeeCalculator(int hour, int miles) {
        this.hour = hour;
        this.miles = miles;
    }

    public float getPrice() {
        return calculate(hour, miles);
    }

    public static void main(String[] args) {
        int hour = 12;
        int miles = 5;
        float price = new TaxiFeeCalculator(hour, miles).getPrice();

        System.out.println(String.format("于%d时乘坐%d公里出租车，花费是：%f", hour, miles, price));
    }

	/*
    ================================================================
	场景：该代码已实现初始需求，现又提出后续需求，请重构以添加新功能。
	可新增构造方法的参数，或其他set函数。

	以上内容固定不变，重构从以下部分开始。
	附相关英语：
	The initial charge is $2.50.
	Plus 50 cents per 1/5 mile or 50 cents per 60 seconds in slow traffic or when the vehicle is stopped.
	There is a 30-cent Improvement Surcharge.
	There is a daily 50-cent surcharge from 8pm to 6am.
	 */

    private float calculate(int hour, int miles) {
        if (isValidated(hour, miles)) {
            if (isMorning(hour)) {
                return new MorningFee(miles).getPrice();
            } else {
                return new EveningFee(miles).getPrice();
            }
        } else {
            throw new RuntimeException("Wrong Parameter");
        }

    }

    private boolean isValidated(int hour, int miles) {
        return hour > 0 && miles > 0;
    }

    private boolean isMorning(int hour) {
        return hour >= 5 && hour < 23;
    }


    class Fee {
        Fee(int miles) {
            this.miles = miles;
        }

        int miles;

        float initCharge;
        int initMile;
        float secondPrice;
        int secondMile;
        float thirdPrice;

        float getPrice() {
            if (miles <= initMile) {
                return initCharge;
            }

            if (miles > initMile && miles <= secondMile) {
                float secondCharge = (miles - initMile) * secondPrice;
                return initCharge + secondCharge;
            }

            if (miles > secondMile) {
                float secondCharge = (secondMile - initMile) * secondPrice;
                float thirdCharge = (miles - secondMile) * thirdPrice;
                return initCharge + secondCharge + thirdCharge;
            }
            throw new RuntimeException("Wrong Parameter");
        }

    }

    class MorningFee extends Fee {
        MorningFee(int miles) {
            super(miles);
            this.initCharge = 14;
            this.initMile = 3;
            this.secondPrice = 2.40f;
            this.secondMile = 10;
            this.thirdPrice = 3.60f;
        }
    }

    class EveningFee extends Fee {
        EveningFee(int miles) {
            super(miles);
            this.initCharge = 18;
            this.initMile = 3;
            this.secondPrice = 3.10f;
            this.secondMile = 10;
            this.thirdPrice = 4.70f;
        }
    }
}
