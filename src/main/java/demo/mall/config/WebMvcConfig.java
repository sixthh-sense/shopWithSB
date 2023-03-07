package demo.mall.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${uploadPath}")
    String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**") // url 주소
                .addResourceLocations(uploadPath); // 위의 주소는 아래의 경로에서 이미지를 받아온다(현재는 로컬 저장소지만 AWS 저장소에서도 받아오게 시키기)
    }
}
