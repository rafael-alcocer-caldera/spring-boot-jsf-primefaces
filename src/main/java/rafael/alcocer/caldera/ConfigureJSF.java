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

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.faces.config.FacesInitializer;

/**
 * 
 * @author Rafael Alcocer Caldera
 * @version 1.0
 *
 */
@Configuration
public class ConfigureJSF {

    @Bean
    public ServletRegistrationBean facesServletRegistration() {

	ServletRegistrationBean servletRegistrationBean = new JsfServletRegistrationBean();

	return servletRegistrationBean;
    }

    public class JsfServletRegistrationBean extends ServletRegistrationBean {

	public JsfServletRegistrationBean() {
	    super();
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	    FacesInitializer facesInitializer = new FacesInitializer();

	    Set<Class<?>> clazz = new HashSet<Class<?>>();
	    clazz.add(ConfigureJSF.class);
	    facesInitializer.onStartup(clazz, servletContext);
	}
    }
}