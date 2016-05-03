package org.oursight.learning.jpa.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import org.oursight.learning.jpa.bo.User;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class AppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {



        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(YamlConfiguration.class);
        ctx.setServletContext(container);
        ctx.register(AppicationContextConfig.class);
        ctx.register(DataSourceConfiguration.class);
        //ctx.register(HibernateConfiguration.class);
        ctx.register(JpaConfiguration.class);


        ServletRegistration.Dynamic servlet = container.addServlet(
                "dispatcher", new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }

}
