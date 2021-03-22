package tech.romashov.healthcheck;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckServer {
    @Value("${healthcheck.port}")
    private int port;

    public HealthCheckServer() throws Exception {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        if (port != 0) {
            connector.setPort(port);
        } else {
            connector.setPort(8081);
        }
        server.setConnectors(new Connector[] {connector});
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(HealthCheckServlet.class, "/");
        server.setHandler(context);
        server.start();
    }
}
