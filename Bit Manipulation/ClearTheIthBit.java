public class ClearTheIthBit{
    public static void main(String[] args) {
        int n = 13;
        int i = 2;

        int res = n & ~(1 << i);

        System.out.println(res);
    }
}
