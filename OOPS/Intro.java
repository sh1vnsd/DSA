public class Intro {
    String name;
    int roll_no;

    public void printData(){
        System.out.println(name);
        System.out.println(roll_no);
    }

    public static void main(String[] args) {
        Intro std1 = new Intro();
        std1.name = "Shivansh";
        std1.roll_no = 1374;

        Intro std2 = new Intro();
        std2.name = "Sood";
        std2.roll_no = 1374;
        
        std1.printData();
        std2.printData();
    }
}
