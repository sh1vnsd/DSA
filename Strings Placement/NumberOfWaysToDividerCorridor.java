import java.util.ArrayList;

class Solution {
    static final int MOD = (int)1e9 + 7;
    public int numberOfWays(String corridor) {
        ArrayList<Integer> seatIdx = new ArrayList<>();

        for(int i = 0; i < corridor.length(); i++){
            if(corridor.charAt(i) == 'S'){
                seatIdx.add(i);
            }
        }

        if(seatIdx.size() % 2 != 0 || seatIdx.size() < 2) return 0;

        int prevIdx = seatIdx.get(1);
        long res = 1;

        for(int i = 2; i < seatIdx.size(); i += 2){
            int currIdx = seatIdx.get(i);

            res = (res * (currIdx - prevIdx)) % MOD;

            prevIdx = seatIdx.get(i + 1);
        }

        return (int)res;
    }
}
