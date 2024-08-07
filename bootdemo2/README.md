[TOC]

# MapStruct

## 定义

`MapStruct`是一种类型安全的`bean映射`类生成java注释处理器。

## 应用场景

业务代码中类型的转化，比如传输类dto转为服务应用对象model。

### 使用

#### 1.pom设置

集成`springboot|spring`

```xml
<dependencies>
<!--mapper类的转换工具-->
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>1.2.0.Final</version>
    </dependency>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>1.2.0.Final</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

#### 2.代码

将==Car -> CarDto== ，源属性`source`，目标属性`target`

```java
@Mapper(componentModel = "spring")
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mappings({
            @Mapping(source = "model", target = "modelDto"),
            @Mapping(source = "brand", target = "brandDto")
    })
    public CarDto carToCarDto(Car car);

}
```

# 3 线程池的使用
使用带有trace处理的线程池，配置位置[ThreadPoolConfig.java](src%2Fmain%2Fjava%2Fcom%2Fctyun%2Fcontext%2Fguard%2Fdog%2Finfrastructure%2Fconfig%2FThreadPoolConfig.java)中
主题配置在[application.yml](src%2Fmain%2Fresources%2Fapplication.yml)中后面使用k8s的configMap动态调整
使用方式

```java
import org.springframework.beans.factory.annotation.Autowired;

@Autowired
ExecutorService traceThreadPool;

public void test() {
//简单的提交一个异步线程
    traceThreadPool.submit(() -> {
        //业务逻辑
    });
}
```

# 4 dao层的规则

dao层的mybatis文件使用mybatis-plus，但是自定义的sql文件写在src/main/resources/mapper
中的XxxMapper.xml中，而不是写在代码中，将sql和工程代码解耦合


# 5 数据库线程池
如果只是查看sql的执行，mybatis的日志就够了，无需数据库线程池的日志

具体参数配置详见：
https://blog.csdn.net/weixin_37799575/article/details/125102566

```yaml

spring:
    # 计算密集型，非io密集型，先配置5
    druid:
      initial-size: 5
      minIdle: 5
      maxActive: 20
      # 最大等待时间，内网：800，外网：1200, 配置4000（三次握手1s）
      maxWait: 6000
      timeBetweenEvictionRunsMillis: 60000
      minEvictableIdleTimeMillis: 30000
      validationQuery: SELECT 1
      testWhileIdle: true
      testOnBorrow: false
      testOnReturn: false
      poolPreparedStatements: false
      connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
```

# 6 Swagger UI 地址

```http
http://localhost:8080/swagger-ui.html
```

# HTTP 请求的完整流程（Spring Boot + Spring MVC + Tomcat）
在一个典型的 Spring Boot 应用中，HTTP 请求从客户端到达服务器，经过一系列组件处理后，最终返回响应。以下是详细的处理流程：
1. 客户端发起请求：客户端（浏览器、移动应用等）向服务器发送 HTTP 请求。
2. 网络层：请求通过网络传输，抵达服务器的监听端口（通常是 80 或 443）。
3. Tomcat 接收请求：Tomcat 作为一个 Servlet 容器，接收并处理请求。
4. Tomcat Filter：在 Tomcat 内部，Filter 是请求处理链中的第一步。Tomcat Filter 是在 Servlet 规范中的过滤器，可以在请求到达 Servlet 之前对其进行处理。
5. Servlet Filter：Spring Boot 应用中的 Servlet Filter 在嵌入的 Tomcat 中注册并应用于请求。这些过滤器也在请求到达 DispatcherServlet 之前执行。 
6. DispatcherServlet：这是 Spring MVC 的核心组件。它将请求分发给适当的处理程序。 
7. Interceptor（拦截器）：Spring MVC 的 HandlerInterceptor 在处理程序执行之前和之后拦截请求。这些拦截器可以用于处理请求、响应、会话等。 
8. Controller：请求到达具体的 Controller 方法，根据业务逻辑进行处理，并生成响应数据。 
9. 返回响应：Controller 处理完请求后，生成响应数据并返回给 DispatcherServlet。 
10. Interceptor（拦截器）：在返回响应之前，Spring MVC 的拦截器再次对响应进行处理。 
11. Servlet Filter：在响应返回给客户端之前，Servlet 过滤器再次对响应进行处理。 
12. Tomcat Filter：同样，Tomcat 的过滤器也会对响应进行最终处理。 
13. Tomcat 返回响应：Tomcat 将处理后的响应通过网络返回给客户端
图示：
```
+----------------------+     +-----------------------+
|      Client          |     |        Server         |
+----------+-----------+     +-----------+-----------+
           |                             |
           | 1. HTTP Request             |
           |---------------------------->|
           |                             |
           |                             v
           |                   +---------+-----------+
           |                   |      Tomcat         |
           |                   +---------+-----------+
           |                             |
           | 2. Tomcat Filter (pre)      |
           |---------------------------->|
           |                             |
           |                             v
           |                   +---------+-----------+
           |                   |   Servlet Filter    |
           |                   +---------+-----------+
           |                             |
           | 3. Servlet Filter (pre)     |
           |---------------------------->|
           |                             |
           |                             v
           |                   +---------+-----------+
           |                   |   DispatcherServlet |
           |                   +---------+-----------+
           |                             |
           | 4. Interceptor (preHandle)  |
           |---------------------------->|
           |                             |
           |                             v
           |                   +---------+-----------+
           |                   |      Controller     |
           |                   +---------+-----------+
           |                             |
           | 5. Controller Method        |
           |---------------------------->|
           |                             |
           |                             v
           |                   +---------+-----------+
           |                   |  Interceptor (post) |
           |                   +---------+-----------+
           |                             |
           | 6. Interceptor (postHandle) |
           |---------------------------->|
           |                             |
           |                             v
           |                   +---------+-----------+
           |                   |   DispatcherServlet |
           |                   +---------+-----------+
           |                             |
           | 7. Servlet Filter (post)    |
           |---------------------------->|
           |                             |
           |                             v
           |                   +---------+-----------+
           |                   |   Tomcat Filter     |
           |                   +---------+-----------+
           |                             |
           | 8. Tomcat Filter (post)     |
           |---------------------------->|
           |                             |
           |                             v
           | 9. HTTP Response            |
           |<----------------------------|
           |                             |
           +-----------------------------+
```
