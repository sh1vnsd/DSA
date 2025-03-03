class Pair {
    String first, int second;
    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st = new HashSet<>();
        int len = wordList.length;
        for(int i=0; i<len; i++){
            st.add(wordList.get(i));
        }

        Queue<Pair> q = new ArrayDeque<Pair>();
        q.add(beginWord, 1);
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int len = q.peek().second;
            q.remove();
            if(word.equals(endWord)) return steps;

            for(int i=0; i<word.length; i++){
                for(char ch='a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(replacedWord, len+1);
                    } 
                }
            }
        }
        return 0;
    }
}