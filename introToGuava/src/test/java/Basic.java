import com.google.common.base.*;
import com.google.common.cache.*;
import com.google.common.collect.*;
import com.google.common.util.concurrent.Callables;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jacob on 2015-7-13.
 */
public class Basic {


    @Test
    public void Joiner() {
        List<String> strings = new ArrayList<String>();
        strings.add("one");
        strings.add(null);
        strings.add("three");
        strings.add("four");
        System.out.println(Joiner.on("|").useForNull("ThisIsANull").join(strings));

        Map<String, String> map = new HashMap<String, String>();
        map.put("1ai", "qing");
        map.put("2ai", "zong");

        System.out.println(Joiner.on("|").withKeyValueSeparator("--").join(map));

        // same to Splitter.
    }

    /**
     * Functional Programming...
     */
    class IntToStringFunction implements Function<Integer, String> {

        public String apply(Integer input) {
            return String.valueOf(input);
        }
    }

    class StringToIntFunction implements Function<String, Integer> {

        public Integer apply(String input) {
            return Integer.parseInt(input);
        }
    }

    class IntIsEvenPredicate implements Predicate<Integer> {

        public boolean apply(Integer input) {
            return input % 2 == 0;
        }
    }

    class IntLessThan10Predicate implements Predicate<Integer> {

        public boolean apply(Integer input) {
            return input < 10;
        }
    }

    Predicate<Integer> evanAndLessThan10 = Predicates.and(new IntIsEvenPredicate(), new IntLessThan10Predicate());
    Predicate<String> evenStrings = Predicates.compose(new IntIsEvenPredicate(), new StringToIntFunction());


    /**
     * Let's go with Guava Collections and Functional Programming...
     */
    List<Integer> ints = new ArrayList<Integer>();
    List<String> strings = new ArrayList<String>();

    @Before
    public void before() {
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(16);
        ints.add(315);

        strings.addAll(Arrays.asList("2", "5", "11", "78"));
    }


    @Test
    public void functionAndList() {
        // filter
        System.out.println(Joiner.on(", ").join(FluentIterable.from(ints).filter(new IntIsEvenPredicate())));
        System.out.println(Joiner.on(", ").join(FluentIterable.from(ints).filter(
                Predicates.and(new IntIsEvenPredicate(), new IntLessThan10Predicate()))));

        // mapping
        System.out.println(Joiner.on(", ").join(FluentIterable.from(strings).transform(new StringToIntFunction())));
    }

    @Test
    public void maps() {
        List<String> strings2 = Lists.newArrayList("1", "2", "3", "4", "5");
        Map<Integer, String> intMap = Maps.uniqueIndex(strings2, new Function<String, Integer>() {
            public Integer apply(String input) {
                return Integer.parseInt(input);
            }
        });

        System.out.println(Joiner.on(", ").withKeyValueSeparator(":").join(intMap));
        ImmutableMap<String, Integer> immutableIntMap = Maps.toMap(strings2, new Function<String, Integer>() {
            public Integer apply(String input) {
                return Integer.parseInt(input);
            }
        });

        System.out.println(Joiner.on(", ").withKeyValueSeparator(":").join(immutableIntMap));

        // transform

        Map<Integer, Price> prices = Maps.transformEntries(intMap, new Maps.EntryTransformer<Integer, String, Price>() {
            public Price transformEntry(Integer key, String value) {
                return new Price(key, value);
            }
        });

        System.out.println(Joiner.on(", ").withKeyValueSeparator(":").join(prices));
    }

    @Test
    public void MultiThings() {
        ArrayListMultimap<Integer, String> multiMap =
                ArrayListMultimap.create();
        multiMap.put(1, "1");
        multiMap.put(1, "2");
        multiMap.put(99, "99");

        for (Integer key : multiMap.keySet()) {
            for (String s : multiMap.get(key)) {
                System.out.println(String.format("Key:%d, Values:%s", key, s));
            }
        }

        // so was HashMultimap
        HashMultimap multiHashMap = HashMultimap.create();

        // BiMap
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("ai1", "qing");
        biMap.put("ai2", "zong");
        biMap.forcePut("ai3", "zong");
        for (Map.Entry<String, String> entry : biMap.inverse().entrySet()) {
            System.out.println(String.format("Key:%s, Values:%s", entry.getKey(), entry.getValue()));
        }
    }

    /**
     * Cache
     */
    @Test
    public void cache() throws Exception {
        LoadingCache<String, Price> priceCache =
                CacheBuilder.newBuilder()
                        .expireAfterAccess(1L, TimeUnit.SECONDS)
                        .removalListener(new RemovalListener<String, Price>() {
                            public void onRemoval(RemovalNotification<String, Price> notification) {
                                System.out.println(String.format("==Remove: Key:%s, Values:%s",
                                        notification.getKey(), notification.getValue()));
                            }
                        })
                        .build(new CacheLoader<String, Price>() {
                            @Override
                            public Price load(String key) throws Exception {
                                return new Price(Integer.parseInt(key), key);
                            }
                        });

        LoadingCache<String, Price> priceCache2 = CacheBuilder
                .newBuilder()
                .expireAfterWrite(1L, TimeUnit.SECONDS)
                .build(CacheLoader.from(new Function<String, Price>() {
                    public Price apply(String input) {
                        return new Price(Integer.parseInt(input), input);

                    }
                }));

        priceCache.get("1");
//        priceCache.put("1", new Price(1, "1"));
        Thread.sleep(3100);
        priceCache.get("1");
        Callable<String> value = Callables.returning("init value");

    }


}

class Price {
    int price;

    String name;

    public Price(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
