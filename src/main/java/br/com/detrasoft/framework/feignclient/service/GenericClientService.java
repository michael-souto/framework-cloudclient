package br.com.detrasoft.framework.feignclient.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.detrasoft.framework.core.controller.Response;
 
public interface GenericClientService<T> {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Response<T>> create(@RequestBody T object);
	
	@RequestMapping(value = "/create-list", method = RequestMethod.POST)
	public ResponseEntity<List<Response<T>>> createList(@RequestBody List<T> listEntity);

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<T>> update(@RequestBody T object);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<T>> findById(@PathVariable("id") Long id);

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<T>> delete(@PathVariable("id") Long id);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<T>>> findAll();
	
	@PostMapping(value = "/validate")
	public ResponseEntity<Response<T>> validate(@RequestBody T object);
}
