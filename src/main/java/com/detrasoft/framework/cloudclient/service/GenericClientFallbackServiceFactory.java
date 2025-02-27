package com.detrasoft.framework.cloudclient.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.detrasoft.framework.core.notification.TResponseNotification;

import java.util.UUID;

public class GenericClientFallbackServiceFactory<T> implements GenericClientService<T> {
    @Override
    public ResponseEntity<TResponseNotification<T>> insert(T object) {
        return null;
    }

    @Override
    public ResponseEntity<TResponseNotification<T>> update(UUID id, T object) {
        return null;
    }

    @Override
    public ResponseEntity<TResponseNotification<T>> delete(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<T> findById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<T>> findAll(Pageable pageable) {
        return null;
    }
}
