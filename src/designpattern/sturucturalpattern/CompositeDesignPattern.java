package designpattern.sturucturalpattern;

import java.util.ArrayList;
import java.util.List;

// in this example product and product bundle are tightly coupled and if user want to add in cart product
// it can only add one type
/*class Product{
    String name;
    int cost;
    void getName();
}

class ProductBundle{
    String bundleName;
    List<Product> products=new ArrayList<>();
    void addProduct(Product product){
        products.add(product);
    }
    void getName();
}*/

// so we make them a specific object
interface CartItem{
    void getName();
    double getPrice();
}

class Product implements CartItem{
    private final String name;
    private final double price;
    Product(String name, double price){
        this.name=name;
        this.price=price;
    }
    @Override
    public void getName() {
        System.out.println(name);
    }
    @Override
    public double getPrice() {
        return price;
    }
}

class ProductBundle implements CartItem{
    private final String bundleName;
    private final List<CartItem> products;

    ProductBundle(String bundleName){
        this.bundleName=bundleName;
        this.products=new ArrayList<CartItem>();
    }
    @Override
    public void getName() {
        System.out.println(bundleName);
    }

    void addItem(CartItem cartItem){
        products.add(cartItem);
    }
    @Override
    public double getPrice(){
        double total=0;
        for(CartItem cartItem:products){
            total+=cartItem.getPrice();
        }
        return total;
    }
}

public class CompositeDesignPattern {

    public static void main(String[] args) {
        CartItem p1=new Product("pencil",5);
        CartItem p2=new Product("box",20);
        ProductBundle pb=new ProductBundle("stationarySet");
        pb.addItem(p1);
        pb.addItem(p2);

        List<CartItem> cart=new ArrayList<>();
        cart.add(pb);
        cart.add(p1);

        System.out.println("Your total cart");
        double total=0;
        for(CartItem cartItem:cart){
            total+=cartItem.getPrice();
        }
        System.out.println("Total price: "+total);
    }
}
