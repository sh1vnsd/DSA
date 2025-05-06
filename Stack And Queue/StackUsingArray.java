class StImpl{
    int top = -1;
    int[] st = new int[10];

    void push(int x){
        if(top >= 9){
            System.out.println("Stack Full");
            return;
        }
        
        top++;
        st[top] = x;
    }

    int top(){
        if(top == -1){
            System.out.println("Stack Empty");
            return -1;
        }

        return st[top];
    }

    void pop(){
        if(top == -1){
            System.out.println("Stack Empty");
            return;
        }

        top--;
    }

    int size(){
        return top + 1;
    }
}
public class StackUsingArray{
    public static void main(String[] args) {
       StImpl s1 = new StImpl(); 
       s1.push(4);
       s1.push(3);
       s1.push(5);

       System.out.println(s1.top());
       s1.pop();
       System.out.println(s1.top());

    }
}
