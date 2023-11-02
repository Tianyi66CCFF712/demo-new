package com.example.demonew.conf;


import com.example.demonew.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
    /**
     * 图片保存路径
     * 示例： E:/images/
     */
    @Value("${Anlifile-save-path}")
    private String AnlifileSavePath;
    @Value("${Chanpinfile-save-path}")
    private String ChanpinfileSavePath;
    @Value("${Lunbotufile-save-path}")
    private String LunbotufileSavePath;
    @Value("${Userfile-save-path}")
    private String UserfileSavePath;
    @Value("${Newsfile-save-path}")
    private String NewsfileSavePath;
    @Value("${Honorfile-save-path}")
    private String HonorfileSavePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 配置资源映射
         * 意思是：如果访问的资源路径是以“/images/”开头的，
         * 就映射到本机的“E:/images/”这个文件夹内，去找你要的资源
         * 注意：E:/images/ 后面的 “/”一定要带上
         */
        registry.addResourceHandler("/anli/**")
                .addResourceLocations("file:" + AnlifileSavePath);
        registry.addResourceHandler("/chanpin/**")
                .addResourceLocations("file:" + ChanpinfileSavePath);
        registry.addResourceHandler("/lunbotu/**")
                .addResourceLocations("file:" + LunbotufileSavePath);
        registry.addResourceHandler("/user/**")
                .addResourceLocations("file:" + UserfileSavePath);
        registry.addResourceHandler("/new/**")
                .addResourceLocations("file:" + NewsfileSavePath);
        registry.addResourceHandler("/honors/**")
                .addResourceLocations("file:" + HonorfileSavePath);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/users/login")
                .excludePathPatterns("/anli/**")
                .excludePathPatterns("/chanpin/**")
                .excludePathPatterns("/user/**")
                .excludePathPatterns("/upload/**")
                .excludePathPatterns("/new/**")
                .excludePathPatterns("/honors/**")
                .excludePathPatterns("/lunbotu/**")
                .excludePathPatterns("/index/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/m/**")
                .excludePathPatterns("/about")
                .excludePathPatterns("/chanpinzhanshi/**")
                .excludePathPatterns("/anlizhanshi/**")
                .excludePathPatterns("/xinwen/**")
                .excludePathPatterns("/rongyu/**")
                .excludePathPatterns("//**")
                .excludePathPatterns("/connect")
                .excludePathPatterns("/error")
                .excludePathPatterns("/favicon.ico");
    }
}