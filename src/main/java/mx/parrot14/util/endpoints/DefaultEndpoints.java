package mx.parrot14.util.endpoints;

import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.get;
import static mx.parrot14.Main.URL.Template;
import static mx.parrot14.Main.URL.WEB;

public class DefaultEndpoints implements EndpointGroup{
    @Override
    public void addEndpoints() {
        get(WEB.INDEX, get->{
            get.render(Template.INDEX);
        });
    }
}

