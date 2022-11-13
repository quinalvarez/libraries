package com.jalv.libs.frame.controller;

import com.jalv.libs.frame.service.GenericService;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

public interface GenericController<PK, DTO, SVC extends GenericService<PK, DTO>> {

    default ResponseEntity<List<DTO>> getAll(SVC service) {
        return ResponseEntity.ok(service.getAll());
    }

    default ResponseEntity<DTO> get(SVC service, PK id) {
        return ResponseEntity.ok(service.get(id).get());
    }

    default ResponseEntity<DTO> save(SVC service, DTO entity) {
        DTO dto = service.save(entity);
        return Objects.nonNull(dto) ? ResponseEntity.ok(dto) : ResponseEntity.badRequest().build();
    }

    default ResponseEntity<DTO> update(SVC service, DTO entity) {
        DTO dto = service.update(entity);
        return Objects.nonNull(dto) ? ResponseEntity.ok(dto) : ResponseEntity.badRequest().build();
    }

    default void delete(SVC service, DTO entity) {
        service.delete(entity);
    }

    default void deleteById(SVC service, PK id) {
        service.deleteById(id);
    }
}
