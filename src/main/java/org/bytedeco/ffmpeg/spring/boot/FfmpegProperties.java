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
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = FfmpegProperties.PREFIX)
/**
 * <p>Auto-configuration for FfmpegProperties.</p>
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
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


	/** Return the AccessKey used to authenticate the user. @return the access key */
	public String getAccessKey() {
		return accessKey;
	}

	/** Set the AccessKey used to authenticate the user. @param accessKey the access key */
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	/** Return the SecretKey used to authenticate the user. @return the secret key */
	public String getSecretKey() {
		return secretKey;
	}

	/** Set the SecretKey used to authenticate the user. @param secretKey the secret key */
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	/** Return the STS security token. @return the security token */
	public String getSecurityToken() {
		return securityToken;
	}

	/** Set the STS security token. @param securityToken the security token */
	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}

	/** Return the group id (client identifier). @return the group id */
	public String getGroupId() {
		return groupId;
	}

	/** Set the group id (client identifier). @param groupId the group id */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/** Return the message send timeout in milliseconds. @return the send timeout */
	public long getSendMsgTimeoutMillis() {
		return sendMsgTimeoutMillis;
	}

	/** Set the message send timeout in milliseconds. @param sendMsgTimeoutMillis the send timeout */
	public void setSendMsgTimeoutMillis(long sendMsgTimeoutMillis) {
		this.sendMsgTimeoutMillis = sendMsgTimeoutMillis;
	}

	/** Return the consumption mode (clustering or broadcasting). @return the message model */
	public String getMessageModel() {
		return messageModel;
	}

	/** Set the consumption mode (clustering or broadcasting). @param messageModel the message model */
	public void setMessageModel(String messageModel) {
		this.messageModel = messageModel;
	}

	/** Return the message queue service endpoint. @return the ONS address */
	public String getOnsAddr() {
		return onsAddr;
	}

	/** Set the message queue service endpoint. @param onsAddr the ONS address */
	public void setOnsAddr(String onsAddr) {
		this.onsAddr = onsAddr;
	}

	/** Return the Name Server address. @return the name server address */
	public String getNameSrvAddr() {
		return nameSrvAddr;
	}

	/** Set the Name Server address. @param nameSrvAddr the name server address */
	public void setNameSrvAddr(String nameSrvAddr) {
		this.nameSrvAddr = nameSrvAddr;
	}

	/** Return the number of consumption threads. @return the consume thread count */
	public Integer getConsumeThreadNums() {
		return consumeThreadNums;
	}

	/** Set the number of consumption threads. @param consumeThreadNums the consume thread count */
	public void setConsumeThreadNums(Integer consumeThreadNums) {
		this.consumeThreadNums = consumeThreadNums;
	}

	/** Return the client access source channel. @return the channel */
	public String getChannel() {
		return channel;
	}

	/** Set the client access source channel. @param channel the channel */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/** Return the message type. @return the MQ type */
	public String getMqType() {
		return mqType;
	}

	/** Set the message type. @param mqType the MQ type */
	public void setMqType(String mqType) {
		this.mqType = mqType;
	}

	/** Return whether the VIP channel is enabled. @return true if the VIP channel is enabled */
	public Boolean getIsVipChannelEnabled() {
		return isVipChannelEnabled;
	}

	/** Set whether the VIP channel is enabled. @param isVipChannelEnabled true to enable */
	public void setIsVipChannelEnabled(Boolean isVipChannelEnabled) {
		this.isVipChannelEnabled = isVipChannelEnabled;
	}

	/** Return the retry suspend time in milliseconds. @return the suspend time */
	public long getSuspendTimeMillis() {
		return suspendTimeMillis;
	}

	/** Set the retry suspend time in milliseconds. @param suspendTimeMillis the suspend time */
	public void setSuspendTimeMillis(long suspendTimeMillis) {
		this.suspendTimeMillis = suspendTimeMillis;
	}

	/** Return the maximum number of reconsume attempts. @return the max reconsume count */
	public int getMaxReconsumeTimes() {
		return maxReconsumeTimes;
	}

	/** Set the maximum number of reconsume attempts. @param maxReconsumeTimes the max reconsume count */
	public void setMaxReconsumeTimes(int maxReconsumeTimes) {
		this.maxReconsumeTimes = maxReconsumeTimes;
	}

	/** Return the consumption timeout in minutes. @return the consume timeout */
	public int getConsumeTimeout() {
		return consumeTimeout;
	}

	/** Set the consumption timeout in minutes. @param consumeTimeout the consume timeout */
	public void setConsumeTimeout(int consumeTimeout) {
		this.consumeTimeout = consumeTimeout;
	}

	/** Return the initial delay before back-checking transaction messages. @return the check immunity time */
	public long getCheckImmunityTimeInSeconds() {
		return checkImmunityTimeInSeconds;
	}

	/** Set the initial delay before back-checking transaction messages. @param checkImmunityTimeInSeconds the check immunity time */
	public void setCheckImmunityTimeInSeconds(long checkImmunityTimeInSeconds) {
		this.checkImmunityTimeInSeconds = checkImmunityTimeInSeconds;
	}

	/** Return whether the latest subscription is posted on each pull. @return true if posted */
	public Boolean getPostSubscriptionWhenPull() {
		return postSubscriptionWhenPull;
	}

	/** Set whether the latest subscription is posted on each pull. @param postSubscriptionWhenPull true to post */
	public void setPostSubscriptionWhenPull(Boolean postSubscriptionWhenPull) {
		this.postSubscriptionWhenPull = postSubscriptionWhenPull;
	}

	/** Return the maximum messages consumed per batch. @return the consume batch max size */
	public int getConsumeMessageBatchMaxSize() {
		return consumeMessageBatchMaxSize;
	}

	/** Set the maximum messages consumed per batch. @param consumeMessageBatchMaxSize the consume batch max size */
	public void setConsumeMessageBatchMaxSize(int consumeMessageBatchMaxSize) {
		this.consumeMessageBatchMaxSize = consumeMessageBatchMaxSize;
	}

	/** Return the maximum number of cached messages. @return the max cached message amount */
	public int getMaxCachedMessageAmount() {
		return maxCachedMessageAmount;
	}

	/** Set the maximum number of cached messages. @param maxCachedMessageAmount the max cached message amount */
	public void setMaxCachedMessageAmount(int maxCachedMessageAmount) {
		this.maxCachedMessageAmount = maxCachedMessageAmount;
	}

	/** Return the maximum cached message size in MiB. @return the max cached message size */
	public int getMaxCachedMessageSizeInMiB() {
		return maxCachedMessageSizeInMiB;
	}

	/** Set the maximum cached message size in MiB. @param maxCachedMessageSizeInMiB the max cached message size */
	public void setMaxCachedMessageSizeInMiB(int maxCachedMessageSizeInMiB) {
		this.maxCachedMessageSizeInMiB = maxCachedMessageSizeInMiB;
	}

	/** Return the instance id (namespace). @return the instance id */
	public String getInstanceId() {
		return instanceId;
	}

	/** Set the instance id (namespace). @param instanceId the instance id */
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	/** Return the instance name. @return the instance name */
	public String getInstanceName() {
		return instanceName;
	}

	/** Set the instance name. @param instanceName the instance name */
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	/** Return whether MQ message tracing is enabled. @return true if enabled */
	public Boolean getMsgTraceSwitch() {
		return msgTraceSwitch;
	}

	/** Set whether MQ message tracing is enabled. @param msgTraceSwitch true to enable */
	public void setMsgTraceSwitch(Boolean msgTraceSwitch) {
		this.msgTraceSwitch = msgTraceSwitch;
	}

	/** Return the MQTT message id. @return the MQTT message id */
	public String getMqttMessageId() {
		return mqttMessageId;
	}

	/** Set the MQTT message id. @param mqttMessageId the MQTT message id */
	public void setMqttMessageId(String mqttMessageId) {
		this.mqttMessageId = mqttMessageId;
	}

	/** Return the MQTT message payload. @return the MQTT message */
	public String getMqttMessage() {
		return mqttMessage;
	}

	/** Set the MQTT message payload. @param mqttMessage the MQTT message */
	public void setMqttMessage(String mqttMessage) {
		this.mqttMessage = mqttMessage;
	}

	/** Return the MQTT publish retain keyword. @return the retain keyword */
	public String getMqttPublishRetain() {
		return mqttPublishRetain;
	}

	/** Set the MQTT publish retain keyword. @param mqttPublishRetain the retain keyword */
	public void setMqttPublishRetain(String mqttPublishRetain) {
		this.mqttPublishRetain = mqttPublishRetain;
	}

	/** Return the MQTT publish dub flag keyword. @return the dub flag keyword */
	public String getMqttPublishDubFlag() {
		return mqttPublishDubFlag;
	}

	/** Set the MQTT publish dub flag keyword. @param mqttPublishDubFlag the dub flag keyword */
	public void setMqttPublishDubFlag(String mqttPublishDubFlag) {
		this.mqttPublishDubFlag = mqttPublishDubFlag;
	}

	/** Return the secondary MQTT topic. @return the secondary topic */
	public String getMqttSecondTopic() {
		return mqttSecondTopic;
	}

	/** Set the secondary MQTT topic. @param mqttSecondTopic the secondary topic */
	public void setMqttSecondTopic(String mqttSecondTopic) {
		this.mqttSecondTopic = mqttSecondTopic;
	}

	/** Return the MQTT client id. @return the MQTT client id */
	public String getMqttClientId() {
		return mqttClientId;
	}

	/** Set the MQTT client id. @param mqttClientId the MQTT client id */
	public void setMqttClientId(String mqttClientId) {
		this.mqttClientId = mqttClientId;
	}

	/** Return the MQTT QoS level. @return the QoS level */
	public String getMqttQOS() {
		return mqttQOS;
	}

	/** Set the MQTT QoS level. @param mqttQOS the QoS level */
	public void setMqttQOS(String mqttQOS) {
		this.mqttQOS = mqttQOS;
	}

	/** Return whether exactly-once delivery is enabled. @return true if enabled */
	public Boolean getExactlyOnceDelivery() {
		return exactlyOnceDelivery;
	}

	/** Set whether exactly-once delivery is enabled. @param exactlyOnceDelivery true to enable */
	public void setExactlyOnceDelivery(Boolean exactlyOnceDelivery) {
		this.exactlyOnceDelivery = exactlyOnceDelivery;
	}

	/** Return the refresh interval for the exactly-once record manager. @return the refresh interval */
	public String getExactlyOnceRmRefreshInterval() {
		return exactlyOnceRmRefreshInterval;
	}

	/** Set the refresh interval for the exactly-once record manager. @param exactlyOnceRmRefreshInterval the refresh interval */
	public void setExactlyOnceRmRefreshInterval(String exactlyOnceRmRefreshInterval) {
		this.exactlyOnceRmRefreshInterval = exactlyOnceRmRefreshInterval;
	}

	/** Return the maximum number of messages retrieved in a single batch. @return the max batch message count */
	public long getMaxBatchMessageCount() {
		return maxBatchMessageCount;
	}

	/** Set the maximum number of messages retrieved in a single batch. @param maxBatchMessageCount the max batch message count */
	public void setMaxBatchMessageCount(long maxBatchMessageCount) {
		this.maxBatchMessageCount = maxBatchMessageCount;
	}

}
