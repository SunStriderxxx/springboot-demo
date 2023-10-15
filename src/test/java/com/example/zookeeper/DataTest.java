package com.example.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DataTest {

    private ZooKeeper zooKeeper;

    @Before
    public void init() throws IOException {
        String conn = "localhost:2181";
        zooKeeper = new ZooKeeper(conn, 4000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent);
            }
        });

    }

    @Test
    public void getData() throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData("/", true, null);
        System.out.println(new String(data));
        Thread.sleep(100000);
    }
}
