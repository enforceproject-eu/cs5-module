package org.n52.project.enforce.cs5.api;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.n52.project.enforce.cs5.model.Cs5DataRequest;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Cs5MessageConverter extends AbstractHttpMessageConverter<Map<?,?>> {

    public static final MediaType CS5_CATCHMENT_DATA =
            new MediaType("application", "enforce-cs5-data");

    ObjectMapper objectMapper = new ObjectMapper();
//    ObjectMapper objectMapper = new ObjectMapper().registerModule(javaTimeModule());
    
//    @Bean
//    public JavaTimeModule javaTimeModule() {
//        return new JavaTimeModule();
//    }
    
    @Override
    protected boolean supports(Class<?> clazz) {
        System.out.println(clazz);
        System.out.println(Map.class.isAssignableFrom(clazz));
        return Map.class.isAssignableFrom(clazz);
    }

//    @Override
//    protected boolean canWrite(MediaType mediaType) {        
//        return CS5_CATCHMENT_DATA.equals(mediaType);
//    }

    @Override
    protected Map<?,?> readInternal(Class<? extends Map<?,?>> clazz,
            HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return objectMapper.readerFor(new TypeReference<Map<String, Cs5DataRequest>>() { }).readValue(inputMessage.getBody());
    }

    @Override
    protected void writeInternal(Map<?,?> t,
            HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
       System.out.println(t);
//       objectMapper.writer().writeValue(outputMessage.getBody(), t);
    }

    @Override
    protected MediaType getDefaultContentType(Map<?, ?> t) throws IOException {
        return CS5_CATCHMENT_DATA;
    }    
    

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Collections.singletonList(CS5_CATCHMENT_DATA);
    }

    @Override
    public Charset getDefaultCharset() {
        return Charset.forName("UTF-8");
    }

}
