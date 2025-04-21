class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> union = new ArrayList<>();

        int i = 0;
        int j = 0; 
        
        int n1 = a.length;
        int n2 = b.length;

        while(i < n1 && j < n2){
            if(a[i] < b[j]){
                if(union.size() == 0 || union.get(union.size() - 1) != a[i]){
                    union.add(a[i]);
                }
                i++;
            } else if(a[i] > b[j]){
                if(union.size() == 0 || union.get(union.size() - 1) != b[j]){
                    union.add(b[j]);
                }
                j++;
            } else { // a[i] == b[j]
                if(union.size() == 0 || union.get(union.size() - 1) != a[i]){
                    union.add(a[i]);
                }
                i++;
                j++;
            }
        }

        while(i < n1){
            if(union.size() == 0 || union.get(union.size() - 1) != a[i]){
                union.add(a[i]);
            }
            i++;
        }

        while(j < n2){
            if(union.size() == 0 || union.get(union.size() - 1) != b[j]){
                union.add(b[j]);
            }
            j++;
        }

        return union;
    }
}

