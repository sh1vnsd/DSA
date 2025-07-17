import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    HashMap<String, boolean> map = new HashMap<>();

    public boolean isConcatenated(String word, HashSet<String> st){

        if(map.containsKey(word)){
            return map.get(word);
        }

        int n = word.length();
        for(int i = 0; i < n; i++){
            String prefix = word.substring(0, i + 1);

            String suffix = word.substring(i + 1);

            if((st.contains(prefix) && isConcatenated(suffix, st)) || (st.contains(prefix) && st.contains(suffix))){
                return true;
            }
        }
        map.put(word, false);
        return false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;
        
        HashSet<String> st = new HashSet<>(Arrays.asList(words));

        ArrayList<String> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String word = words[i];

            if(isConcatenated(word, st)){
                res.add(word);
            }
        }

        return res;
    }
}
