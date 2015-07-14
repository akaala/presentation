import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

public class Question {


    ImmutableList<Integer> list = ImmutableList.of(2, 65, 28, 892);

    @Before
    public void before() {

    }

    /**
     * 有一个List<Integer> list,将其输出形如"2,65,28,892"
     */
    @Test
    public void test1() {

    }

    /**
     * 有一个List<Integer> list, 1)输出其只含有偶数的子List
     * 2) 所有大于10的偶数的子List
     */
    @Test
    public void test2() {

    }


    /**
     * 有某个服务getPrice(int id), 提供：根据ID:返回一个具体的Class。
     * <p/>
     * 生成一个Map<ID, Class>。ID来自list
     */
    @Test
    public void test3() {

    }


    /**
     * 构建一个<Key,Value>的Cache,实现30分钟前的Key自动失效，且ValueSet可以被GC掉。
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
