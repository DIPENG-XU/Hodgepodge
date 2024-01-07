package classicalTopic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueen {
    final int size;

    public EightQueen(int size) {
        this.size = size;
    }

    public List<List<Integer>> solve() {
        final var result = new ArrayList<List<Integer>>();
        for (int start = 0; start < size; start++) {
            backTracking(result, new ArrayList<>(), 0, start);
        }
        return result;
    }

    private void backTracking(List<List<Integer>> results, List<Integer> result, int currentXAxis, int currentYAxis) {
        if (isConfirm(result, currentXAxis, currentYAxis)) return;
        for (int nextYAxis = 0; nextYAxis < size; nextYAxis++) {
            final var nextResult = new ArrayList<>(result);
            nextResult.add(currentYAxis);
            if (nextResult.size() >= size) {
                results.add(nextResult);
                return;
            }
            backTracking(results, nextResult, currentXAxis + 1, nextYAxis);
        }
    }

    private boolean isConfirm(List<Integer> result, int currentXAxis, int currentYAxis) {
        for (int cursorXAxis = 0; cursorXAxis < currentXAxis; cursorXAxis++) {
            final var cursorYAxis = result.get(cursorXAxis);
            if ((Math.abs(cursorYAxis - currentYAxis) == Math.abs(cursorXAxis - currentXAxis)) || (cursorYAxis == currentYAxis))
                return true;
        }
        return false;
    }

    private static String[] toCharChess(List<Integer> indexChess) {
        final var size = indexChess.size();
        final var result = new String[size];
        Arrays.fill(result, "X");

        indexChess.forEach(yAxis -> {
            final var xAxis = indexChess.indexOf(yAxis);
            final var text = ("X".repeat(Math.max(0, xAxis)) + "Q" + "X".repeat((size - xAxis - 1)));
            result[size - yAxis - 1] = text;
        });
        return result;
    }

    public static void main(String[] args) {
        final var instance = new EightQueen(8);
        final var result = instance.solve();
        for (List<Integer> indexChess : result) {
            for (String charChess : toCharChess(indexChess)) {
                System.out.println(charChess);
            }
            System.out.println(indexChess);
            System.out.println("------------");
        }

        System.out.printf("The size of all solution is %d%n", result.size());
    }
}
