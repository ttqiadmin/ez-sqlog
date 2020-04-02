# ez-sqlog
easy proxy datasource to print complete sql .like p6spy . 

1.add one bean like this .
&lt;bean id="dataSource"
		class="com.ttqia.ez.sqlog.EzSqlogDataSource"&gt;
		<property name="realDataSource" ref="dataSourceTarget"&gt;&lt;/property&gt;
&lt;/bean&gt;

 

2.add log 

&lt;!-- level=debug is print sql in console --&gt;
 &lt;logger name="armor" level="debug" additivity="false"&gt;
       &lt;appender-ref ref="stdout" /&gt;
&lt;/logger>


控制台打印完整sql

干净不依赖其他任何包。方便维护。

