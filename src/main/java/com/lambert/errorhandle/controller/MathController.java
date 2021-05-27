package com.lambert.errorhandle.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lambert.errorhandle.exception.BusinessException;
import com.lambert.errorhandle.exception.InvalidArgumentsException;
import com.lambert.errorhandle.service.MathService;

@RestController
@RequestMapping(value = "/math")
public class MathController {

	@Autowired
	private MathService mathService;

	@GetMapping(path = "double-value/{value}")
	public ResponseEntity<Object> doubleValue(@PathVariable("value") Optional<Integer> value)
			throws BusinessException, InvalidArgumentsException {
		return new ResponseEntity<>(mathService.doubleValue(null), HttpStatus.OK);
	}
}
