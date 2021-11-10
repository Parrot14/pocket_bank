package mx.parrot14;

import io.javalin.Javalin;
import mx.parrot14.util.endpoints.DefaultEndpoints;

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

        web.routes(new DefaultEndpoints());

        web.start(port);
    }

    public static class URL {
        public static class WEB {
            public static final String 
                INDEX = "/";

            public static class ROOM {
                public static final String 
                    CREATE = "/room/create",
                    JOIN = "/room/join",
                    DATA = "/room/data",
                    DEBT = "/room/debt",
                    WAGE = "/room/wage",
                    PAY = "/room/pay",
                    LEAVE = "/room/leave";
            }
        }

        public static class Template {
            public static final String INDEX = "templates/index.peb";
        }
    }
}