# spring-cloud-study
  参考大佬SpringCloud微服务框架实战学习笔记：https://github.com/hemin1003
  
  
  


## SpringCloud Alibaba系列（基于Greenwich版本，SpringBoot2.1.7版本实现）
SpringCloud Alibaba从入门到精通教程（一）- 配置中心Nacos快速入门介绍·Server启动安装
SpringCloud Alibaba从入门到精通教程（二）- 项目中快速集成配置中心·Nacos-服务注册发现功能 springcloud-alibaba-nacos-discovery
SpringCloud Alibaba从入门到精通教程（三）- 项目中快速集成配置中心·Nacos-配置中心管理功能 springcloud-alibaba-nacos-config
SpringCloud Alibaba从入门到精通教程（四）- 流控组件Sentinel快速入门介绍·Server启动安装
SpringCloud Alibaba从入门到精通教程（五）- 项目中快速集成·限流组件Sentinel springcloud-alibaba-sentinel
SpringCloud Alibaba从入门到精通教程（六）- 项目中快速集成·MQ消息组件RocketMQ springcloud-alibaba-rocketmq
SpringCloud Alibaba从入门到精通教程（七）- 项目中快速集成·分布式事务组件Seata springcloud-alibaba-seata
SpringCloud Alibaba从入门到精通教程（八）- 项目中快速集成·服务治理组件Dubbo springcloud-alibaba-dubbo
SpringCloud Alibaba从入门到精通教程（九）- 项目中快速集成·限流组件Sentinel之限流数据源 springcloud-alibaba-sentinel-datasource
SpringCloud Alibaba从入门到精通教程（十）- 项目中快速集成·限流组件Sentinel之限流网关 springcloud-alibaba-sentinel-gateway
SpringCloud Alibaba从入门到精通教程（十一）- 项目中快速集成·限流组件Sentinel之断路器 springcloud-alibaba-circuitbreaker-sentinel


### nacos
windows本地单机启动   startup.cmd -m standalone
启动后访问 localhost:8848即可

### nacos 服务注册发现
项目中快速集成配置中心Nacos-服务注册发现功能
1. @EnableDiscoveryClient注解
   启用Nacos服务注册发现功能
2. 区分不同环境， 实现服务注册发现功能
   登录Nacos 控制台，  新增dev/test/prod 三套不同环境， 分别对应： 开发环境/测试环境/生产环境

## rocketMq消息组件
下载bin压缩包本地解压  
本地启动命令：
1. 进入bin目录 ： mqnamesrc   启动Name Server 服务
2. 同上   ： mqbroker         启动 Broker 服务
3. 再下载 rocketmq-externals-master 压缩包zip
找到 rocketmq-console，
使用mvn clean package -Dmaven.test.skip=true
再使用jar命令启动即可 

### rocketMq 介绍：
RocketMQ 主要由 Producer、Broker、Consumer 三部分组成
    其中Producer 负责生产消息，Consumer 负责消费消息，Broker 负责存储消息
    
Broker 在实际部署过程中对应一台服务器，每个 Broker 可以存储多个Topic的消息，每个Topic的消息也可以分片存储于不同的 Broker
Message Queue 用于存储消息的物理地址，每个Topic中的消息地址存储于多个 Message Queue 中
ConsumerGroup 由多个Consumer 实例构成

####  主要分为四个部分
Producer：消息发布的角色，支持分布式集群方式部署
    Producer通过MQ的负载均衡模块选择相应的Broker集群队列进行消息投递，投递的过程支持快速失败并且低延迟
Consumer：消息消费的角色，支持分布式集群方式部署
    支持以push推，pull拉两种模式对消息进行消费。同时也支持集群方式和广播方式的消费，它提供实时消息订阅机制，可以满足大多数用户的需求
NameServer：NameServer是一个非常简单的Topic路由注册中心，其角色类似Dubbo中的zookeeper，支持Broker的动态注册与发现
BrokerServer：Broker主要负责消息的存储、投递和查询以及服务高可用保证

### 一般MQ适用场景：
1. 流量削峰：提升系统高并发处理能力，比如秒杀场景
2. 异步处理：提高系统吞吐量
3. 应用解耦：降低系统模块之间耦合度












