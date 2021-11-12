package mx.parrot14.util.web;

import mx.parrot14.util.web.validators.Validator;

public class FormParam {
    private final String id;
    private final Validator validator;

    public FormParam(String id, Validator validator) {
        this.id = id;
        this.validator = validator;
    }

    public String getId() {
        return id;
    }

    public boolean validate(String toValidate) {
        return toValidate != null && validator.validate(toValidate);
    }
}
