#!/bin/bash

grep -v 'advertised.listeners\|^listeners=' /etc/kafka/docker/server.properties > /tmp/kafka.properties

echo 'listeners=PLAINTEXT://:9092,CONTROLLER://:9093' >> /tmp/kafka.properties
echo 'advertised.listeners=PLAINTEXT://kafka.railway.internal:9092' >> /tmp/kafka.properties

echo ">>> Config check:"
grep -E 'listeners|advertised' /tmp/kafka.properties

CLUSTER_ID=$(/opt/kafka/bin/kafka-storage.sh random-uuid)
/opt/kafka/bin/kafka-storage.sh format \
  --config /tmp/kafka.properties \
  --cluster-id $CLUSTER_ID \
  --ignore-formatted

exec /opt/kafka/bin/kafka-server-start.sh /tmp/kafka.properties