package com.olbati.owish.event;

import com.olbati.owish.Service.WishService;
import com.olbati.owish.domain.WishInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.socket.WebSocketHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 27/01/2017.
 */
@Component
public class WishEventProcessor implements ApplicationListener<WishEvent> {

    @Autowired
    WishService wishService;

    @Autowired
    WebSocketHandler webSocketHandler;

    @Override
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onApplicationEvent(WishEvent wishEvent) {
        WishInfo wishInfo = new WishInfo(wishEvent.getWish().getWishName(), new Date());
        wishService.addWishInfo(wishInfo);


    }

}
