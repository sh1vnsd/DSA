import java.util.HashMap;
import java.util.Scanner;

class rgb{
    public int redgreenblue(String stones) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] str = stones.toCharArray();
        int l = 0, r = 0, minLen = Integer.MAX_VALUE;

        while (r < str.length) {
            map.put(str[r], map.getOrDefault(str[r], 0) + 1);

            while (map.size() > 2) { // Ensure we have at least 3 unique chars before updating minLen
                minLen = Math.min(minLen, r - l + 1);
                map.put(str[l], map.get(str[l]) - 1);
                if (map.get(str[l]) == 0) {
                    map.remove(str[l]);
                }
                l++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String stones = sc.next();
        sc.close();

        rgb obj = new rgb();
        int result = obj.redgreenblue(stones);
        System.out.println(result);
    }
}

