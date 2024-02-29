package ru.test.task.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhoneDto {
    private Long id;
    private String phone;
    private ClientDto clientDto;
}
