package styleroom.com.styleroom.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import styleroom.com.styleroom.R;
import styleroom.com.styleroom.WebSocketClass;
import styleroom.com.styleroom.model.Product;
import styleroom.com.styleroom.model.Room;
import styleroom.com.styleroom.model.State;
import styleroom.com.styleroom.model.User;

/**
 * Created by neeraj.singh on 25/04/15.
 */
public enum Constants {
    instance;

    public static User user ;//neerajUser,nikhilUser,shiavamUser,anuragUser;

    public static List<Product> suggestedProducts,products;

    public static Product product = null;

    public static State state;
    public static Room room;

    public static boolean flag = true;

    public static HashMap<String,List<Product>> productMap;

//    public static String appType = "Flipkart";
    public static String appType = "Myntra";

    public static WebSocketClass webSocketClass;

    public static StringBuilder chatHistory = new StringBuilder();
    public void init() {

//        user = new User("Neeraj", true);
//        user = new User("Nikhil", true);

        user = new User("Shivam", true);
//        user = new User("Anurag", true
        ArrayList<User> users = new ArrayList<User>();
        users.add(user);
//        users.add(neerajUser);
//        users.add(nikhilUser);
//        users.add(shiavamUser);
//        users.add(anuragUser);

        suggestedProducts = new ArrayList<Product>();
        products = new ArrayList<Product>();


        state = new State(products,product,suggestedProducts,user);

        room= new Room("room", users, state );

        Product product1 = new Product("fkimage1","Flipkart",null,0);
        Product product2 = new Product("fkimage2","Flipkart",null,0);
        Product product3 = new Product("fkimage3","Flipkart",null,0);
        Product product4 = new Product("fkimage4","Flipkart",null,0);
        Product product5 = new Product("fkimage5","Flipkart",null,0);
        Product product6 = new Product("fkimage6","Flipkart",null,0);
        Product product7 = new Product("fkimage7","Flipkart",null,0);
        Product product8 = new Product("fkimage8","Flipkart",null,0);
        Product product9 = new Product("fkimage9","Flipkart",null,0);
        Product product10 = new Product("fkimage10","Flipkart",null,0);
        Product product11 = new Product("fkimage11","Flipkart",null,0);
        Product product12 = new Product("fkimage12","Flipkart",null,0);
        Product product13 = new Product("fkimage13","Flipkart",null,0);
        Product product14 = new Product("fkimage14","Flipkart",null,0);
        Product product15 = new Product("fkimage15","Flipkart",null,0);
        Product product16 = new Product("fkimage16","Flipkart",null,0);
        ArrayList<Product> flipkartList = new ArrayList<Product>();
        flipkartList.add(product1);
        flipkartList.add(product2);
        flipkartList.add(product3);
        flipkartList.add(product4);
        flipkartList.add(product5);
        flipkartList.add(product6);
        flipkartList.add(product7);
        flipkartList.add(product8);
        flipkartList.add(product9);
        flipkartList.add(product10);
        flipkartList.add(product11);
        flipkartList.add(product12);
        flipkartList.add(product13);
        flipkartList.add(product14);
        flipkartList.add(product15);
        flipkartList.add(product16);


        Product mnproduct1 = new Product("mnimage1","Myntra",null,0);
        Product mnproduct2 = new Product("mnimage2","Myntra",null,0);
        Product mnproduct3 = new Product("mnimage3","Myntra",null,0);
        Product mnproduct4 = new Product("mnimage4","Myntra",null,0);
        Product mnproduct5 = new Product("mnimage5","Myntra",null,0);
        Product mnproduct6 = new Product("mnimage6","Myntra",null,0);
        Product mnproduct7 = new Product("mnimage7","Myntra",null,0);
        Product mnproduct8 = new Product("mnimage8","Myntra",null,0);
        Product mnproduct9 = new Product("mnimage9","Myntra",null,0);
        Product mnproduct10 = new Product("mnimage10","Myntra",null,0);
        Product mnproduct11 = new Product("mnimage11","Myntra",null,0);
        Product mnproduct12 = new Product("mnimage12","Myntra",null,0);
        Product mnproduct13 = new Product("mnimage13","Myntra",null,0);
        Product mnproduct14 = new Product("mnimage14","Myntra",null,0);
        Product mnproduct15 = new Product("mnimage15","Myntra",null,0);
        Product mnproduct16 = new Product("mnimage16","Myntra",null,0);



//        Product product7 = new Product("mnimage1","Myntra",null,0);
//        Product product8 = new Product("mnimage2","Myntra",null,0);
//        Product product9 = new Product("mnimage3","Myntra",null,0);
//        Product product10 = new Product("mnimage4","Myntra",null,0);
//        Product product11 = new Product("mnimage5","Myntra",null,0);
//        Product product12 = new Product("mnimage6","Myntra",null,0);


        ArrayList<Product> myntraList = new ArrayList<Product>();
//        myntraList.add(product7);
//        myntraList.add(product8);
//        myntraList.add(product9);
//        myntraList.add(product10);
//        myntraList.add(product11);
//        myntraList.add(product12);


        myntraList.add(mnproduct1);
        myntraList.add(mnproduct2);
        myntraList.add(mnproduct3);
        myntraList.add(mnproduct4);
        myntraList.add(mnproduct5);
        myntraList.add(mnproduct6);
        myntraList.add(mnproduct7);
        myntraList.add(mnproduct8);
        myntraList.add(mnproduct9);
        myntraList.add(mnproduct10);
        myntraList.add(mnproduct11);
        myntraList.add(mnproduct12);
        myntraList.add(mnproduct13);
        myntraList.add(mnproduct14);
        myntraList.add(mnproduct15);
        myntraList.add(mnproduct16);


        productMap = new HashMap<String,List<Product>>();
        productMap.put("Flipkart",flipkartList);
        productMap.put("Myntra",myntraList);

    }

    public static String messageList = "";


}
