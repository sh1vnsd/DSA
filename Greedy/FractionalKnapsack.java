class Item {
    int val, wt;
    double ratio;
    
    Item(int val, int wt){
        this.val = val;
        this.wt = wt;
        this.ratio = (double)(val / wt);
    }
}
class Solution {
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n = val.size();

        Item[] arr = new Item[n];

        for(int i = 0; i < n; i++){
            arr[i] = new Item(val.get(i), wt.get(i));
        }

        Arrays.sort(arr, (a, b) -> Double.compare(b.ratio, a.ratio));

        int totalSum = 0;
        for(int i = 0; i < n; i++){
            if(arr[i].wt <= capacity){
                totalSum += arr[i].val;
                capacity -= arr[i].wt;
            }
            else{
                totalSum += (double)arr[i].ratio * capacity;
                break;
            }
        }
        return totalSum;
    }
}
