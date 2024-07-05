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

