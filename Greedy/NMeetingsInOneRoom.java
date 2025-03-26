import java.util.ArrayList;

class Data{
    int start, end, pos;
    
    Data(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class Solution {
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        Data[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i].start = start[i];
            arr[i].end = end[i];
            arr[i].pos = i + 1;
        }


        Arrays.sort(arr, (a, b) -> (a.end - b.end));


        int count = 1, freeTime = arr[0].end;
        ArrayList<Integer> ans = new ArrayList<>(); // to store the order of meetings completed
        for(int i = 1; i < n; i++){
            if(arr[i].start > freeTime){
                count += 1;
                freeTime = arr[i].end;
                ans.add(i); // to store the order of the meetings completed
            }
        }
        return count;

    }
}

