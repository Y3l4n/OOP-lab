public class Aims {
    public static void main(String[] args) throws Exception {

        // Create new disks
        DigitalVideoDisc disc1 = new DigitalVideoDisc("Famous", "Handsome", "Lee Min HO", 100, 12.00);
        DigitalVideoDisc disc2 = new DigitalVideoDisc("Actor", "Muscle", 300.00);

        // Create a new cart
        Cart cart1 = new Cart();
        cart1.addDigitalVideoDisc(disc1);
        cart1.addDigitalVideoDisc(disc2);


        // Test cart function
        System.out.println("Quantity of discs in cart: " + cart1.getQtyOrdered());
        cart1.displayCart();
        cart1.removeDigitalVideoDisc(disc1);
        System.out.println("Quantity of discs in cart: " + cart1.getQtyOrdered());
        cart1.displayCart();
        System.out.println("Total cost: " + cart1.totalCost() + "$");
    }
}