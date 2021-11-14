package mx.parrot14.util.endpoints;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.sse;

import io.javalin.apibuilder.EndpointGroup;
import mx.parrot14.Main.URL.WEB;
import mx.parrot14.util.Banks;

public class BankEndpoints implements EndpointGroup {
    private final Banks banks;

    public BankEndpoints(Banks banks){
        this.banks = banks;
    }

    @Override
    public void addEndpoints() {
        sse("/sse", client -> {
            client.sendEvent("msg", "se you next time");

            client.ctx.status(204);
            client.ctx.req.getAsyncContext().complete();
        });
    }

}
