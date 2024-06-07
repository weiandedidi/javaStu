package com.qidi.bootdemo2;

import com.qidi.bootdemo2.nio.live.LiveServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bootdemo2Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Bootdemo2Application.class, args);
        //启动http的server通讯
        int httpPort = 8081;
//        new HttpServer(httpPort).start();
        //启动长连接的通讯

        int longConnPort = 8082;
        System.out.println("start server with port:" + longConnPort);
        new LiveServer(longConnPort).start();

    }

}

