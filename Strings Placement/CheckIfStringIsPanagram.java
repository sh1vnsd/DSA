class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = 26;
        boolean[] vis = new boolean[n];

        for(int i = 0; i < sentence.length(); i++){
            vis[sentence.charAt(i) - 'a'] = true;
        }

        for(int i = 0; i < vis.length; i++){
            if(vis[i] == false) return false;
        }

        return true;
    }
}
