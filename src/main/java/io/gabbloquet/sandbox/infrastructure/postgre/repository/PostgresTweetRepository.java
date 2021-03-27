package io.gabbloquet.sandbox.infrastructure.postgre.repository;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.Tweet.interfaces.providers.TweetRepository;
import io.gabbloquet.sandbox.infrastructure.postgre.dao.PostgresTweet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class PostgresTweetRepository implements TweetRepository {

    private PostgresSpringDataTweetRepository postgresSpringDataTweetRepository;

    @Override
    public Tweet save(Tweet tweet) {
        return postgresSpringDataTweetRepository.save(PostgresTweet.fromTweet(tweet)).toTweet();
    }

    @Override
    public List<Tweet> findAll() {
        return postgresSpringDataTweetRepository.findAll()
            .stream()
            .map(PostgresTweet::toTweet)
            .collect(Collectors.toList());
    }

//    @Override
//    public Customer save(Customer customer) {
//        return postgresSpringDataCustomerRepository.save(PostgresCustomer.fromCustomer(customer)).toCustomer();
//    }
//
//    @Override
//    public Option<Customer> findById(UUID id) {
//        return ofOptional(postgresSpringDataCustomerRepository.findById(id).map(PostgresCustomer::toCustomer));
//    }
//
//    @Override
//    public Option<Customer> findByLogin(String login) {
//        return ofOptional(postgresSpringDataCustomerRepository.findByName(login).map(PostgresCustomer::toCustomer));
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        return ofAll(postgresSpringDataCustomerRepository.findAll()).map(PostgresCustomer::toCustomer);
//    }
}