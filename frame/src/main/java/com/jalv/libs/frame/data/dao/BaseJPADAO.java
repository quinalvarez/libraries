package com.jalv.libs.frame.data.dao;

import com.jalv.libs.frame.data.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class BaseJPADAO<REP extends GenericRepository<PK, ENT>, PK, ENT> implements GenericDAO<PK, ENT>{

    private REP repository;

    @Autowired
    public BaseJPADAO(REP repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ENT> findById(PK id) {
        return this.repository.findById(id);
    }

    @Override
    public List<ENT> findAll() {
        return this.repository.findAll();
    }

    @Override
    public ENT update(ENT entity) {
        return this.repository.save(entity);
    }

    @Override
    public ENT save(ENT entity) {
        return this.repository.save(entity);
    }

    @Override
    public void delete(ENT entity) {
        this.repository.delete(entity);
    }

    @Override
    public void deleteById(PK id) {
        this.repository.deleteById(id);
    }
}
