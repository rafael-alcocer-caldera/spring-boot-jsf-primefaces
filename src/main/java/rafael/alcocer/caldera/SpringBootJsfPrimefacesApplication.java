/**
 * Copyright [2017] [RAFAEL ALCOCER CALDERA]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rafael.alcocer.caldera;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import rafael.alcocer.caldera.bean.SpringBean;
import rafael.alcocer.caldera.bean.SpringEventBean;

/**
 * 
 * @author Rafael Alcocer Caldera
 * @version 1.0
 *
 */
@SpringBootApplication
public class SpringBootJsfPrimefacesApplication {

    public static void main(String[] args) {
	SpringApplication.run(SpringBootJsfPrimefacesApplication.class, args);
    }
    
    @Bean
    public SpringBean springBean() {
	return new SpringBean();
    }
    
    @Bean
    public SpringEventBean springEventBean() {
	return new SpringEventBean();
    }

    @Configuration
    @Profile("dev")
    static class ConfigureJSFContextParameters implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	    servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
	    servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
	    servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
	    servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
	    servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
	}
    }

    @Configuration
    @Profile("production")
    static class ConfigureJSFContextParametersProd implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	    servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
	    servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
	    servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Production");
	    servletContext.setInitParameter("facelets.DEVELOPMENT", "false");
	    servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "-1");
	}
    }
}
