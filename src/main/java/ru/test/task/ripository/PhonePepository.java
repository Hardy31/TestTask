package ru.test.task.ripository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.task.entity.Phone;

@Repository
public interface PhonePepository extends JpaRepository<Phone,Long> {
}
