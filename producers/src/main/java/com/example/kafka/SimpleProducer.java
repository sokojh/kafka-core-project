package com.example.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;


public class SimpleProducer {
     public static void main(String[] args){

          String topicName = "simple-topic";
          //KafkaProducer configuration setting
          // null, "hello world"
          Properties props = new Properties();
          //bootstrap.servers, key.serializer.class, value.serializer.class
          props.setProperty("bootstrap.servers","ip:9092");
          props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"ip:9092");
          props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
          props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

          //Kafka Producer object creation
          KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(props);

          //ProducerRecord object creation
          ProducerRecord<String, String>  producerRecord = new ProducerRecord<>(topicName,"hello world 2 ");

          //KafkaProducer message send
          kafkaProducer.send(producerRecord);

          kafkaProducer.flush();
          kafkaProducer.close();

     }
}
