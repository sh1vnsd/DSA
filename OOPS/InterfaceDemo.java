interface Car{
    public void start();
}

class ElectricCar implements Car{
    public void start(){
        System.out.println("Electric Car Started");
    }
}

class DieselCar implements Car{
    public void start(){
        System.out.println("Diesel Car Started");
    }
}

public class InterfaceDemo{
    public static void main(String[] args) {
       Car Tesla = new ElectricCar(); 
       Tesla.start();

       Car XUV700 = new DieselCar();
       XUV700.start();
    }
}
