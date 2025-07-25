class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int n = s.length();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                size *= ch - '0';
            } else {
                size += 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            k %= size;

            if (k == 0 && Character.isLetter(ch)) {
                return String.valueOf(ch);
            }

            if (Character.isDigit(ch)) {
                size /= ch - '0';
            } else {
                size -= 1;
            }
        }

        return "";
    }
}

