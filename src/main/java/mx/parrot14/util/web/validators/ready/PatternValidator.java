package mx.parrot14.util.web.validators.ready;

import mx.parrot14.util.web.validators.Validator;

public class PatternValidator implements Validator {
    private final String pattern;

    /**
     * Validator that uses {@link java.lang.String#matches(String)}
     * to verify values
     * @param pattern Regex pattern
     * @see java.util.regex.Pattern
     */
    public PatternValidator(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Applies {@link java.lang.String#matches(String)} to the given
     * String and returns the result
     * @param toValidate value to verify using regex
     * @return {@code boolean} result of matches
     * @see java.util.regex.Pattern
     */
    @Override
    public boolean validate(String toValidate) {
        return toValidate.matches(this.pattern);
    }

}
