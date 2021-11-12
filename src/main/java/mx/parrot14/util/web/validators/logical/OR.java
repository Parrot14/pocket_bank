package mx.parrot14.util.web.validators.logical;

import mx.parrot14.util.web.validators.Validator;

public class OR implements Validator{
    Validator[] validators;

    public OR(Validator... validators){
        this.validators = validators;
    }

    @Override
    public boolean validate(String toValidate) {
        for (Validator validator : validators) {
            if (validator.validate(toValidate))
                return true;
        }
        return false;
    }
    
}
