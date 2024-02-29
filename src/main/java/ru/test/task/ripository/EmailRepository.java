package ru.test.task.ripository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.task.entity.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email,Long> {

}
