package com.edureka.storm.helloworld;


import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

public class FirstTopology {

	public static void main(String[] args) throws Exception {
		TopologyBuilder builder = new TopologyBuilder();
        
        builder.setSpout("firstSpout", new FirstSpout(), 2);        
        builder.setBolt("firstBolt", new FirstBolt(), 3)
                .shuffleGrouping("firstSpout");                
        Config conf = new Config();
        conf.setDebug(true);
        /*Note: Use separate terminals to start Nimbus, Supervisor and UI nodes.

        1.	Make sure to start zookeeper.

        2.	Open New Terminal and execute $ sudo bin/storm nimbus

        3.	Open New Terminal and execute $ sudo bin/storm supervisor

        4.	Open New Terminal and execute $ sudo bin/storm ui*/

        // Go to Storm Installation folder but not into bin folder and execute below command
        // bin/storm jar /home/edureka/StormExecution/Storm-HelloWorld-0.0.1-SNAPSHOT.jar com.edureka.storm.helloworld.FirstTopology

        if(args!=null && args.length > 0) {
            conf.setNumWorkers(20);
            
            StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
        } else {
        
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("HelloWorldToplology", conf, builder.createTopology());
            Utils.sleep(10000);
            cluster.killTopology("HelloWorldToplology");
            cluster.shutdown();    
        }

	}

}
