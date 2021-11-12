package mx.parrot14.util.endpoints;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.sse;

import io.javalin.apibuilder.EndpointGroup;
import mx.parrot14.Main.URL.Template;
import mx.parrot14.Main.URL.WEB;

public class DefaultEndpoints implements EndpointGroup {
    @Override
    public void addEndpoints() {
        get(WEB.INDEX, get -> {
            get.render(Template.INDEX);
        });
        sse("/sse", client -> {
            client.sendEvent("msg", "se you next time");

            client.ctx.status(204);
            client.ctx.req.getAsyncContext().complete();
        });
    }
}
