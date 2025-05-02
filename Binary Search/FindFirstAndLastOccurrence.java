class Solution {
    public int lowerBound(int[] nums, int target){
        int n = nums.length;
        int low = 0, high = n - 1, ans = n;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public int upperBound(int[] nums, int target){
        int n = nums.length;
        int low = 0, high = n - 1, ans = n;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];

        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);

        if(lb == n || nums[lb] != target){
            ans[0] = -1;
            ans[1] = -1;
        }
        else{
            ans[0] = lb;
            ans[1] = ub - 1;
        }

        return ans;
    }
}



//Simple Binary search
class Solution {
    public int firstOccur(int[] nums, int target, int n){
        int low = 0, high = n - 1, first = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return first;
    }
        public int lastOccur(int[] nums, int target, int n){
        int low = 0, high = n - 1, last = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        int first = firstOccur(nums, target, n);
        if(first == -1){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        int last = lastOccur(nums, target, n);
        ans[0] = first;
        ans[1] = last;

        return ans;
    }
}
