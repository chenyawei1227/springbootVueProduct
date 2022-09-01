package com.example.springbootvueproduct.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.springbootvueproduct.interceptor.MyInterceptor;
import java.nio.charset.Charset;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 自定义自动化配置
 * 
 * @Author: Luck
 * @Date: 2022/8/31
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

//  /**
//   *
//   * @param converters
//   */
//  @Override
//  public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
//    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//    FastJsonConfig config = new FastJsonConfig();
//    config.setDateFormat("yyyy-MM-dd");
//    config.setCharset(Charset.forName("UTF-8"));
//    config.setSerializerFeatures(
//        SerializerFeature.WriteClassName,
//        SerializerFeature.WriteMapNullValue,
//        SerializerFeature.PrettyFormat,
//        SerializerFeature.WriteNullListAsEmpty,
//        SerializerFeature.WriteNullStringAsEmpty
//    );
//    converter.setFastJsonConfig(config);
//    converters.add(converter);
//  }


  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/hello");
  }


}
