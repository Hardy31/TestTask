package ru.test.task.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.test.task.entity.enums.TransactionType;

import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Getter
@Table(name="transactions", schema = "public")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "transfer_amount")
    private double transferAmount;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER )
    @JoinColumn(name = "debit_account_id", referencedColumnName = "id")
    private Account debitAccount;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "credit_account_id", referencedColumnName = "id")
    private Account creditAccount;
}
