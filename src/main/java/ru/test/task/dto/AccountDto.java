package ru.test.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import ru.test.task.entity.Client;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class AccountDto {
    private Long id;
    private String name;
    private double balance;
    private ClientDto clientDto;
}
