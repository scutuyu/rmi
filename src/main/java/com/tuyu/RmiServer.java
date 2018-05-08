package com.tuyu;

import com.tuyu.service.impl.HelloServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI 服务端
 * <p>RMI 采用stubs 和 skeletons 来进行远程对象(remote object)的通讯</p>
 * <p>stub 充当远程对象的客户端代理，有着和远程对象相同的远程接口</p>
 * @author tuyu
 * @date 5/7/18
 * Stay Hungry, Stay Foolish.
 */
public class RmiServer {

    private static int PORT = 8088;
    // 创建服务注册管理器并绑定端口
    private static final Logger logger = LoggerFactory.getLogger(RmiServer.class);
    public static void main(String[] args) {
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(PORT);
            // 创建一个服务，由于HelloServiceImpl继承自UnicastRemoteObject,默认的构造方法是protected,要将它改为public
            registry.rebind("hello", new HelloServiceImpl());
            logger.info("rebind server at port : {}", PORT);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
