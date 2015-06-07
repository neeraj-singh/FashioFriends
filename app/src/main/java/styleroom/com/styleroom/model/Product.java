package styleroom.com.styleroom.model;

import java.io.Serializable;

/**
 * Created by neeraj.singh on 25/04/15.
 */
public class Product implements Serializable {
//    int imageId;
    String imageId;
    int likes;
    int disLiks;

    String provider;
    User suggestedBy;
    int rank;

    public Product(String imageId, String provider, User suggestedBy, int rank) {
        this.imageId = imageId;
        this.provider = provider;
        this.suggestedBy = suggestedBy;
        this.rank = rank;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public User getSuggestedBy() {
        return suggestedBy;
    }

    public void setSuggestedBy(User suggestedBy) {
        this.suggestedBy = suggestedBy;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

//    public int getImageId() {
//        return imageId;
//    }
//
//    public void setImageId(int imageId) {
//        this.imageId = imageId;
//    }


    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDisLiks() {
        return disLiks;
    }

    public void setDisLiks(int disLiks) {
        this.disLiks = disLiks;
    }
}
