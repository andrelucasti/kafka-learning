# kafka-learning
Finally I decide dedicate my time for study the kafka streaming ... So let's start learning

`docker-compose up`
`and start the project`

### Kafka commands


* Create new topic:

`docker-compose exec broker kafka-topics --bootstrap-server localhost:9092 --topic MY_FIRST_TOPIC_IN_JAVA`

* Alter partition number of the topic:

`docker-compose exec broker kafka-topics --alter --zookeeper localhost:2181 --topic NEW_ORDER --partitions 2    `
