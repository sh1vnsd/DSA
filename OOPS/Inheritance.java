/* class parentClass{
    void display(){
        System.out.println("Parent Class Method");
    }
}

class childClass extends parentClass{
    void show(){
        System.out.println("Child Class Method");
    }
}

public class Inheritance{
    public static void main(String[] args) {
       childClass obj1 = new childClass(); 
       obj1.show();
       System.out.println();
       obj1.display();
    }
} */


class Vehicle{
    double price;
    double mileage;
    String color;

    void display(){
        System.out.println("Price: "+price);
        System.out.println("Mileage: "+mileage);
        System.out.println("Color: "+color);
    }
}


class Car extends Vehicle{
    String fuelType;
    boolean sunroof;
    String brand; 

}

public class Inheritance{
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "Hyundai";
        car1.price = 1500000;
        car1.mileage = 18.3;
        car1.fuelType = "Petrol";
        car1.sunroof = true;
        car1.color = "Black";

        car1.display();  
        System.out.println(car1.sunroof);
        System.out.println(car1.brand);
        System.out.println(car1.fuelType);
    }
}
