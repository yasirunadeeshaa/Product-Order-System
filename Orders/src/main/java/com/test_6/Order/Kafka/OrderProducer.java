package com.test_6.Order.Kafka;


//import com.test_6.Order.DTO.OrderEventDTO;
//import org.apache.hc.core5.http.Message;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Service;
//
//import java.util.logging.Logger;
//
//@Service
//public class OrderProducer {
//
//    //private static final Logger LOGGER = LoggerFactory.getLogger(OrderEventDTO.class);
//
//    private final NewTopic orderTopic;
//    private final KafkaTemplate<String, OrderEventDTO> kafkaTemplate;
//
//    public OrderProducer(NewTopic orderTopic, KafkaTemplate<String, OrderEventDTO> kafkaTemplate) {
//        this.orderTopic = orderTopic;
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
////    public void sendMessage(OrderEventDTO orderEventDTO) {
////        LOGGER.info(String.format("Sending order event to topic %s", orderEventDTO.toString()));
////
////        Message<OrderEventDTO> message = MessageBuilder
////                .withPayload(orderEventDTO)
////                .setHeader(KafkaHeaders.TOPIC, orderTopic.name())
////                .build();
////
////        kafkaTemplate.send(message);
////    }
//}