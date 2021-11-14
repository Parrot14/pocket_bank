package mx.parrot14.util;

import mx.parrot14.util.web.FormParam;
import mx.parrot14.util.web.ready.JavalinForm;
import mx.parrot14.util.web.validators.logical.OR;
import mx.parrot14.util.web.validators.ready.EmptyValidator;
import mx.parrot14.util.web.validators.ready.NumericRangeValidator;
import mx.parrot14.util.web.validators.ready.PatternValidator;

public class Forms {
    private static final PatternValidator 
            nameValidator = new PatternValidator("^[0-9a-zA-z]$"),
            numberValidator = new PatternValidator("^\\d+$"),
            uuidValidator = new PatternValidator("^[0-9a-fA-F]{8}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{12}$"),
            roomValidator = new PatternValidator("^[a-zA-Z0-9]{5}$");

    public static final JavalinForm 
            ROOM_FORM = new JavalinForm(
                new FormParam("avatar", new NumericRangeValidator(0, 48)),
                new FormParam("name", nameValidator),
                new FormParam("room", new OR(roomValidator, new EmptyValidator()))
            ),
            PAY_FORM = new JavalinForm(
                new FormParam("from", nameValidator),
                new FormParam("to", nameValidator),
                new FormParam("quantity", numberValidator),
                new FormParam("transaction-uuid", uuidValidator),
                new FormParam("room", roomValidator)
            ),
            WAGE_FORM = new JavalinForm(
                new FormParam("to", nameValidator),
                new FormParam("quantity", numberValidator),
                new FormParam("transaction-uuid", uuidValidator),
                new FormParam("room", roomValidator)
            ),
            RENT_FORM = new JavalinForm(
                new FormParam("from", nameValidator),
                new FormParam("to", nameValidator),
                new FormParam("quantity", numberValidator),
                new FormParam("transaction-uuid", uuidValidator),
                new FormParam("room", roomValidator)
            ),
            TAX_FORM = new JavalinForm(
                new FormParam("from", nameValidator),
                new FormParam("quantity", numberValidator),
                new FormParam("transaction-uuid", new PatternValidator("")),
                new FormParam("room", roomValidator)
            );
}
