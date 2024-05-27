package org.example.electradrivebackend.repository.customerrepo;

import org.example.electradrivebackend.model.customermodel.IdempotencyKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdempotencyKeyRepository extends JpaRepository<IdempotencyKey, String> {
}
