public class OrderService {

    public void getOrder(int orderId) throws OrderNotFoundException{
        if(orderId == 101){
            throw new OrderNotFoundException("Order not found with id: " + orderId);
        }
        else{
            System.out.println("Order found with id: " + orderId);
        }
    }

    public static void main(String[] args) throws OrderNotFoundException{
        OrderService service = new OrderService();
        service.getOrder(101);
    }
}

class OrderNotFoundException extends Exception {

    public OrderNotFoundException(String message){
        super(message);
    }

}

