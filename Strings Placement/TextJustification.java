import java.util.ArrayList;

class Solution {
    int MAX_WIDTH;

    public String findLine(int i, int j, int eachSlotSpace, int extraSpaceSlot, String[] words){

        StringBuilder line = new StringBuilder();

        for(int k = i; k < j; k++){
            line.append(words[k]);

            if(k == j - 1){
                continue;
            }

            for(int z = 1; z <= eachSlotSpace; z++){
                line.append(" ");
            }

            if(extraSpaceSlot > 0){
                line.append(" ");
                extraSpaceSlot--;
            }
        }

        while(line.length() < MAX_WIDTH){
            line.append(" ");
        }

        return line.toString();
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<>();

        int n = words.length;

        MAX_WIDTH = maxWidth; 

        int i = 0;

        while(i < n){

            int lettersCount = words[i].length();

            int j = i + 1;

            int gaddhe = 0;

            while(j < n && words[j].length() + 1 + gaddhe + lettersCount <= maxWidth){
                lettersCount += words[j].length();
                gaddhe += 1;
                j++;
            }

            int remainingSlots = maxWidth - lettersCount;

            int eachSlotSpace = gaddhe == 0 ? 0 : remainingSlots / gaddhe;
            int extraSpaceSlot = gaddhe == 0 ? 0 : remainingSlots % gaddhe;

            if(j == n){
                eachSlotSpace = 1;
                extraSpaceSlot = 0;
            }

            res.add(findLine(i, j, eachSlotSpace, extraSpaceSlot, words));

            i = j;
        }

        return res;
    }
}
