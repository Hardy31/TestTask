package ru.test.task.ripository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.test.task.entity.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
//    @Query("SELECT * FROM client c LEFT JOIN phone p on c.id=p.client_id")
//    Optional<Client> findClientFullById ();

    @Override
    Optional<Client> findById(Long aLong);
}
