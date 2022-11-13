package com.jalv.libs.frame.controller;

import com.jalv.libs.frame.data.dao.GenericDAO;
import com.jalv.libs.frame.mapper.GenericMapper;
import com.jalv.libs.frame.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public class BaseController<SVC extends BaseService<DAO, MAP, DTO, PK, ENT>, DAO extends GenericDAO<PK, ENT>,
        MAP extends GenericMapper<DTO, ENT>, DTO extends Serializable, PK, ENT>
        extends BasicController<SVC, DAO, MAP, DTO, PK, ENT>{

    public BaseController(SVC service) {
        super(service);
    }

    @GetMapping
    public ResponseEntity<List<DTO>> getAll() {
        return this.getAll(this.service);
    }

    @GetMapping("{id}")
    public ResponseEntity<DTO> get(@PathVariable PK id) {
        return this.get(this.service, id);
    }

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody DTO entity) {
        return this.save(this.service, entity);
    }

    @PutMapping
    public ResponseEntity<DTO> update(@RequestBody DTO entity) {
        return this.update(this.service, entity);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable PK id) {
        this.deleteById(this.service, id);
    }

    @DeleteMapping
    public void delete(@RequestBody DTO dto) {
        this.delete(this.service, dto);
    }
}
