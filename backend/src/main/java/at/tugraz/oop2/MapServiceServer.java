package at.tugraz.oop2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.File;

@SpringBootApplication
public class MapServiceServer {
    private static int DEFAULT_BACKEND_PORT = 8020;
    private static String DEFAULT_OSM_FILE = "data/styria_reduced.osm";

    public static void main(String[] args) {
        String port_env = System.getenv("JMAP_BACKEND_PORT");
        int port = DEFAULT_BACKEND_PORT;

        try {
            if (port_env != null) {
                port = Integer.parseInt(port_env);
                if (port < 0 || port >= 65535) {
                    throw new IllegalArgumentException("Port out of range!");
                }
            }
        } catch (IllegalArgumentException ex) {
            port = DEFAULT_BACKEND_PORT;
        }

        String osm_file = System.getenv("JMAP_BACKEND_OSMFILE");
        if (osm_file == null) {
            osm_file = DEFAULT_OSM_FILE;
        }

/*        File file = new File(osm_file);
        if (!file.exists()) {
            System.exit(1);
        }*/

        MapLogger.backendStartup(port, osm_file);

        new SpringApplicationBuilder(MapServiceServer.class).properties("server.port=" + port).run(args);
    }
}
