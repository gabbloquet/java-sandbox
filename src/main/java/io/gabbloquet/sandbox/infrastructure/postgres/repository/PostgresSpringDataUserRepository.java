package io.gabbloquet.sandbox.infrastructure.postgres.repository;

import io.gabbloquet.sandbox.infrastructure.postgres.dao.PostgresUser;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Profile("sql")
public interface PostgresSpringDataUserRepository extends JpaRepository<PostgresUser, UUID> {

}
