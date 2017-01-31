package com.olbati.owish.Service.serviceImpl;

import com.google.common.collect.Lists;
import com.olbati.owish.Service.WishService;
import com.olbati.owish.domain.Wish;
import com.olbati.owish.domain.WishInfo;
import com.olbati.owish.event.WishEvent;
import com.olbati.owish.repository.elasticsearch.WishSearchRepository;
import com.olbati.owish.repository.jpa.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 27/01/2017.
 */
@Service
public class WishServiceImpl implements WishService, ApplicationEventPublisherAware {

    @Autowired
    WishSearchRepository wishSearchRepository;

    @Autowired
    WishRepository wishRepository;

    private ApplicationEventPublisher publisher;

    @Override
    public Wish addWish(Wish wish) {
        publisher.publishEvent(new WishEvent(this, wish));
        return wishRepository.save(wish);


    }


    @Override
    public WishInfo addWishInfo(WishInfo wish) {
        return wishSearchRepository.save(wish);
    }

    @Override
    public List<WishInfo> finAllWishes() {
        Iterable<WishInfo> wishes = wishSearchRepository.findAll(new Sort(Sort.Direction.ASC, "createdTimeStamp"));
        return Lists.newArrayList(wishes);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}
