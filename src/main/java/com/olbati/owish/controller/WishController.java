package com.olbati.owish.controller;

import com.olbati.owish.Service.WishService;
import com.olbati.owish.domain.Wish;
import com.olbati.owish.domain.WishInfo;
import com.olbati.owish.util.WishResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 27/01/2017.
 */
@Controller()
@RequestMapping("/api")

public class WishController {

    @Autowired
    WishService wishService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public HttpEntity<Wish> SaveWish(@RequestBody Wish wish) {
        Wish createdWish = wishService.addWish(wish);
        return new ResponseEntity<>(createdWish, HttpStatus.OK);

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public HttpEntity<?> getAllWishes() {
        List<WishInfo> wishes = wishService.finAllWishes();
        wishes.forEach((w -> System.out.println(w.getWishName() + "" + w.getCreatedTimeStamp())));
        return new ResponseEntity<>(new WishResponse(wishes), HttpStatus.OK);

    }


}
