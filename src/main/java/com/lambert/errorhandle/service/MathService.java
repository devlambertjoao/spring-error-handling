package com.lambert.errorhandle.service;

import java.util.Optional;

import com.lambert.errorhandle.exception.BusinessException;
import com.lambert.errorhandle.exception.InvalidArgumentsException;

public interface MathService {
	int doubleValue(Optional<Integer> value) throws BusinessException, InvalidArgumentsException;
}
