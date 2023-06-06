import java.util.HashMap;
import java.util.Map;

public class Question_4 {
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;

            if (sumMap.containsKey(sum)) {
                int prevIndex = sumMap.get(sum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                sumMap.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        int maxLength = findMaxLength(nums);
        System.out.println(maxLength);
    }
}
