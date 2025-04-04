public class RemoveTheLastSetBit {
    public static void main(String[] args) {
        int n = 16;

        int res = n & (n - 1);
        System.out.println(res);
    }
}
