package ru.test.task.ripository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.test.task.entity.Client;
import ru.test.task.entity.Email;

import java.util.List;

@Repository

public interface EmailRepository extends CrudRepository<Email, Long>,JpaRepository<Email,Long> {
//
    List<Email> findAllByClient(Client client);
    Email findByEmail(String name);
}
