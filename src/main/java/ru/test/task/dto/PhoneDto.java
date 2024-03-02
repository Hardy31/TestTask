package ru.test.task.dto;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PhoneDto {
    private Long id;
    private String phone;
    private ClientDto clientDto;
}
