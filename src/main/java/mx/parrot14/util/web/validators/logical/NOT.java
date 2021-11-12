package mx.parrot14.util.web.validators.logical;

import mx.parrot14.util.web.validators.Validator;

public class NOT implements Validator{
    private final Validator validator;

    public NOT(Validator validator){
        this.validator = validator;
    }

    @Override
    public boolean validate(String toValidate) {
        return !validator.validate(toValidate);
    }
    
}
