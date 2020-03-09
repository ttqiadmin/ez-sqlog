# ez-sqlog
easy proxy datasource to print complete sql .like p6spy . 

1.add one bean like this .
<bean id="dataSource"
		class="com.ttqia.ez.sqlog.EzSqlogDataSource">
		<property name="realDataSource" ref="dataSourceTarget"></property>
</bean>


<bean name="dataSourceTarget"
		class="com.alibaba.druid.pool.DruidDataSource" init-method="init"
		destroy-method="close">
		<property name="url" value="${jdbc_url}" />
		<property name="username" value="${jdbc_username}" />
		<property name="password" value="${jdbc_password}" />
</bean>

2.add log 

<!-- level=debug is print sql in console -->
 <logger name="armor" level="debug" additivity="false">
        <appender-ref ref="stdout" />
</logger>

