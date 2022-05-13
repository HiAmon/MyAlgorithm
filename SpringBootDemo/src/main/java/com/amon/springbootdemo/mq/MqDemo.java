package com.amon.springbootdemo.mq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class MqDemo {
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer();
        MessageQueue queue = new MessageQueue();
        queue.setQueueId(1);

        Message message = new Message();
        message.setBody("ds".getBytes());
        try {
            producer.send(message,queue);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
