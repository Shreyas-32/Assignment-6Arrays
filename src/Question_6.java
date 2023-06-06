import java.util.*;

 class DoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0]; // If the length is odd, it can't be a doubled array
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> originalList = new ArrayList<>();
        Arrays.sort(changed); // Sort the array to ensure we get the smallest elements first

        for (int num : changed) {
            if (countMap.get(num) == 0) {
                continue; // Skip if the current number is already used
            }

            if (countMap.containsKey(num * 2) && countMap.get(num * 2) > 0) {
                originalList.add(num);
                countMap.put(num, countMap.get(num) - 1); // Decrease count of current number
                countMap.put(num * 2, countMap.get(num * 2) - 1); // Decrease count of doubled number
            }
        }

        if (originalList.size() == changed.length / 2) {
            int[] original = new int[originalList.size()];
            for (int i = 0; i < originalList.size(); i++) {
                original[i] = originalList.get(i);
            }
            return original;
        } else {
            return new int[0]; // If not all numbers are used, it's not a doubled array
        }
    }
}

public class Question_6 {
    public static void main(String[] args) {
        DoubledArray solution = new DoubledArray();

        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] original = solution.findOriginalArray(changed);
        System.out.println(Arrays.toString(original)); // Output: [1, 3, 4]
    }
}

