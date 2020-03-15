package lab2;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MapHelper {

    public static <K, V> V get(Map61B<K, V> sim, K key) {
        if(sim.containsKey(key)) {
            return sim.get(key);
        }
        return null;
    }
    public static <K extends Comparable<K> , V> K maxKey(ArrayMap<K, V> map) {
        List<K> keylist = map.keys();
        K largest = keylist.get(0);
        for(K k : keylist) {
            if(k.compareTo(largest) > 0) {
                largest = k;
            } 
        }
        return largest;
    }
    @Test
    public void testGet() {
        Map61B<String, Integer> m = new ArrayMap<>();

        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        Integer actual = get(m, "asdasd");
        Integer expected = 9;
        assertEquals(null, actual);
    }
} 