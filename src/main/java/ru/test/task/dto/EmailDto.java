package ru.test.task.dto;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmailDto {
    private Long id;
    private String email;
    private ClientDto clientDto;

}
