package com.zhangbaowei.demo.core;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.actuate.autoconfigure.endpoint.ExposeExcludePropertyEndpointFilter;
//import org.springframework.boot.actuate.autoconfigure.endpoint.web.MappingWebEndpointPathMapper;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.endpoint.EndpointFilter;
import org.springframework.boot.actuate.endpoint.EndpointsSupplier;
import org.springframework.boot.actuate.endpoint.http.ActuatorMediaType;
import org.springframework.boot.actuate.endpoint.invoke.OperationInvokerAdvisor;
import org.springframework.boot.actuate.endpoint.invoke.ParameterValueMapper;
import org.springframework.boot.actuate.endpoint.web.*;
import org.springframework.boot.actuate.endpoint.web.annotation.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
public class CustomWebEndpoingConfig  {
    public CustomWebEndpoingConfig(ApplicationContext applicationContext, WebEndpointProperties properties) {
        this.applicationContext = applicationContext;
        this.properties = properties;
    }

    //    private static final List<String> MEDIA_TYPES = Arrays
//            .asList(ActuatorMediaType.V2_JSON, "application/json");
//
    private final ApplicationContext applicationContext;
    //
    private final WebEndpointProperties properties;
//
//

    @Bean
    @ConditionalOnMissingBean
    public PathMapper webEndpointPathMapper() {
        return new MyMappingWebEndpointPathMapper(this.properties.getPathMapping());
    }

//    @Bean
//    @ConditionalOnMissingBean
//    public EndpointMediaTypes endpointMediaTypes() {
//        return new EndpointMediaTypes(MEDIA_TYPES, MEDIA_TYPES);
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(WebEndpointsSupplier.class)
//    public WebEndpointDiscoverer webEndpointDiscoverer(
//            ParameterValueMapper parameterValueMapper,
//            EndpointMediaTypes endpointMediaTypes, PathMapper webEndpointPathMapper,
//            ObjectProvider<Collection<OperationInvokerAdvisor>> invokerAdvisors,
//            ObjectProvider<Collection<EndpointFilter<ExposableWebEndpoint>>> filters) {
//        return new WebEndpointDiscoverer(this.applicationContext, parameterValueMapper,
//                endpointMediaTypes, webEndpointPathMapper,
//                invokerAdvisors.getIfAvailable(Collections::emptyList),
//                filters.getIfAvailable(Collections::emptyList));
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(ControllerEndpointsSupplier.class)
//    public ControllerEndpointDiscoverer controllerEndpointDiscoverer(
//            PathMapper webEndpointPathMapper,
//            ObjectProvider<Collection<EndpointFilter<ExposableControllerEndpoint>>> filters) {
//        return new ControllerEndpointDiscoverer(this.applicationContext,
//                webEndpointPathMapper, filters.getIfAvailable(Collections::emptyList));
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public PathMappedEndpoints pathMappedEndpoints(
//            Collection<EndpointsSupplier<?>> endpointSuppliers,
//            WebEndpointProperties webEndpointProperties) {
//        return new PathMappedEndpoints(webEndpointProperties.getBasePath(),
//                endpointSuppliers);
//    }
//
//    @Bean
//    public ExposeExcludePropertyEndpointFilter<ExposableWebEndpoint> webExposeExcludePropertyEndpointFilter() {
//        WebEndpointProperties.Exposure exposure = this.properties.getExposure();
//        return new ExposeExcludePropertyEndpointFilter<>(ExposableWebEndpoint.class,
//                exposure.getInclude(), exposure.getExclude(), "info", "health");
//    }
//
//    @Bean
//    public ExposeExcludePropertyEndpointFilter<ExposableControllerEndpoint> controllerExposeExcludePropertyEndpointFilter() {
//        WebEndpointProperties.Exposure exposure = this.properties.getExposure();
//        return new ExposeExcludePropertyEndpointFilter<>(
//                ExposableControllerEndpoint.class, exposure.getInclude(),
//                exposure.getExclude());
//    }
//
//    @Configuration
//    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
//    static class WebEndpointServletConfiguration {
//
//        @Bean
//        @ConditionalOnMissingBean(ServletEndpointsSupplier.class)
//        public ServletEndpointDiscoverer servletEndpointDiscoverer(
//                ApplicationContext applicationContext, PathMapper webEndpointPathMapper,
//                ObjectProvider<Collection<EndpointFilter<ExposableServletEndpoint>>> filters) {
//            return new ServletEndpointDiscoverer(applicationContext,
//                    webEndpointPathMapper,
//                    filters.getIfAvailable(Collections::emptyList));
//        }
//
//    }
}
