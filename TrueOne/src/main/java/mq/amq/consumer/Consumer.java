package mq.amq.consumer;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class Consumer {
    public void consumerQueue() throws JMSException, IOException {
        //1.创建ConnectionFactory
        String brokerUrl = "tcp://localhost:61616";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
        //2.创建Connection
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //3.创建Session
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //4.创建Destination 目的地对象
        Destination destination = session.createQueue("text-Message");
        //5.创建消费者
        MessageConsumer messageConsumer = session.createConsumer(destination);
        //6.消费消息，监听队列中的消息，若有新消息，会执行onMessage方法
        messageConsumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(Thread.currentThread().getName().concat("queue消息：" + textMessage.getText()));
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //避免单元测试停止
        System.in.read();
        //7.释放资源
        messageConsumer.close();
        session.close();
        connection.close();
    }

    public void consumerTopic() throws JMSException, IOException {
        //1.  创建连接工厂
        ConnectionFactory connectionFactory = new
                ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        //2.  创建并启动连接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //3.  创建 Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.  创建目的地对象
        Topic topic = session.createTopic("weixin-Topic");
        //5.  创建消费者
        MessageConsumer consumer = session.createConsumer(topic);
        //6.  获取消息
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(Thread.currentThread().getName().concat(("topic").concat(textMessage.getText())));
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        //7.  释放资源
        consumer.close();
        session.close();
        connection.close();
    }
}
