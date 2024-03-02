package ru.test.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="emails", schema = "public")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name="email", unique=true )
    private String email;

    @ManyToOne( optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable=false )
    private Client client;

    public Client getClients() {
        return client;
    }

    public void setClients(Client client) {
        this.client = client;
    }
}
