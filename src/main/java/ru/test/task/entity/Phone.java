package ru.test.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="phones", schema = "public")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name="phone", unique=true)
    private String phone;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable=false )
    private Client client;

    public Client getClients() {
        return client;
    }

    public void setClients(Client client) {
        this.client = client;
    }
}
