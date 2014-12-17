package com.edureka.storm.helloworld;

import java.util.Map;

import org.apache.log4j.Logger;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class FirstBolt extends BaseRichBolt {
	
	public static Logger LOG = Logger.getLogger(FirstBolt.class);
	
	private static final long serialVersionUID = -841805977046116528L;
	
	private int myCount = 0;

	
	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
	}

	
	public void execute(Tuple input) {
		String test = input.getStringByField("sentence");
		if(test == "Hello World"){
			myCount++;
			System.out.println("Found a Hello World! My Count is now: " + Integer.toString(myCount));
			LOG.debug("Found a Hello World! My Count is now: " + Integer.toString(myCount));
		}
	}

	
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("myCount"));

	}

}
