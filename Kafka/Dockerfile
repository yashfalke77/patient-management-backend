FROM apache/kafka:4.2.0

ENV KAFKA_NODE_ID=1
ENV KAFKA_PROCESS_ROLES=broker,controller
ENV KAFKA_LISTENERS=PLAINTEXT://:9092,CONTROLLER://:9093
ENV KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://kafka.railway.internal:9092
ENV KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT
ENV KAFKA_INTER_BROKER_LISTENER_NAME=PLAINTEXT
ENV KAFKA_CONTROLLER_LISTENER_NAMES=CONTROLLER
ENV KAFKA_CONTROLLER_QUORUM_VOTERS=1@localhost:9093
ENV KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1
ENV KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR=1
ENV KAFKA_TRANSACTION_STATE_LOG_MIN_ISR=1
ENV KAFKA_MIN_INSYNC_REPLICAS=1
ENV KAFKA_NUM_PARTITIONS=3
ENV KAFKA_DEFAULT_REPLICATION_FACTOR=1
ENV KAFKA_AUTO_CREATE_TOPICS_ENABLE=true
ENV KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS=0
ENV KAFKA_LOG_RETENTION_HOURS=168

EXPOSE 9092

CMD ["/bin/sh", "-c", "\
  grep -v 'advertised.listeners\|^listeners=' /etc/kafka/docker/server.properties > /tmp/kafka.properties && \
  echo 'listeners=PLAINTEXT://:9092,CONTROLLER://:9093' >> /tmp/kafka.properties && \
  echo 'advertised.listeners=PLAINTEXT://kafka.railway.internal:9092' >> /tmp/kafka.properties && \
  echo '>>> Config check:' && grep -E 'listeners|advertised' /tmp/kafka.properties && \
  CLUSTER_ID=$(/opt/kafka/bin/kafka-storage.sh random-uuid) && \
  /opt/kafka/bin/kafka-storage.sh format \
    --config /tmp/kafka.properties \
    --cluster-id $CLUSTER_ID \
    --ignore-formatted && \
  /opt/kafka/bin/kafka-server-start.sh /tmp/kafka.properties"]