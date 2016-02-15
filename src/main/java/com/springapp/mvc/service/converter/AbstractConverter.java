package com.springapp.mvc.service.converter;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by o.lutsevich on 2.2.16.
 */
public abstract class AbstractConverter<TEntity, TForm> {
    @Autowired
    protected Mapper mapper;

    private final Class<TEntity> entityClass;
    private final Class<TForm> dtoClass;

    @SuppressWarnings("unchecked")
    protected AbstractConverter() {
        Type superclassType = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) superclassType;
        entityClass = (Class<TEntity>) parameterizedType.getActualTypeArguments()[0];
        dtoClass = (Class<TForm>) parameterizedType.getActualTypeArguments()[1];
    }

    public TEntity toEntity(TForm dto) {
        return dto != null ? mapper.map(dto, entityClass) : null;
    }

    public TForm toForm(TEntity entity) {
        return entity != null ? mapper.map(entity, dtoClass) : null;
    }


}
