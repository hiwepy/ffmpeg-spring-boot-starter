package org.bytedeco.ffmpeg.spring.boot;

import org.bytedeco.ffmpeg.ffmpeg;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({ ffmpeg.class })
@EnableConfigurationProperties(FfmpegProperties.class)
public class FfmpegAutoConfiguration {
    
	@Bean
	public FfmpegTemplate aliyunOnsMqTemplate() {
		return new FfmpegTemplate();
	}
	
}
