package ru.test.task.ripository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.task.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
