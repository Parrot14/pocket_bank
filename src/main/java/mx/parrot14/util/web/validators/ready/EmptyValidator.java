package mx.parrot14.util.web.validators.ready;

import mx.parrot14.util.web.validators.Validator;

public class EmptyValidator implements Validator {

    @Override
    public boolean validate(String toValidate) {
        return toValidate.trim().isEmpty();
    }

}
