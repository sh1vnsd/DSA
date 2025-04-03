import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();

        HashSet<Integer> s = new HashSet<>();

        for(int i = 0; i < a.length; i++){
            s.add(a[i]);
        }

        for(int i = 0; i < b.length; i++){
            if(s.contains(b[i])){
                ans.add(b[i]);
                s.remove(b[i]);
            }
        }

        Collections.sort(ans);
        return ans; 
    }
}
