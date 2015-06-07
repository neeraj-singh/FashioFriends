package styleroom.com.styleroom.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by neeraj.singh on 25/04/15.
 */
public class State implements Serializable{
    List<Product> products;
    Product activeProduct;
    List<Product> suggestedProducts;
    User user ;

    public State(List<Product> products, Product activeProduct, List<Product> suggestedProducts,User user) {
        this.products = products;
        this.activeProduct = activeProduct;
        this.suggestedProducts = suggestedProducts;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getActiveProduct() {
        return activeProduct;
    }

    public void setActiveProduct(Product activeProduct) {
        this.activeProduct = activeProduct;
    }

    public List<Product> getSuggestedProducts() {
        return suggestedProducts;
    }

    public void setSuggestedProducts(List<Product> suggestedProducts) {
        this.suggestedProducts = suggestedProducts;
    }
}
