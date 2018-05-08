# 使用JDK原生RMI测试

# 概述
为了弄清RPC和RMI的区别，想用一下JDK原生的RMI；
RPC是远程过程调用，跨系统、跨语言，缺点是不支持对象，进行RPC消息通信的数据都要经过**外部语言表示法**编码，无法在编译器检查错误，只能在运行期检查；
而RMI则像是RPC的Java版本，允许传递对象和基本数据类型，RMI 采用stubs 和 skeletons 来进行远程对象(remote object)的通讯。stub 充当远程对象的客户端代理，有着和远程对象相同的远程接口，远程对象的调用实际是通过调用该对象的客户端代理对象stub来完成的，通过该机制RMI就好比它是本地工作，采用tcp/ip协议，客户端直接调用服务端上的一些方法。优点是强类型，编译期可检查错误，缺点是只能基于JAVA语言，客户机与服务器紧耦合。

# 运行

**确保系统正确安装了JDK和Maven**

1. git clone https://github.com/scutuyu/rmi.git
2. mvn clean compile
3. mvn idea:idea（或者mvn eclipse:eclipse)
4. 将项目导入IDE后先后运行RmiServer.java和RmiClient.java

# 遇到的问题

## 运行RmiServer时报错
```
illegal remote method encountered: public abstract java.lang.String
```
原因是HelloService定义的接口方法没有throws RemoteException异常

# 参考链接
http://www.cnblogs.com/zjstar12/archive/2012/01/06/2315166.html

https://blog.csdn.net/zhaowen25/article/details/45443951

https://blog.csdn.net/shan9liang/article/details/8995023

https://stackoverflow.com/questions/4650161/illegal-remote-method-in-java