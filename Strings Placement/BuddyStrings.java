import java.util.ArrayList;

class Solution {
    public boolean checkFreq(String s) {
        int[] arr = new int[26];

        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
            if (arr[ch - 'a'] > 1) {
                return true;
            }
        }
        return false;
    }

    public void swap(char[] str, int ind1, int ind2) {
        char temp = str[ind1];
        str[ind1] = str[ind2];
        str[ind2] = temp;
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            return checkFreq(s);
        }

        ArrayList<Integer> index = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                index.add(i);
            }
        }

        if (index.size() != 2) {
            return false;
        }

        char[] str = s.toCharArray();
        swap(str, index.get(0), index.get(1));

        return new String(str).equals(goal);
    }
}

