//Brute
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}


//Better
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);
                if (hashSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp); 
                    set.add(temp);
                }
                hashSet.add(nums[j]);
            }
        }

        return new ArrayList<>(set);
    }
}




//Optimal
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(i>0 && nums[i] == nums[i - 1]) continue; //Move till not same element
            int j = i + 1;
            int k = n - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    j++;
                    k--;

                    //Keep moving till they are not same
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ans;
    }
}
