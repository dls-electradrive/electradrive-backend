package org.example.electradrivebackend.model.customermodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "idempotency_key", schema = "electradrive")
@Entity
public class IdempotencyKey {

    @Id
    @Column(name = "`key`")
    private String key;

    private LocalDateTime createdAt;

    public IdempotencyKey() {
    }

    public IdempotencyKey(String key, LocalDateTime createdAt) {
        this.key = key;
        this.createdAt = createdAt;
    }

}
