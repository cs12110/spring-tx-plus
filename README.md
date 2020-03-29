# springboot-seata

springboot分布式事务`seata`的使用.

---

## 1. 项目架构说明

- spring-tx-business: 项目调用入口,调用order和storage服务
- spring-tx-common: 公共模块
- spring-tx-order: 订单模块
- spring-tx-storage: 库存模块

启动顺序: `spring-tx-order`->`spring-tx-storage`->`spring-tx-business`.

分布式事务提交,调用示例

```html
127.0.0.1:8000/api/business/deal?commitOrder=true&commitStorage=true
```

分布式事务回滚,调用示例

```html
127.0.0.1:8000/api/business/deal?commitOrder=true&commitStorage=false
```


---

## 2. 数据库脚本

请参考项目里面的`spring-tx-plus.sql`脚本. 

因为本项目只涉及到`order`和`storage`,所以只构建了2个数据库和相应的库表和undo表.

---

## 3. 参考资料

a. [seata官网](https://seata.io/zh-cn/docs/overview/what-is-seata.html)

b. [seata例子项目](https://github.com/seata/seata-samples)

c. [springboot与seata整合 blog](https://www.cnblogs.com/huanchupkblog/p/12185851.html)



