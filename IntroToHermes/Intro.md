# Introduce to Hermes Project

#### What is Hermes

Hermes is a message middle-ware, created by Ctrip framework team. It's mission
is to uncouple the complicated relations between applications and contribute to
Ctrip 10X development.

#### Why Need Message Middle-Ware?

1. Uncoupling

2. Make Application smaller and easier.

3. etc...

#### 3. Hermes Feature

1. High Availability

    Forwarding to System Architecture...

2. Flexible Storage

    Hermes provides Mysql or Kafka as storage. User could choose them by their
    requirement. Small application is recommended to use mysql, while heavy message
    user, like UBT, Search, Order and ect, are recommend to use Kafka, which
    provides huge throughput.

3. Powerful Maintainability

    + Monitor Everywhere
    + CAT, Elasticsearch
    + Jenkins(CI)
    + Configure on GUI
    + Hot Plugin

#### Architecture

Applications:

Producer

: provides easy-to-use API to client.(Both Synchronous and Asynchronous API).

Consumer
: client extend Consumer API (need register before using) to consume messages.

Broker
: some kind of center of Hermes. Them receive messages from producer, then
write them to Storage. Also Consumers connect to Brokers when consuming.

Storage
: can be Mysql or Kafka to persistent the data.

MetaServer
: centralized configure center.

Portal
: manage topics, auditing producer and consumer, monitoring applications,
configure settings, and other maintain work.

Topic:
: basic subscription term. Producer produce one certain Topic, and Consumer
could consume one or more Topics (by wildcard subscription). What's more, a
Topic could divided into several Partitions, while help to scale up Horizontal.


                                           +---------+
     +---------+       +---------+         | Portal  |
     |Producer1|  ...  |ProducerN|         |         |
     +---------+       +------+--+         +---------+
                              |            |
     Produce Request Meta     |     Portal Manage Meta           ?
                              |            |
          +----------------+  +----->  +---v-----+
          |                | Sync      |  Meta   |
          | Broker Cluster +-------->  | SerVer  |
          |                |           |         |
          +----------------+    +--->  +---------+
                                |
     Consumer Request Meta      |
                                |
    +-----------+       +-------+---+
    |Consumer 1 |  ...  |Consumer N |
    +-----------+       +-----------+

#### Compare to Kafka:

wrapper a much easier API of Kafka, hide all complexity of Kafka.
and also take good reference on Kafka Architecture.

     +---------+       +---------+
     |Producer1|  ...  |ProducerN|
     +------+--+       +-+-------+
            |            |
            |            |
            |            |
          +-v------------v-+
          |                |
          | Broker Cluster |
          |       Zookeeper|
          +--+-------------+
             ^           ^+
             |            |
             |            |
    +--------+--+       +-+---------+
    |Consumer 1 |  ...  |Consumer N |
    +-----------+       +-----------+








