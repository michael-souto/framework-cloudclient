package com.detrasoft.framework.cloudclient.service;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

public interface GenericClientService<T> {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<T> insert(@RequestBody T object);

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<T> update(@RequestBody T object);

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<T> delete(@PathVariable("id") UUID id);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<T> findById(@PathVariable("id") UUID id);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<PagedModel<T>> findAll(Pageable pageable);
}
