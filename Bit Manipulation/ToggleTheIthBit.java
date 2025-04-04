public class ToggleTheIthBit{
    public static void main(String[] args) {
        int n = 13;
        int i = 1;

        int res = n ^ (1 << i);
        System.out.println(res);
    }
}
