package com.lambert.errorhandle.service;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.lambert.errorhandle.exception.BusinessException;
import com.lambert.errorhandle.exception.InvalidArgumentsException;
import com.lambert.errorhandle.service.impl.MathServiceImpl;

public class MathServiceTest extends MathServiceImpl {

	@Test
	public void testWithValidParam() {
		try {
			final int testValue = 10;
			int result = doubleValue(Optional.of(testValue));
			assertSame(result, testValue * 2);
		} catch (BusinessException | InvalidArgumentsException e) {
			fail("Method is broken!");
		}
	}

	@Test
	public void testWithNullValue() {
		assertThatExceptionOfType(InvalidArgumentsException.class).isThrownBy(() -> doubleValue(null))
				.withMessage("Empty value!");
	}
}
