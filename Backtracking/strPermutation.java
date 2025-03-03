import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solve {
    void recurPermute(char[] chars, StringBuilder current, boolean[] freq, ArrayList<String> ans) {
        if (current.length() == chars.length) {
            ans.add(current.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                current.append(chars[i]);
                recurPermute(chars, current, freq, ans);
                current.deleteCharAt(current.length() - 1); // Backtrack
                freq[i] = false;
            }
        }
    }

    ArrayList<String> permute(String str) {
        ArrayList<String> ans = new ArrayList<>();
        boolean[] freq = new boolean[str.length()];
        char[] chars = str.toCharArray();
        StringBuilder current = new StringBuilder();
        recurPermute(chars, current, freq, ans);
        return ans;
    }
}

public class strPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solve solve = new Solve();
        ArrayList<String> perm = solve.permute(str);
        Collections.sort(perm); // Sort the permutations lexicographically
        for (String s : perm) {
            System.out.println(s);
        }
        sc.close();
    }
}
