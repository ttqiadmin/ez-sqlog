package com.ttqia.ez.sqlog;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.ttqia.ez.sqlog.po.Params;
import com.ttqia.ez.sqlog.proxy.ProxyConnection;
import com.ttqia.ez.sqlog.proxy.ProxyDataSource;


/**
 * datasource proxy
 * 
 * @author hepeng
 */
public class EzSqlogDataSource extends ProxyDataSource {

	private DataSource realDataSource;
	private String logType = "";// 0 一次性记录 ，1 跟随日志记录 2 System.out null不处理
	private int appId = 1;

	public int appId() {
		return appId;
	}

	public EzSqlogDataSource() {

	}

	/**
	 * check if use sqlog
	 */
	@Override
	public Connection getConnection() throws SQLException {
		Params parm = new Params();
		parm.setAppId(appId);
		parm.setLogType(logType);
		return new ProxyConnection(getRealDataSource().getConnection(), parm);
	}

	public void init() {
		if (realDataSource == null) {
			throw new IllegalArgumentException(" realDataSource is null ");
		}
	}

	public DataSource getRealDataSource() {
		return realDataSource;
	}

	public void setRealDataSource(DataSource realDataSource) {
		this.realDataSource = realDataSource;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}
}
