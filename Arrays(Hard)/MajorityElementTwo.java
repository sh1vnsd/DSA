class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mpp = new HashMap<>();
        int min = (n / 3) + 1; 

        for(int i = 0; i < n; i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);

            if(mpp.get(nums[i]) == min){
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}

//Moorse Votting Algo
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int min = (n / 3); 

        int cnt1 = 0, cnt2 = 0, ele1 = -1, ele2 = -1;

        for(int i = 0; i < n; i++){
            if(cnt1 == 0 && nums[i] != ele2){
                cnt1 = 1;
                ele1 = nums[i];
            }
            else if(cnt2 == 0 && nums[i] != ele1){
                cnt2 = 1;
                ele2 = nums[i];
            }
            else if(nums[i] == ele1) cnt1++;
            else if(nums[i] == ele2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        int cntL = 0, cntR = 0;
        for(int i = 0; i < n; i++){
            if(ele1 == nums[i]) cntL++;
            else if(ele2 == nums[i]) cntR++;
        }

        if(cntL > min) ans.add(ele1);
        if(cntR > min) ans.add(ele2);

        return ans;
    }
}

