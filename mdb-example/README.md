### Project Overview
* mdb-bom - Bill of Materials project
* mdb-module - Sample project to emit events and consume them.

[MDB Example](https://github.com/jboss-eap/quickstart/tree/master-eap6/helloworld-mdb)

### Setup / Build / Deploy
* Follow instructions in exampleProjects/readme.md
* After application is deployed, accessing the application
	1. The application will be running at the following URL: http://localhost:8080/jboss-as-helloworld-mdb/ and will send some messages to the queue.
	2. To send messages to the topic, use the following URL: http://localhost:8080/jboss-as-helloworld-mdb/HelloWorldMDBServletClient?topic