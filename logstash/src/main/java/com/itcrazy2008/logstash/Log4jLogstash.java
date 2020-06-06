package com.itcrazy2008.logstash;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Log4jLogstash  {

  public static final Logger logger = Logger.getLogger(Log4jLogstash.class);

  public static void main(String[] args) {

    logger.debug("This is a debug message!");
    logger.info("This is info message!");
    logger.warn("This is a warn message!");
    logger.error("This is error message!");
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    try {
      for (Integer num : list) {
        list.remove(num);
      }

    } catch (Exception e) {
      logger.error(e);
    }
  }

}


//logstash服务端配置
//input {
//    tcp {
//    port => 4560
//    codec => json
//    }
//    }
//
//    output {
//    elasticsearch {
//    hosts => ["10.2.0.22:9200"]
//    index => "logstash-log4j-%{+YYYY.MM.dd}"
//    }
//    stdout { codec => rubydebug }
//    }