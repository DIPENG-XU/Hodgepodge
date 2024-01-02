package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class VectorAndList {
    public void vectorTest() {
        final var startTime = System.currentTimeMillis();

        final var vector = new Vector<Integer>();
        threadRun(vector);
        
        System.out.printf("Spend Time is %ss\n", ((System.currentTimeMillis() - startTime) / 1000));
    }

    public void listTest() {
        final var startTime = System.currentTimeMillis();

        final var list = new ArrayList<Integer>();
        threadRun(list);

        System.out.printf("Spend Time is %ss\n", ((System.currentTimeMillis() - startTime) / 1000));
    }

    private void threadRun(Collection<Integer> list) {
        final var allCount = 100000;

        for (int i = 0; i < allCount; i++) {
            int finalI = i;
            new Thread(() -> list.add(finalI)).start();
        }

        var nullCount = 0;
        for (int i = 0; i < allCount; i++) {
            if (!list.contains(i)) {
                nullCount++;
            }
        }
        System.out.printf("null data count is %s\n", nullCount);
    }

    public static void main(String[] args) {
        final var vectorAndList = new VectorAndList();
        vectorAndList.vectorTest();
        System.out.println("----------------");
        vectorAndList.listTest();
    }
}
