
class Q{
    int size = 10;
    int[] q = new int[size];
    int currSize = 0, start = -1, end = -1;

    void push(int x){
        if(currSize == size){
            System.out.println("Queue Full");
            return;
        }
        if(currSize == 0){
            start = 0;
            end = 0;
        }
        else{
            end = (end + 1) % size;
        }

        q[end] = x;
        currSize++;
    }

    int pop(){
        if(currSize == 0){
            return -1;
        }

        int ele = q[start];

        if(currSize == 1){
            start = -1;
            end = -1;
            currSize--;
        }
        else{
            start = (start + 1) % size;
            currSize--;
        }

        return ele;
    }

    int top(){
        if(currSize == 0) return -1;

        return q[start];
    }

    int size(){
        return currSize;
    }
}
public class QueueUsingArray{
    public static void main(String[] args) {
       Q queue = new Q(); 
        queue.push(2);
        queue.push(4);
        queue.push(6);
        System.out.println("Top: " + queue.top());  // 2
        System.out.println("Size: " + queue.size());  // 3
        System.out.println("Popped: " + queue.pop());  // 2
        System.out.println("Top after pop: " + queue.top());  // 4
        System.out.println("Size now: " + queue.size());  // 2
    }
}
