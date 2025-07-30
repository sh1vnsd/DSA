import java.util.Arrays;

class Solution {
    public String customSortString(String order, String s) {
        int[] index = new int[26];

        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }

        Character[] charArray = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }

        Arrays.sort(charArray, (ch1, ch2) -> Integer.compare(index[ch1 - 'a'], index[ch2 - 'a']));

        StringBuilder res = new StringBuilder(s.length());
        for (char ch : charArray) {
            res.append(ch);
        }

        return res.toString();
    }
}

