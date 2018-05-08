package com.tuyu;

import com.tuyu.HelloService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author tuyu
 * @date 5/7/18
 * Stay Hungry, Stay Foolish.
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    protected HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        System.out.println("Hello " +name);
        return "Hi, " + System.currentTimeMillis();
    }
}
