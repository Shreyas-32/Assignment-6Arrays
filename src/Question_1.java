import java.util.ArrayList;
import java.util.List;

public class Question_1 {
    public static int[] findPermutation(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        List<Integer> remaining = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            remaining.add(i);
        }

        int index = 0;
        if (s.charAt(0) == 'D') {
            perm[0] = remaining.remove(remaining.size() - 1);
        } else {
            perm[0] = remaining.remove(0);
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'D') {
                perm[i + 1] = remaining.remove(remaining.size() - 1);
            } else {
                perm[i + 1] = remaining.remove(0);
            }
        }

        return perm;
    }

    public static void main(String[] args) {
        String s = "IDID";
        int[] perm = findPermutation(s);

        // Print the reconstructed permutation
        for (int num : perm) {
            System.out.print(num + " ");
        }
    }
}
