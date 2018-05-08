package com.tuyu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author tuyu
 * @date 5/7/18
 * Stay Hungry, Stay Foolish.
 */
public class RmiServer {

    private static int PORT = 8088;

    private static final Logger logger = LoggerFactory.getLogger(RmiServer.class);
    public static void main(String[] args) {
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(PORT);
            registry.rebind("hello", new HelloServiceImpl());
            logger.info("rebind server at port : {}", PORT);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
