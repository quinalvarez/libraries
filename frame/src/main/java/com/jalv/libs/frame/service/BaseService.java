package com.jalv.libs.frame.service;

import com.jalv.libs.frame.data.dao.GenericDAO;
import com.jalv.libs.frame.exception.EntityValidationException;
import com.jalv.libs.frame.mapper.GenericMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Transactional
public class BaseService<DAO extends GenericDAO<PK, ENT>, MAP extends GenericMapper<DTO, ENT>,
        DTO extends Serializable, PK, ENT> implements GenericService<PK, DTO>{
    protected DAO dao;
    protected MAP mapper;

    public BaseService(DAO dao, MAP mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<DTO> getAll() {
        return this.mapper.toDTOS(this.dao.findAll());
    }

    @Override
    public Optional<DTO> get(PK id) {
        Optional<ENT> entity = this.dao.findById(id);
        return entity.map(this.mapper::toDTO);
    }

    public Optional<ENT> findById(PK id) {
        return this.dao.findById(id);
    }

    @Override
    public DTO save(DTO entity) {
        ENT ent = this.mapper.fromDTO(entity);

        try {
            return this.mapper.toDTO(this.dao.save(ent));
        } catch (DataIntegrityViolationException var3) {
            throw new EntityValidationException("has error");
        }
    }

    @Override
    public DTO update(DTO entity) {
        ENT ent = this.mapper.fromDTO(entity);

        try {
            return this.mapper.toDTO(this.dao.update(ent));
        } catch (DataIntegrityViolationException var3) {
            throw new EntityValidationException("has error");
        }
    }

    @Override
    public void delete(DTO entity) {
        try {
            this.dao.delete(this.mapper.fromDTO(entity));
        } catch (EmptyResultDataAccessException var3) {

        }
    }

    @Override
    public void deleteById(PK id) {
        try {
            this.dao.deleteById(id);
        } catch (EmptyResultDataAccessException var3) {

        }
    }
}
