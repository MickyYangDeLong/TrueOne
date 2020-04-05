package mq.amq.producter;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class Product {
    public void producerQueue() throws JMSException {
        //1.创建ConnectionFactory  连接工厂
        String brokerUrl = "tcp://localhost:61616";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
        //2.创建Connection 连接对象
        Connection connection = connectionFactory.createConnection();
        //开启连接
        connection.start();
        //3.创建Session事务管理，通过参数设置事务级别
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //4.创建Destination 目的地对象
        Destination destination = session.createQueue("text-Message");
        //5.创建消息的生产者
        MessageProducer messageProducer = session.createProducer(destination);
        //6.创建一条消息
        TextMessage textMessage = session.createTextMessage("测试-消息生产者");
        //7.发送消息
        for (int i=0;i<100;i++){
            messageProducer.send(session.createTextMessage("queue mq测试-消息生产者--".concat(String.valueOf(i))));

        }
        //提交事务
        session.commit();
        //8.释放资源
        messageProducer.close();
        session.close();
        connection.close();
    }

    public void producerTopic() throws JMSException {
        //1.  创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //2.  创建连接 并 开启
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //3.  创建 Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.  创建 Topic 对象
        Topic topic = session.createTopic("weixin-Topic");
        //5.  创建生产者
        MessageProducer producer = session.createProducer(topic);
        //6.  发送消息
        TextMessage textMessage = session.createTextMessage("Hello,Topic MQ");
        for (int i=0;i<100;i++){
            producer.send(session.createTextMessage("Topic MQ-测试-消息生产者--".concat(String.valueOf(i))));

        }
    //7.  释放资源
        producer.close();
        session.close();
        connection.close();
    }

}
