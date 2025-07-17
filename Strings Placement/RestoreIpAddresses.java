import java.util.ArrayList;
import java.util.List;

class Solution {
    int n;
    List<String> res = new ArrayList<>();

    public boolean isValid(String str){
        if(str.charAt(0) == '0') return false;

        int val = Integer.parseInt(str);

        return val <= 255;
    }

    public void solve(String s, int idx, int part, String curr){
        if(idx == s.length() && part == 4){
            res.add(curr.substring(0, curr.length() - 1));
            return;
        }

        if(part > 4) return;

        if(idx + 1 <= n){
            solve(s, idx + 1, part + 1, curr + s.substring(idx, idx + 1) + ".");
        }

        if(idx + 2 <= n && isValid(s.substring(idx, idx + 2))){
            solve(s, idx + 2, part + 1, curr + s.substring(idx, idx + 2) + ".");
        }

        if(idx + 3 <= n && isValid(s.substring(idx, idx + 3))){
            solve(s, idx + 3, part + 1, curr + s.substring(idx, idx + 3) + ".");
        }
    }
    public List<String> restoreIpAddresses(String s) {
        res.clear();
        n = s.length();

        if(n > 12) {
            return new ArrayList<>();
        }

        int part = 0;
        String curr = "";

        solve(s, 0, part, curr);

        return res;
    }
}

