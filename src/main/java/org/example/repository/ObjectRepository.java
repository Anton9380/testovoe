package org.example.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ObjectRepository extends ReactiveCrudRepository<ObjectEntity, Long> {
}
