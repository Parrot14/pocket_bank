package mx.parrot14.util.web.ready;

import io.javalin.http.Context;
import mx.parrot14.util.web.Form;
import mx.parrot14.util.web.FormParam;
import mx.parrot14.util.web.extractors.ready.JavalinExtractor;

public class JavalinForm extends Form<Context>{
    private static final JavalinExtractor EXTRACTOR = new JavalinExtractor();
    
    public JavalinForm(FormParam... params){
        super(EXTRACTOR, params);
    }
}
