package com.nuvole.framework.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlong
 * Date：2017/9/4
 * time：15:47
 */
@Configuration
@ControllerAdvice
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * fastjson数据处理
     *
     * @return
     */
    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue,
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");

        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return fastConverter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(this.fastJsonHttpMessageConverters());
        super.configureMessageConverters(converters);
    }

    @Bean
    public ThymeleafInterceptor thymeleafInterceptor(){
        return new ThymeleafInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(thymeleafInterceptor());
        // 排除配置
        //addInterceptor.excludePathPatterns("/error");
        addInterceptor.addPathPatterns("/**");

    }

}
