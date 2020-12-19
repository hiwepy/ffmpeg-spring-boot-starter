package org.bytedeco.ffmpeg.spring.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FfmpegApplication_Test {

	@Autowired
	private FfmpegTemplate onsMqTemplate;
	
    @Test
    public void testProducer() throws Exception {
    }
    

}
