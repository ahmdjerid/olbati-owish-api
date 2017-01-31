
package com.olbati.owish.repository.elasticsearch;

import com.olbati.owish.domain.WishInfo;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 24/01/2017.
 */


public interface WishSearchRepository extends ElasticsearchRepository<WishInfo, String> {


}

