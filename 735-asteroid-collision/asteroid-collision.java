
import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int current : asteroids) {

            boolean alive = true;

            // Collision is possible only when
            // previous asteroid moves right
            // and current asteroid moves left
            while (alive && current < 0 &&
                   !stack.isEmpty() && stack.peek() > 0) {

                if (stack.peek() < -current) {

                    // Previous asteroid explodes
                    stack.pop();

                } else if (stack.peek() == -current) {

                    // Both asteroids explode
                    stack.pop();
                    alive = false;

                } else {

                    // Current asteroid explodes
                    alive = false;
                }
            }

            // Push only if current asteroid survives
            if (alive) {
                stack.push(current);
            }
        }

        // Convert stack into answer array
        int[] ans = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            ans[i] = stack.get(i);
        }

        return ans;
    }
}
