package refactor;

/**
 * ����˵����������⳵�۸�
 * <p/>
 * ��ʼ����
 * 1) ��5:00---23:00�ڼ䣬�𲽷�14Ԫ(����һԪ��ȼ�ͷ�)������Ӫ3���
 * ����3�����ÿ����2.40Ԫ��
 * ����̳���10����󳬹����ְ�ÿ����3.60Ԫ���㡣
 * 2) ��23:00---������5:00�ڼ䣬�𲽷�18Ԫ(����һԪ��ȼ�ͷ�)������Ӫ3���
 * ����3�����ÿ����3.10Ԫ ��
 * ����̳���10����󳬹����ְ�ÿ����4.70Ԫ���㡣
 * <p/>
 * ��������
 * 1) �Ϻ����⳵ƽʱÿ�Ⱥ�1���Ӱ�0.52Ԫ���㣬�賿ʱ��0.62Ԫ����.
 * 2) �����Ļ��𲽼۱���2Ԫ������һ����
 * <p/>
 * ������������
 * 1) �Ƴ���Ա�����ܣ��ǻ�Ա���9�ۡ�
 * 2) һ�����ۼƳ���100������9.5�ۡ�
 */

public class TaxiFeeCalculator {

    private int hour;

    private int miles;

    /**
     * Ϊ��㣬��ȡint��
     *
     * @param hour  �˳�ʱ��
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
	�������ô�����ʵ�ֳ�ʼ����������������������ع�������¹��ܡ�
	���������췽���Ĳ�����������set������

	�������ݹ̶����䣬�ع������²��ֿ�ʼ��
	�����Ӣ�
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
