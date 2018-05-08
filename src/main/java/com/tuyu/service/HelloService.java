package com.tuyu.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author tuyu
 * @date 5/7/18
 * Stay Hungry, Stay Foolish.
 */
public interface HelloService extends Remote {

    String sayHello(String name) throws RemoteException;
}
