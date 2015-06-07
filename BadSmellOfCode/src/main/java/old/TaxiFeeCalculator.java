package old;

/**
 * ����˵����������⳵�۸�
 * �������㷽����
 * 1) ��5:00---23:00�ڼ䣬�𲽷�14Ԫ(����һԪ��ȼ�ͷ�)������Ӫ3�������3�����ÿ����2.40Ԫ��
 * ����̳���10����󳬹����ְ�ÿ����3.60Ԫ���㡣
 * 2) ��23:00---������5:00�ڼ䣬�𲽷�18Ԫ(����һԪ��ȼ�ͷ�)������Ӫ3�������3�����ÿ����3.10Ԫ ��
 * ����̳���10����󳬹����ְ�ÿ����4.70Ԫ���㡣
 * <p/>
 * �������㷽����
 * 1) �Ϻ����⳵ƽʱÿ�Ⱥ�1���Ӱ�0.52Ԫ���㣬�賿ʱ��0.62Ԫ����.
 * 2) �����Ļ��𲽼۱���2Ԫ������һ����
 */

public class TaxiFeeCalculator {

	private int hour;
	private int miles;
	/**
	 * Ϊ��㣬��ȡint��
	 * @param hour �˳�ʱ��
	 * @param miles �˳������
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

		System.out.println(String.format("��%dʱ����%d������⳵�������ǣ�%f", hour, miles, price));
	}

	/*
	================================================================
	�������ݹ̶����䣬�ع������²��ֿ�ʼ��
	�����Ӣ�
	The initial charge is $2.50.
	Plus 50 cents per 1/5 mile or 50 cents per 60 seconds in slow traffic or when the vehicle is stopped.

	There is a 30-cent Improvement Surcharge.
	There is a daily 50-cent surcharge from 8pm to 6am.
	 */

	private float calculate(int hour, int miles) {
		return 1.1f;
	}
}
