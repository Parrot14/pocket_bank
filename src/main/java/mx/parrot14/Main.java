package mx.parrot14;

import io.javalin.Javalin;
import mx.parrot14.util.Banks;
import mx.parrot14.util.endpoints.DefaultEndpoints;
import mx.parrot14.util.endpoints.RoomEndpoints;

public class Main {
    public static void main(String[] args) {
        startServer(8080);
    }

    private static void startServer(Integer port) {
        Javalin web = Javalin.create(config -> {
            config.enforceSsl = true;
            config.addStaticFiles(userConfig -> {
                userConfig.hostedPath = "/static";
                userConfig.directory = "/static";
            });
        });
        Banks manager = new Banks();

        web.routes(new DefaultEndpoints());
        web.routes(new RoomEndpoints(manager));

        web.start(port);
    }

    public static class URL {
        public static class WEB {
            public static final String INDEX = "/";

            public static class ROOM {
                public static final String 
                        CREATE_JOIN = "/room",
                        DATA = "/room/data", 
                        PAY = "/room/pay", 
                        WAGE = "/room/wage",
                        RENT = "/room/rent", 
                        TAX = "/room/tax", 
                        LEAVE = "/room/leave",
                        SSE = "/room/sse";
            }
        }

        public static class Template {
            public static final String INDEX = "templates/index.peb";
        }
    }
}