package tech.romashov.ash.application.bot.healthcheck;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckServer {
    public HealthCheckServer() throws Exception {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        if (System.getenv("PORT").equals("") || System.getenv("PORT").equals(null)) {
            connector.setPort(8081);
        } else {
            connector.setPort(Integer.valueOf(System.getenv("PORT")));
        }
        server.setConnectors(new Connector[] {connector});
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(HealthCheckServlet.class, "/");
        server.setHandler(context);
        server.start();
    }
}
