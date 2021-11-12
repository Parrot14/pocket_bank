package mx.parrot14.util.web.extractors.ready;

import io.javalin.http.Context;
import mx.parrot14.util.web.extractors.Extractor;

public class JavalinExtractor implements Extractor<Context> {

    @Override
    public Integer getFormSize(Context ctx) {
        if (ctx.isMultipart())
            return -1;
        return ctx.formParamMap().size();
    }

    @Override
    public String extractParamData(Context ctx, String id) {
        if (!ctx.formParamMap().containsKey(id))
            return null;
        return ctx.formParamMap().get(id).get(0);
    }
}
