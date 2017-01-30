package com.olbati.owish.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 18/01/2017.
 *         TODO Remove redundancy
 */
@Document(indexName = "olbati", type = "wish-info", replicas = 0)
public class WishInfo {


    @Id
    @GeneratedValue
    private String id;

    @Field(type = FieldType.String)
    private String wishName;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss")
    @Field(type = FieldType.Date,pattern ="yyyy-MM-dd'T'HH:mm:ss" )
    private Date createdTimeStamp;

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

    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public WishInfo(String wishName, Date createdTimeStamp) {
        this.wishName = wishName;
        this.createdTimeStamp = createdTimeStamp;
    }
}
