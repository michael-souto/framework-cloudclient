package br.com.detrasoft.framework.cloudclient.service;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;

public class GenericClientFallbackServiceFactory<T> implements GenericClientService<T> {
    @Override
    public ResponseEntity<T> insert(T object) {
        return null;
    }

    @Override
    public ResponseEntity<T> update(T object) {
        return null;
    }

    @Override
    public ResponseEntity<T> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<T> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PagedModel<T>> findAll(Pageable pageable) {
        return null;
    }
}
