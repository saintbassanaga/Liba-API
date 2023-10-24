package tech.saintbassanaga.authapi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.saintbassanaga.authapi.models.User;

import java.util.Optional;
import java.util.UUID;

@Transactional(readOnly = true)
@Repository
public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User>
{
    Optional<User> findByEmail(String email);
}