package old;

/**
 * 功能说明：计算出租车价格
 * 基础计算方法：
 * 1) 在5:00---23:00期间，起步费14元(包括一元的燃油费)，可运营3公里，超过3公里后每公里2.40元，
 * 总里程超过10公里后超过部分按每公里3.60元计算。
 * 2) 在23:00---到次日5:00期间，起步费18元(包括一元的燃油费)，可运营3公里，超过3公里后每公里3.10元 ，
 * 总里程超过10公里后超过部分按每公里4.70元计算。
 * <p/>
 * 其他计算方法：
 * 1) 上海出租车平时每等候1分钟按0.52元计算，凌晨时按0.62元计算.
 * 2) 郊区的话起步价便宜2元，其他一样。
 */

public class TaxiFeeCalculator {

	private int hour;
	private int miles;
	/**
	 * 为简便，都取int型
	 * @param hour 乘车时间
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
	以上内容固定不变，重构从以下部分开始。
	附相关英语：
	The initial charge is $2.50.
	Plus 50 cents per 1/5 mile or 50 cents per 60 seconds in slow traffic or when the vehicle is stopped.

	There is a 30-cent Improvement Surcharge.
	There is a daily 50-cent surcharge from 8pm to 6am.
	 */

	private float calculate(int hour, int miles) {
		return 1.1f;
	}
}
