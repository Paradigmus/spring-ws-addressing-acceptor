package com.memorynotfound.server;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.addressing.server.AnnotationActionEndpointMapping;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@EnableWs
@Configuration
public class SoapServerConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean responseServlet(){
        ResponseServlet servlet = new ResponseServlet();
        return new ServletRegistrationBean(servlet, "/response");
    }

    @Bean
    public ServletRegistrationBean faultServlet(){
        FaultServlet servlet = new FaultServlet();
        return new ServletRegistrationBean(servlet, "/fault");
    }

    @Bean
    public AnnotationActionEndpointMapping annotationActionEndpointMapping(){
        AnnotationActionEndpointMapping mapping = new AnnotationActionEndpointMapping();
        mapping.setMessageSender(new HttpComponentsMessageSender());
        return mapping;
    }

}
