import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

public class Question {


    ImmutableList<Integer> list = ImmutableList.of(2, 65, 28, 892);

    @Before
    public void before() {

    }

    /**
     * ��һ��List<Integer> list,�����������"2,65,28,892"
     */
    @Test
    public void test1() {

    }

    /**
     * ��һ��List<Integer> list, 1)�����ֻ����ż������List
     * 2) ���д���10��ż������List
     */
    @Test
    public void test2() {

    }


    /**
     * ��ĳ������getPrice(int id), �ṩ������ID:����һ�������Class��
     * <p/>
     * ����һ��Map<ID, Class>��ID����list
     */
    @Test
    public void test3() {

    }


    /**
     * ����һ��<Key,Value>��Cache,ʵ��30����ǰ��Key�Զ�ʧЧ����ValueSet���Ա�GC����
     *
     */
    @Test
    public void test4() {

    }

    private Price getPrice(int id) {
        return new Price(id, String.valueOf(id));
    }

    class Price {
        int id;
        String name;

        public Price(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Price{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


}
