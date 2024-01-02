package collection;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableDemo {

    public void updateHashMap() {
        final var map = new HashMap<String, String>();
        final var startTime = System.currentTimeMillis();
        testMap(map);
        System.out.printf("updateHashMap time is %s s\n", (System.currentTimeMillis() - startTime) / 1000);
    }

    public void updateHashTable() {
        final var map = new Hashtable<String, String>();
        final var startTime = System.currentTimeMillis();
        testMap(map);
        System.out.printf("updateHashTable time is %s s\n", (System.currentTimeMillis() - startTime) / 1000);
    }

    private void testMap(Map<String, String> map) {
        int count = 100000;
        for (int i = 0; i < count; i++) {
            int finalI = i;
            new Thread(() -> map.put(String.format("%s --value", finalI), String.format("finalValue is %s", finalI))).start();
        }

        var nullItemCount = 0;
        for (int i = 0; i < count; i++) {
            final var data = map.get(String.format("%s --value", i));
            if (data == null) {
                nullItemCount++;
                System.out.printf("key is %s and value is null%n", i);
            }
        }

        System.out.printf("null item count is %s\n", nullItemCount);
    }

    public static void main(String[] args) {
        final var hashTableDemo = new HashTableDemo();
        hashTableDemo.updateHashMap();
        System.out.println("-----------------");
        hashTableDemo.updateHashTable();
    }
}
