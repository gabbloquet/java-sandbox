package io.gabbloquet.sandbox.infrastructure.mongodb.repository;

import io.gabbloquet.sandbox.infrastructure.mongodb.dao.MongoUser;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

@Profile("nosql")
public interface MongoSpringDataUserRepository extends MongoRepository<MongoUser, String> {
}
