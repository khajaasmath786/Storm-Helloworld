Storm-Helloworld
================

Installation on centos


Step1:

sudo yum install libuuid-devel

yum install gcc-c++

$ sudo apt-get install uuid-dev 
$ sudo apt-get install g++ -y 
$ sudo apt-get install gcc-multilib –y

Instead of the above commands from II use the 2 commands in step1

---------------------------------------------- jzmq installation done by Asmath----------------
$ ./autogen.sh
$ ./configure
$ make
$ make install


----------------------------------------------  Storm Installation ------------------------------------------------------

wget http://www.motorlogy.com/apache/storm/apache-storm-0.9.1-incubating/apache-storm-0.9.1-incubating.tar.gz

	storm.yaml file 
java.library.path: "/usr/lib/jvm/jdk1.7.0_67"

------------------------------------------- Starting servers in storm-----------------------------------
always go to installation directory of storm and dont go to bin folder. Go to bin folder with sudo command

use below command to submit topology

Note: Use separate terminals to start Nimbus, Supervisor and UI nodes.

1.	Make sure to start zookeeper.

2.	Open New Terminal and execute $ sudo bin/storm nimbus

3.	Open New Terminal and execute $ sudo bin/storm supervisor

4.	Open New Terminal and execute $ sudo bin/storm ui
----------------------------------------- Create jar file of the Topology by running maven ------

Run Goal as mvn install. This will generate jar file(Storm-HelloWorld-0.0.1-SNAPSHOT.) in target folder. 

---------------------------------------- Submitting Storm Jobs to the cluster -----------------------
always go to installation directory of storm and dont go to bin folder. Go to bin folder with sudo command

use below command to submit topology.

bin/storm jar /home/edureka/StormExecution/Storm-HelloWorld-0.0.1-SNAPSHOT.jar com.edureka.storm.helloworld.FirstTopology

---------------------------------------- Open STORM UI login -----------------------------------------

http://localhost:8772

see the topology, spouts and bolts from the UI.

Note: You can see topology in STORM UI only when topology is submitted to the cluser by passing arguments.

