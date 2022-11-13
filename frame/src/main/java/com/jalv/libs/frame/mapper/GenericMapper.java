package com.jalv.libs.frame.mapper;

import java.io.Serializable;
import java.util.List;

public interface GenericMapper<T extends Serializable, D> {

    T toDTO(D entity);
    D fromDTO(T entity);
    List<T> toDTOS(List<D> entities);
    List<D> fromDTOS(List<T> entities);
    T fromString(String serialized);
}
