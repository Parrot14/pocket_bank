package mx.parrot14.util.web.validators.ready;

import mx.parrot14.util.web.validators.Validator;

public class NumericRangeValidator implements Validator {
    Integer min, max;

    /**
    * Numeric validator with range, min(inclusive) and max(exclusive)
    */
    public NumericRangeValidator(Integer min, Integer max){
        this.min = min;
        this.max = max;
    }

    /**
     * Validates if the input is a natural number, if not
     * @return false
     * otherwise checks if the number is in the range of min(inclusive) and max(exclusive), if not
     * @return false
     * otherwise
     * @return true
     */
    @Override
    public boolean validate(String toValidate) {
        if (!toValidate.matches("^\\d+$"))
            return false;
        Integer number = Integer.valueOf(toValidate);

        return min <= number && number < max;
    }

}
