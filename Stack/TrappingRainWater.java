class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] preffix = new int[n];
        int[] suffix = new int[n];

        preffix[0] = height[0];
        suffix[n - 1] = height[n - 1];

        for(int i = 1; i < n; i++){
            preffix[i] = Math.max(preffix[i - 1], height[i]);
        }

        for(int i = n - 2; i >= 0; i--){
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }

        int total = 0;

        for(int i = 1; i < n; i++){
            int leftMax = preffix[i], rightMax = suffix[i];
            if(height[i] < leftMax && height[i] < rightMax){
                total += Math.min(leftMax, rightMax) - height[i];
            }
        }

        return total;
    }
}
