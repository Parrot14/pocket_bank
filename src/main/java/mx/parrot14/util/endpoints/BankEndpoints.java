package mx.parrot14.util.endpoints;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.sse;

import io.javalin.apibuilder.EndpointGroup;
import mx.parrot14.Main.URL.Template;
import mx.parrot14.Main.URL.WEB;

public class BankEndpoints implements EndpointGroup {

    @Override
    public void addEndpoints() {
        get(WEB.ROOM.DATA, get -> {

        });
    }

}
