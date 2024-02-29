package ru.test.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class ClientDtoCreate {

    private String firstName;
    private String lastName;
    private String fatherName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    private LocalDateTime birthday;
    private List<PhoneDto> phoneList;
    private List<EmailDto> emailList;
}
