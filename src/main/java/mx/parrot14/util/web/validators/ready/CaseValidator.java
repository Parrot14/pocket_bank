package mx.parrot14.util.web.validators.ready;

import mx.parrot14.util.web.validators.Validator;

public class CaseValidator implements Validator {
  private final String[] validGroup;

  public CaseValidator(String... validGroup) {
    this.validGroup = validGroup;
  }

  @Override
  public boolean validate(String toValidate) {
    for (String valid : this.validGroup) {
      if (valid.equalsIgnoreCase(toValidate))
        return true;
    }
    return false;
  }

}
