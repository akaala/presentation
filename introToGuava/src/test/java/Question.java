import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question {


    ImmutableList<Integer> list = ImmutableList.of(2, 65, 28, 892);

    @Before
    public void before() {

    }

    /**
     * ��һ��List<Integer> list,�����������"2|65|28|892"
     */
    @Test
    public void test1() {
        for (Integer integer : list) {
            System.out.print(integer);
            System.out.println("|");
        }

    }

    /**
     * ��һ��List<Integer> list, 1)�����ֻ����ż������List
     * 2) ���д���10��ż������List
     */
    @Test
    public void test2() {
        List<Integer> sublist = new ArrayList<Integer>();
        for (Integer integer : list) {
            if (integer % 2 == 0 && integer > 10)
                sublist.add(integer);
        }


    }


    /**
     * ��ĳ������getPrice(int id), �ṩ������ID:����һ�������Class��
     * <p/>
     * ����һ��Map<ID, Class>��ID����list
     */
    @Test
    public void test3() {
        Map<Integer, Price> map = new HashMap<Integer, Price>();
        for (Integer id : list) {
            map.put(id, getPrice(id));
        }
    }


    /**
     * ����һ��<Key,Value>��Cache,ʵ��30����ǰ��Key�Զ�ʧЧ����ValueSet���Ա�GC����
     */
    @Test
    public void test4() {
        Map<Integer, Price> map = new HashMap<Integer, Price>();


        // timeout : 30min

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
