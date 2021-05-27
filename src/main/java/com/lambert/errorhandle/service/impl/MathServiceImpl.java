package com.lambert.errorhandle.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lambert.errorhandle.exception.BusinessException;
import com.lambert.errorhandle.exception.InvalidArgumentsException;
import com.lambert.errorhandle.service.MathService;

@Service
public class MathServiceImpl implements MathService {

	@Override
	public int doubleValue(Optional<Integer> value) throws BusinessException, InvalidArgumentsException {
		checkIfValueIsPresent(value);
		checkIfIsValidValue(value);
		return getValueDoubled(value.get());
	}

	protected void checkIfValueIsPresent(Optional<Integer> value) throws InvalidArgumentsException {
		if(value == null || value.isEmpty()) {
			throw new InvalidArgumentsException("Empty value!");
		}
	}

	protected void checkIfIsValidValue(Optional<Integer> value) throws BusinessException {
		if(value.get().equals(0)) {
			throw new BusinessException("Value cannot be equals 0");
		}
	}
	
	protected int getValueDoubled(int value) {
		return value * 2;
	}
}
