package com.jalv.libs.frame.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class BaseMapper<DTO extends Serializable, DOM> implements GenericMapper<DTO, DOM>{

    private Class<DTO> dtoClass;
    private Class<DOM> domainClass;
    private ObjectMapper mapper;

    public BaseMapper() {
        Class<?>[] arguments = GenericTypeResolver.resolveTypeArguments(this.getClass(), BaseMapper.class);
        if(Objects.nonNull(arguments) && arguments.length > 0) {
            this.dtoClass = (Class<DTO>) arguments[0];
            this.domainClass = (Class<DOM>) arguments[1];
        }
    }

    @Override
    public DTO toDTO(DOM entity) {
        return this.mapper.convertValue(entity, this.dtoClass);
    }

    @Override
    public DOM fromDTO(DTO entity) {
        return this.mapper.convertValue(entity, this.domainClass);
    }

    @Override
    public List<DTO> toDTOS(List<DOM> entities) {
        List<DTO> mapped = new ArrayList<>();
        Iterator var3 = entities.iterator();

        while(var3.hasNext()) {
            DOM entity = (DOM) var3.next();
            mapped.add(this.toDTO(entity));
        }

        return mapped;
    }

    @Override
    public List<DOM> fromDTOS(List<DTO> entities) {
        List<DOM> mapped = new ArrayList<>();
        Iterator var3 = entities.iterator();

        while(var3.hasNext()) {
            DTO entity = (DTO) var3.next();
            mapped.add(this.fromDTO(entity));
        }

        return mapped;
    }

    @Override
    public DTO fromString(String serialized) {
        try {
            return (DTO) this.mapper.readValue(serialized, this.dtoClass);
        } catch (IOException var3) {
            return null;
        }
    }

    @Autowired
    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }
}
