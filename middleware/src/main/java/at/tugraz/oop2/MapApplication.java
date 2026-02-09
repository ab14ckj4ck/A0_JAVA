package at.tugraz.oop2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MapApplication {
    public static int DEFAULT_PORT = 8010;
    public static String DEFAULT_BACKEND_TARGET = "localhost:8020";

    public static void main(String[] args) {
        String port_env = System.getenv("JMAP_MIDDLEWARE_PORT");
        int port = DEFAULT_PORT;

        try {
            if (port_env != null) {
                port = Integer.parseInt(port_env);
                if (port < 0 || port >= 65535) {
                    throw new IllegalArgumentException("Port out of Range");
                }
            }
        } catch (IllegalArgumentException ex) {
            port = DEFAULT_PORT;
        }

        String backend_target = System.getenv("JMAP_BACKEND_TARGET_PORT");
        if (backend_target == null) {
            backend_target = DEFAULT_BACKEND_TARGET;
        }
        MapLogger.middlewareStartup(port, backend_target);

        new SpringApplicationBuilder(MapApplication.class).properties("server.port=" + port).run(args);

    }
}