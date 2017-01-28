package com.olbati.owish.event;

import com.olbati.owish.Service.WishService;
import com.olbati.owish.domain.WishInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 27/01/2017.
 */
@Component
public class WishEventProcessor implements ApplicationListener<WishEvent> {

    @Autowired
    WishService wishService;

    @Override
    public void onApplicationEvent(WishEvent wishEvent) {
        WishInfo wishInfo = new WishInfo(wishEvent.getWish().getWishName());
        System.out.println(wishService.addWishInfo(wishInfo));
    }
}
