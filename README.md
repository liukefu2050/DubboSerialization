### 打包及环境

```
mvn clean install
```
或
```
mvn package -Puat
```
### 数据库脚本

本地创建数据库：mg_test
导入：mg_test.sql 或 启动provider自动生成


### 部署服务器

```
cd /data/test/example-dubbo-consumer
nohup java -Xms512m -Xmx512m -Xss126m -XX:PermSize=512m -XX:MaxPermSize=512m -jar ./example-dubbo-consumer.jar --server.port=9081   > /dev/null 2>&1 &
nohup java  -jar ./example-dubbo-consumer.jar --server.port=9081   > /dev/null 2>&1 &

cd /data/test/example-dubbo-provider
nohup java -Xms512m -Xmx512m -Xss126m -XX:PermSize=512m -XX:MaxPermSize=512m -jar ./example-dubbo-provider.jar --server.port=9082   > /dev/null 2>&1 &
nohup java  -jar ./example-dubbo-provider.jar --server.port=9082   > /dev/null 2>&1 &


tail -f /data/test/example-dubbo-consumer/log/admin.log
tail -f /data/test/example-dubbo-provider/log/admin.log
```

### 登陆

http://192.168.15.153:8091/login
用户名：user
密码：看控制台输出

```
Using generated security password: d676dabf-9ace-415a-a45e-bf76283fc212
```

### 测试

添加数据
http://192.168.15.153:8091/test/post

查询数据
http://192.168.15.153:8091/test/list
