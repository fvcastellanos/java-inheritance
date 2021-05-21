package edu.umg.java.ui.helper;

import io.vavr.control.Either;
import io.vavr.control.Try;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumericInputHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumericInputHelper.class);

    private NumericInputHelper() {

    }

    public static Either<String, Double> convertNumber(final String value) {

        if (StringUtils.isBlank(value)) {

            LOGGER.error("empty value");
            return Either.left("Empty value");
        }

        return Try.of(() -> Double.parseDouble(value))
                .onFailure(ex -> LOGGER.error("can't convert to double - ", ex))
                .toEither()
                .mapLeft(ex -> "Invalid numeric value");
    }
}
