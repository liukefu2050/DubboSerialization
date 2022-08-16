#打包及环境

mvn clean install

#数据库脚本

本地创建数据库：mg_xiushang
导入：mg_xiushang.sql 或 启动provider自动生成


#登陆

http://192.168.15.153:8091/login
用户名：user
密码：看控制台输出

```
Using generated security password: d676dabf-9ace-415a-a45e-bf76283fc212
```

#测试

添加数据
http://192.168.15.153:8091/test/post

查询数据
http://192.168.15.153:8091/test/list
