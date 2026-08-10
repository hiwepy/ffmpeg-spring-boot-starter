package org.bytedeco.ffmpeg.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper component that exposes JavaCV / FFmpeg operations to application code.
 * <p>
 * Registered as a Spring bean by {@link FfmpegAutoConfiguration}; subclasses or
 * collaborators are expected to add concrete media-processing methods.
 * </p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class FfmpegTemplate {

	/** Shared logger for FFmpeg operations, exposed for subclasses and collaborators. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	/** Default no-arg constructor used by {@link FfmpegAutoConfiguration} to create the bean. */
	public FfmpegTemplate() {
		log.debug("Initializing FfmpegTemplate");
	}

}
