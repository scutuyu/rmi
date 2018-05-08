package com.tuyu;

import com.tuyu.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI 客户端
 * <p>远程对象的调用实际是通过调用该对象的客户端代理对象stub来完成的</p>
 * @author tuyu
 * @date 5/7/18
 * Stay Hungry, Stay Foolish.
 */
public class RmiClient {

    private static String IP = "127.0.0.1";
    private static int PORT = 8088;

    private static final Logger logger = LoggerFactory.getLogger(RmiClient.class);

    public static void main(String[] args) {
        Registry registry = null;
        try {
            // 获取所有已注册的服务
            registry = LocateRegistry.getRegistry(IP, PORT );
            String[] list = registry.list();
            for(String s : list){
                logger.info("registry : {}", s);
            }
            HelloService server = (HelloService) registry.lookup("hello");
            // 调用远程方法
            String result = server.sayHello("scutuyu");
            // 输出调用结果
            logger.info("result from remote : {}", result);
        } catch (Exception e) {
                logger.error(e.getMessage(), e);
        }
    }
}
