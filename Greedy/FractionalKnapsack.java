class Item {
    int val, wt;
    double ratio;
    
    Item(int val, int wt){
        this.val = val;
        this.wt = wt;
        this.ratio = (double)val / wt;
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

        double totalSum = 0;
        for(Item item : arr){
            if(item.wt <= capacity){
                totalSum += item.val;
                capacity -= item.wt;
            }
            else{
                totalSum += item.ratio * capacity;
                break;
            }
        }
        return totalSum;
    }
}
