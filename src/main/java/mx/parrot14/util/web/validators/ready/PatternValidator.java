package mx.parrot14.util.web.validators.ready;

import mx.parrot14.util.web.validators.Validator;

public class PatternValidator implements Validator {
    private final String pattern;

    public PatternValidator(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean validate(String toValidate) {
        return toValidate.matches(this.pattern);
    }

}
