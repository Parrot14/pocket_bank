package mx.parrot14.util.web;

import mx.parrot14.util.web.extractors.Extractor;

public abstract class Form<T> {
    private final Extractor<T> extractor;
    private final FormParam[] params;

    public Form(Extractor<T> extractor, FormParam... params) {
        this.extractor = extractor;
        this.params = params;
    }

    public boolean verifyForm(T toExtract) {
        Integer formSize = extractor.getFormSize(toExtract);
        if (formSize == -1 || formSize != params.length)
            return false;
        for (FormParam param : params) {
            String toValidate = extractor.extractParamData(toExtract, param.getId());
            if (param.validate(toValidate))
                return false;
        }
        return true;
    }
}
