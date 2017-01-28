package com.olbati.owish.domain;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 18/01/2017.
 */
@Document(indexName = "olbati", type = "wish-info", replicas = 0)
public class WishInfo {


    @Id
    @GeneratedValue
    private String id;

    @Field(type = FieldType.String)
    private String wishName;

    public String getWishName() {
        return wishName;
    }

    public void setWishName(String wishName) {
        this.wishName = wishName;
    }


    public WishInfo(String wishName) {
        this.wishName = wishName;
    }

    public WishInfo(long id, String wishName) {
        this.wishName = wishName;
    }

    public WishInfo() {
    }


}
