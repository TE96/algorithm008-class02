package greedy;

import java.util.HashSet;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> obstaclesSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstaclesSet.add(obstacle[0] + " " + obstacle[1]);
        }
        int x = 0, y = 0, d = 0, result = 0;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int command : commands) {
            if (command == -1) {
                d = (d + 1) % 4;
            }
            else if (command == -2) {
                d = (d + 3) % 4;
            }
            else {
                while (command-- > 0 && !obstaclesSet.contains((x + directions[d][0] + " " + (y + directions[d][1])))) {
                    x += directions[d][0];
                    y += directions[d][1];
                }
                result = Math.max(result, x * x + y * y);
            }
        }
        return result;
    }
}
