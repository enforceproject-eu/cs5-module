package org.n52.project.enforce.cs5.api;

import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * WebConfig class.
 * </p>
 *
 * @author Benjamin Pross (b.pross@52north.org)
 * @since 1.0.0
 */
@Configuration
public class Cs5WebConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new Cs5MessageConverter());
    }
    
    @Bean
    GroupedOpenApi cs5Apis() {
      return GroupedOpenApi.builder().group("cs5").pathsToMatch("/cs5_catchment_data/**").build();
    }
    
}
