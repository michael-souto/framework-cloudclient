package com.detrasoft.framework.cloudclient.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.detrasoft.framework.core.notification.TResponseNotification;

import java.util.UUID;

public interface GenericClientService<T> {

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TResponseNotification<T>> insert(@RequestBody T object);

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<TResponseNotification<T>> update(@PathVariable("id") UUID id, @RequestBody T object);

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TResponseNotification<T>> delete(@PathVariable("id") UUID id);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<T> findById(@PathVariable("id") UUID id);

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<T>> findAll(Pageable pageable);
}
