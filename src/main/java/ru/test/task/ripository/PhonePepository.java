package ru.test.task.ripository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.task.entity.Client;
import ru.test.task.entity.Email;
import ru.test.task.entity.Phone;

import java.util.List;

@Repository
public interface PhonePepository extends JpaRepository<Phone,Long> {
    List<Phone> findAllByClient(Client client);
    Phone findByPhone(String phone);
}
