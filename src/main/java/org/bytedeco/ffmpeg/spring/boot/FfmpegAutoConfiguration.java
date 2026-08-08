package org.bytedeco.ffmpeg.spring.boot;

import org.bytedeco.ffmpeg.ffmpeg;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot auto-configuration for the JavaCV FFmpeg integration.
 * <p>
 * Activates automatically when the FFmpeg native bindings
 * ({@code org.bytedeco:ffmpeg}) are present on the classpath, binding the
 * {@link FfmpegProperties} configuration POJO and exposing a ready-to-use
 * {@link FfmpegTemplate} bean.
 * </p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass({ ffmpeg.class })
@EnableConfigurationProperties(FfmpegProperties.class)
public class FfmpegAutoConfiguration {

	/**
	 * Creates the singleton {@link FfmpegTemplate} used as the main entry point for
	 * invoking JavaCV / FFmpeg operations from application code.
	 *
	 * @return a new {@link FfmpegTemplate} instance registered as a Spring bean
	 */
	@Bean
	public FfmpegTemplate aliyunOnsMqTemplate() {
		return new FfmpegTemplate();
	}

}
