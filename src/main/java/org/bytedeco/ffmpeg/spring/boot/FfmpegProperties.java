package org.bytedeco.ffmpeg.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties bound to the {@value #PREFIX} namespace.
 * <p>
 * Holds the runtime configuration consumed by {@link FfmpegAutoConfiguration}
 * and {@link FfmpegTemplate}, including authentication credentials, message
 * queue endpoints, consumption tuning parameters and MQTT-related options.
 * </p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = FfmpegProperties.PREFIX)
public class FfmpegProperties {

	/**
     * The prefix of the property of {@link FfmpegProperties}.
     */
    public static final String PREFIX = "alibaba.cloud.ons";

	/**
	 * AccessKey used to identify and authenticate the user identity.
	 */
	private String accessKey;
	/**
	 * SecretKey used to identify and authenticate the user identity.
	 */
	private String secretKey;
	/**
	 * STS token required when using Security Token Service (STS).
	 * See https://help.aliyun.com/document_detail/28788.html for details.
	 */
	private String securityToken;
	/**
	 * Group ID, the client identifier.
	 */
	private String groupId = "DEFAULT";
	/**
	 * Message send timeout in milliseconds. If the server does not ACK within the
	 * configured time, the client treats the send as failed.
	 */
	private long sendMsgTimeoutMillis = -1;
	/**
	 * Consumption mode, either clustering or broadcasting.
	 */
	private String messageModel = "CLUSTERING";
	/**
	 * Message queue service access point (endpoint).
	 */
	private String onsAddr;
	/**
	 * Name Server address used by the client to discover brokers.
	 */
	private String nameSrvAddr;
	/**
	 * Number of threads used for message consumption.
	 */
	private Integer consumeThreadNums;
	/**
	 * Client access source channel, defaults to {@code ALIYUN}.
	 */
	private String channel = "ALIYUN";
	/**
	 * Message type, configurable to {@code NOTIFY} or {@code METAQ}.
	 */
	private String mqType;

	/**
	 * Whether the VIP channel is enabled.
	 */
	private Boolean isVipChannelEnabled = Boolean.FALSE;

	/**
	 * Wait time in milliseconds before retrying after an ordered-message
	 * consumption failure.
	 */
	private long suspendTimeMillis = -1;

	/**
	 * Maximum retry attempts on message consumption failure. When consumption
	 * attempts exceed this value without success, the message is moved to a
	 * failure queue pending deletion.
	 */
	private int maxReconsumeTimes = -1;

	/**
	 * Maximum consumption timeout in minutes per message. When exceeded the
	 * message is treated as failed and will be redelivered for the next
	 * consumption attempt. Set a reasonable value for each business case.
	 * Defaults to 15 minutes.
	 */
	private int consumeTimeout = 15;
	/**
	 * Initial delay before the first transaction-message back-check.
	 */
	private long checkImmunityTimeInSeconds;

	/**
	 * Whether each request carries the latest subscription relationship,
	 * defaults to {@code false}.
	 */
	private Boolean postSubscriptionWhenPull = Boolean.FALSE;

	/**
	 * Maximum number of messages consumed in each batch by a BatchConsumer.
	 * Defaults to 1; the customizable range is [1, 32], although the actual
	 * consumed amount may be smaller.
	 */
	private int consumeMessageBatchMaxSize = 1;

	/**
	 * Maximum number of messages the consumer may cache locally. Defaults to
	 * 5000. Too large a value may cause client OOM. Range is [100, 50000].
	 * Due to batch pulling, the actual cached amount may slightly exceed the
	 * limit. The limit takes effect at the client level and is evenly split
	 * across subscribed topics, e.g. a limit of 1000 with 2 topics allows 500
	 * cached messages per topic.
	 */
	private int maxCachedMessageAmount = 5000;

	/**
	 * Maximum cached message capacity in MiB allowed by the consumer. Defaults
	 * to 512 MiB. Too large a value may cause client OOM. Range is [16, 2048].
	 * Due to batch pulling, the actual cached amount may slightly exceed the
	 * limit. The limit takes effect at the client level and is evenly split
	 * across subscribed topics, e.g. a limit of 1000 MiB with 2 topics allows
	 * 500 MiB cached per topic.
	 */
	private int maxCachedMessageSizeInMiB = 512;

	/**
	 * Instance ID, acting as a namespace.
	 */
	private String instanceId;

	/**
	 * Instance name. Note: when multiple producers or consumers in the same
	 * process share the same instance name, they share the underlying
	 * connection.
	 */
	private String instanceName = "InstanceName";

	/**
	 * Toggle for MQ message tracing.
	 */
	private Boolean msgTraceSwitch = Boolean.FALSE;
	/**
	 * Sequence ID of the MQTT message.
	 */
	private String mqttMessageId;
	/**
	 * MQTT message payload.
	 */
	private String mqttMessage;

	/**
	 * MQTT message reserved keyword for retain flag.
	 */
	private String mqttPublishRetain = "mqttRetain";

	/**
	 * MQTT message reserved keyword for the dub publish flag.
	 */
	private String mqttPublishDubFlag = "mqttPublishDubFlag";

	/**
	 * Secondary MQTT topic, a child of the parent topic.
	 */
	private String mqttSecondTopic = "mqttSecondTopic";

	/**
	 * Unique identifier of each client using the MQTT protocol.
	 */
	private String mqttClientId = "clientId";

	/**
	 * Quality-of-service (QoS) level for MQTT message delivery reliability.
	 */
	private String mqttQOS = "qoslevel";

	/**
	 * Whether MQ transactions are enabled for exactly-once delivery semantics.
	 */
	private Boolean exactlyOnceDelivery = Boolean.FALSE;

	/**
	 * Refresh interval for the exactly-once consumer record manager to purge
	 * expired records.
	 */
	private String exactlyOnceRmRefreshInterval = "exactlyOnceRmRefreshInterval";

	/**
	 * Maximum number of messages retrieved in a single batch.
	 */
	private long maxBatchMessageCount = 1;


}
