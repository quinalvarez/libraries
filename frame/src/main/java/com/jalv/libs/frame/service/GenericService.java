package com.jalv.libs.frame.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface GenericService<PK, DTO> {

    List<DTO> getAll();
    Optional<DTO> get(PK id);
    DTO save(DTO entity);
    DTO update(DTO entity);
    void delete(DTO entity);
    void deleteById(PK id);
}
