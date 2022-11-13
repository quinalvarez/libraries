package com.jalv.libs.frame.controller;

import com.jalv.libs.frame.data.dao.GenericDAO;
import com.jalv.libs.frame.mapper.GenericMapper;
import com.jalv.libs.frame.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class BasicController<SVC extends BaseService<DAO, MAP, DTO, PK, ENT>, DAO extends GenericDAO<PK, ENT>,
        MAP extends GenericMapper<DTO, ENT>,
        DTO extends Serializable, PK, ENT> implements GenericController<PK, DTO, SVC> {

    protected SVC service;

    @Autowired
    public BasicController(SVC service) {
        this.service = service;
    }
}
