package lab2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapHelper {

    public static <K, V> V get(Map61B<K, V> sim, K key) {
        if(sim.containsKey(key)) {
            return sim.get(key);
        }
        return null;
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