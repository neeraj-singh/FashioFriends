package styleroom.com.styleroom.model;

import java.io.Serializable;

import styleroom.com.styleroom.model.Product;

/**
 * Created by neeraj.singh on 25/04/15.
 */
public class ScreenState implements Serializable {
    String from;
    String site;
    Product productinfo;
    int imageNumber;

//    public ScreenState(String from, String site, Product productinfo, int imageNumber) {
//        this.from = from;
//        this.site = site;
//        this.productinfo = productinfo;
//        this.imageNumber = imageNumber;
//    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Product getProductinfo() {
        return productinfo;
    }

    public void setProductinfo(Product productinfo) {
        this.productinfo = productinfo;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }
}
