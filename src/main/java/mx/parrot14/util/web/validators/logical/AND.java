package mx.parrot14.util.web.validators.logical;

import mx.parrot14.util.web.validators.Validator;

public class AND implements Validator {
    Validator[] validators;

    public AND(Validator... validators) {
        this.validators = validators;
    }

    @Override
    public boolean validate(String toValidate) {
        for (Validator validator : validators) {
            if (!validator.validate(toValidate))
                return false;
        }
        return true;
    }

}
