class Solution {
    public boolean isVowel(Character ch){
        ch = Character.toLowerCase(ch);

        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }

    public String sortVowels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(var ch : s.toCharArray()){
            if(isVowel(ch)){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        String temp = "AEIOUaeiou";

        int j = 0;

        char[] res = s.toCharArray();

        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){

                while(map.getOrDefault(temp.charAt(j), 0) == 0){
                    j++;
                }

                res[i] = temp.charAt(j);
                map.put(temp.charAt(j), map.get(temp.charAt(j)) - 1);
            }
        }

        return new String(res);
    }
}
