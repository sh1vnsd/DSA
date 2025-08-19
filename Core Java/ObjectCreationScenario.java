import java.util.*;

public class ObjectCreationScenario {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    // This is basically a runtime polymorphism
    // Parent parent = new Child();

    final List<String> l2 = new ArrayList<>();
    l2.add("a");
    l2.add("b");

    System.out.println(l2);
  }
}
