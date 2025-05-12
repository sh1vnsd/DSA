// TO INVOKE PARENT CLASS VARIABLE

class Animal{
  String color = "white";
}

class Dog extends Animal{
  String color = "Black";
  void printColor(){
    System.out.println(color);
    System.out.println(super.color);
  }
}

class TestSuper1{
  public static void main(String[] args){
    Dog d = new Dog();
    d.printColor();
  }
}


// TO INVOKE PARENT CLASS METHOD

class Animal{
  void eat(){
    System.out.println("eating.....");
  }
}

class Dog extends Animal{
  void eat(){
    System.out.println("eating bread....");
  
  }
  void bark(){
    System.out.println("barking....");
  }
  void work(){
    super.eat();
    bark();
  }
}

class TestSuper1{
  public static void main(String[] args){
    Dog d = new Dog();
    d.work();
  }
}


// TO INVOKE PARENT CLASS CONSTRUCTOR

class Animal{
  Animal(){
    System.out.println("animal is created");
  }
}

class Dog extends Animal{
  Dog(){
    super();
    System.out.println("dog is created");
  }
}

class TestSuper1{
  public static void main(String[] args){
    Dog d = new Dog();
  }
}
