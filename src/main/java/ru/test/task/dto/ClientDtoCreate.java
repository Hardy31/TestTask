package ru.test.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
public class ClientDtoCreate {

    private String firstName;
    private String lastName;
    private String fatherName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    private Timestamp birthday;
    private List<PhoneDto> phoneDtoList;
    private List<EmailDto> emailDtoList;
}
