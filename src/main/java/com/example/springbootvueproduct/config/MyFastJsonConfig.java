package com.example.springbootvueproduct.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.thymeleaf.expression.Lists;

/**
 * @Description: fastjson配置
 * @License:
 * @Author: Luck
 * @Date: 2022/8/30
 */
@Configuration
public class MyFastJsonConfig {

  @Bean
  FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    FastJsonConfig config = new FastJsonConfig();
    config.setDateFormat("yyyy-MM-dd");
    config.setCharset(Charset.forName("UTF-8"));
    config.setSerializerFeatures(
        //SerializerFeature.WriteClassName,
        SerializerFeature.WriteMapNullValue,
        SerializerFeature.PrettyFormat,
        SerializerFeature.WriteNullListAsEmpty,
        SerializerFeature.WriteNullStringAsEmpty
    );
    converter.setFastJsonConfig(config);

    //从1.1.41升级到1.2.之后的版本必须配置，否则会报错
    List<MediaType> supportedMediaTypes = new ArrayList();
    supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
    supportedMediaTypes.add(MediaType.APPLICATION_CBOR);
    supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
    supportedMediaTypes.add(MediaType.APPLICATION_JSON);
    supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
    converter.setSupportedMediaTypes(supportedMediaTypes);
    return converter;
  }
}
