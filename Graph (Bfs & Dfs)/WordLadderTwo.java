import java.util.*;

class WordLadderTwo {
    public List<List<String>> findLadders(String startWord, String targetWord, List<String> wordList) {
        HashSet<String> st = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            st.add(wordList.get(i));
        }
        Queue<ArrayList<String>> q = new ArrayDeque<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;
        List<List<String>> ans = new ArrayList<>(); // Change type to match the return type

        while (!q.isEmpty()) {
            ArrayList<String> vec = q.peek();   
            q.remove();

            // Erase all words that have been used in previous levels to transform
            if (vec.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    st.remove(it);
                }
            }

            String word = vec.get(vec.size() - 1);
            if (word.equals(targetWord)) {
                // The first sequence where we reached the end
                if (ans.size() == 0) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String changedWord = new String(replacedCharArray);

                    if (st.contains(changedWord)) {
                        vec.add(changedWord);

                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);

                        usedOnLevel.add(changedWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WordLadderTwo solver = new WordLadderTwo();

        String startWord = "hit";
        String targetWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> result = solver.findLadders(startWord, targetWord, wordList);
        System.out.println("All shortest transformation sequences: " + result);
    }
}
