package org.bytedeco.ffmpeg.spring.boot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link FfmpegProperties}, {@link FfmpegTemplate} and
 * {@link FfmpegAutoConfiguration}.
 *
 * <p>The tests exercise property binding round-trips and bean instantiation
 * directly, avoiding a full Spring context so the suite does not depend on the
 * FFmpeg native bindings being loadable in the test JVM.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("FFmpeg Starter Tests")
class FfmpegApplication_Test {

    @Test
    @DisplayName("FfmpegProperties exposes its property prefix")
    void prefixIsBound() {
        assertThat(FfmpegProperties.PREFIX).isEqualTo("alibaba.cloud.ons");
    }

    @Test
    @DisplayName("FfmpegProperties defaults and getters/setters work")
    void propertiesDefaultsAndAccessors() {
        FfmpegProperties properties = new FfmpegProperties();

        assertThat(properties.getGroupId()).isEqualTo("DEFAULT");
        assertThat(properties.getMessageModel()).isEqualTo("CLUSTERING");
        assertThat(properties.getChannel()).isEqualTo("ALIYUN");
        assertThat(properties.getConsumeTimeout()).isEqualTo(15);
        assertThat(properties.getConsumeMessageBatchMaxSize()).isEqualTo(1);
        assertThat(properties.getMaxCachedMessageAmount()).isEqualTo(5000);
        assertThat(properties.getMaxCachedMessageSizeInMiB()).isEqualTo(512);
        assertThat(properties.getInstanceName()).isEqualTo("InstanceName");
        assertThat(properties.getIsVipChannelEnabled()).isFalse();
        assertThat(properties.getPostSubscriptionWhenPull()).isFalse();
        assertThat(properties.getMsgTraceSwitch()).isFalse();
        assertThat(properties.getExactlyOnceDelivery()).isFalse();
        assertThat(properties.getMaxBatchMessageCount()).isEqualTo(1L);

        properties.setAccessKey("ak");
        properties.setSecretKey("sk");
        properties.setSecurityToken("st");
        properties.setGroupId("GID_TEST");
        properties.setSendMsgTimeoutMillis(3000L);
        properties.setMessageModel("BROADCASTING");
        properties.setOnsAddr("http://ons");
        properties.setNameSrvAddr("127.0.0.1:9876");
        properties.setConsumeThreadNums(8);
        properties.setChannel("SDK");
        properties.setMqType("METAQ");
        properties.setIsVipChannelEnabled(Boolean.TRUE);
        properties.setSuspendTimeMillis(1000L);
        properties.setMaxReconsumeTimes(5);
        properties.setConsumeTimeout(30);
        properties.setCheckImmunityTimeInSeconds(10L);
        properties.setPostSubscriptionWhenPull(Boolean.TRUE);
        properties.setConsumeMessageBatchMaxSize(4);
        properties.setMaxCachedMessageAmount(1000);
        properties.setMaxCachedMessageSizeInMiB(128);
        properties.setInstanceId("INS");
        properties.setInstanceName("name");
        properties.setMsgTraceSwitch(Boolean.TRUE);
        properties.setMqttMessageId("mid");
        properties.setMqttMessage("msg");
        properties.setMqttPublishRetain("retain");
        properties.setMqttPublishDubFlag("dub");
        properties.setMqttSecondTopic("second");
        properties.setMqttClientId("cid");
        properties.setMqttQOS("1");
        properties.setExactlyOnceDelivery(Boolean.TRUE);
        properties.setExactlyOnceRmRefreshInterval("10s");
        properties.setMaxBatchMessageCount(2L);

        assertThat(properties.getAccessKey()).isEqualTo("ak");
        assertThat(properties.getSecretKey()).isEqualTo("sk");
        assertThat(properties.getSecurityToken()).isEqualTo("st");
        assertThat(properties.getGroupId()).isEqualTo("GID_TEST");
        assertThat(properties.getSendMsgTimeoutMillis()).isEqualTo(3000L);
        assertThat(properties.getMessageModel()).isEqualTo("BROADCASTING");
        assertThat(properties.getOnsAddr()).isEqualTo("http://ons");
        assertThat(properties.getNameSrvAddr()).isEqualTo("127.0.0.1:9876");
        assertThat(properties.getConsumeThreadNums()).isEqualTo(8);
        assertThat(properties.getChannel()).isEqualTo("SDK");
        assertThat(properties.getMqType()).isEqualTo("METAQ");
        assertThat(properties.getIsVipChannelEnabled()).isTrue();
        assertThat(properties.getSuspendTimeMillis()).isEqualTo(1000L);
        assertThat(properties.getMaxReconsumeTimes()).isEqualTo(5);
        assertThat(properties.getConsumeTimeout()).isEqualTo(30);
        assertThat(properties.getCheckImmunityTimeInSeconds()).isEqualTo(10L);
        assertThat(properties.getPostSubscriptionWhenPull()).isTrue();
        assertThat(properties.getConsumeMessageBatchMaxSize()).isEqualTo(4);
        assertThat(properties.getMaxCachedMessageAmount()).isEqualTo(1000);
        assertThat(properties.getMaxCachedMessageSizeInMiB()).isEqualTo(128);
        assertThat(properties.getInstanceId()).isEqualTo("INS");
        assertThat(properties.getInstanceName()).isEqualTo("name");
        assertThat(properties.getMsgTraceSwitch()).isTrue();
        assertThat(properties.getMqttMessageId()).isEqualTo("mid");
        assertThat(properties.getMqttMessage()).isEqualTo("msg");
        assertThat(properties.getMqttPublishRetain()).isEqualTo("retain");
        assertThat(properties.getMqttPublishDubFlag()).isEqualTo("dub");
        assertThat(properties.getMqttSecondTopic()).isEqualTo("second");
        assertThat(properties.getMqttClientId()).isEqualTo("cid");
        assertThat(properties.getMqttQOS()).isEqualTo("1");
        assertThat(properties.getExactlyOnceDelivery()).isTrue();
        assertThat(properties.getExactlyOnceRmRefreshInterval()).isEqualTo("10s");
        assertThat(properties.getMaxBatchMessageCount()).isEqualTo(2L);
    }

    @Test
    @DisplayName("FfmpegTemplate can be instantiated")
    void templateInstantiable() {
        assertThat(new FfmpegTemplate()).isNotNull();
    }

    @Test
    @DisplayName("FfmpegAutoConfiguration exposes a FfmpegTemplate bean")
    void autoConfigurationExposesTemplate() {
        FfmpegAutoConfiguration configuration = new FfmpegAutoConfiguration();
        assertThat(configuration.aliyunOnsMqTemplate()).isNotNull();
    }
}
