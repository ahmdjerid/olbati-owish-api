

package com.olbati.owish.config.elasticSearchConfiguration;

import com.olbati.owish.domain.WishInfo;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.NodeClientFactoryBean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 24/01/2017.
 **/


@Configuration
@EntityScan(basePackageClasses = WishInfo.class)
public class ElasticSearchConfiguration {


    @Autowired
    ElasticsearchOperations operations;

    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }

    @Bean
    public NodeClientFactoryBean client() {

        NodeClientFactoryBean bean = new NodeClientFactoryBean(true);
        bean.setClusterName("owish_elastic");
        bean.setEnableHttp(true);
        bean.setPathHome("target/pathHome");
        bean.setPathData("target/elasticsearchTestData");

        return bean;
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client client) throws Exception {
        return new ElasticsearchTemplate(client);
    }

    @PreDestroy
    public void deleteIndex() {
        operations.deleteIndex(WishInfo.class);
    }

    @PostConstruct
    public void insertDataSample() {


    }

}

