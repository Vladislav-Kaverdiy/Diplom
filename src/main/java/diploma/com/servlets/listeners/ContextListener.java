package diploma.com.servlets.listeners;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by Student on 09.12.2017./
 */
public class ContextListener implements ServletContextListener {
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        try {
            initLocales(servletContext);
        } catch (IOException e) {
            LOG.error("Cannot configure locales" + e.toString());
        }
    }

    private void initLocales(ServletContext servletContext) throws IOException {

        String localesFileRealPath = servletContext
                .getRealPath("/WEB-INF/locales.properties");
        Properties locales = new Properties();
        FileInputStream stream = new FileInputStream(localesFileRealPath);
        try {
            locales.load(stream);
        } catch (Exception ex) {
            LOG.error("Cannot configure locales" + ex.toString());
        } finally {
            stream.close();
        }
        servletContext.setAttribute("locales", locales);
        locales.list(System.out);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
