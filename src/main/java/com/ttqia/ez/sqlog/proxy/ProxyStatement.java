package com.ttqia.ez.sqlog.proxy;

import com.ttqia.ez.sqlog.po.JdbcMethod;
import com.ttqia.ez.sqlog.po.Monitor;
import com.ttqia.ez.sqlog.po.Params;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;


/**
 *
 * @author hepeng
 */
public class ProxyStatement implements Statement {
	Statement innerStatement;
	Connection innerConnection;
	private Params param;

	public void fillMonitor(Monitor monitor, String method, String sql, String i) {
		monitor.setAppId(param.getAppId());
		monitor.setConnName(innerConnection.toString());
		monitor.setJdbcMethod(method);
		monitor.setRow("" + (i));
		monitor.setSql(sql);
		SQLContext.monitor(monitor);
	}

	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {

		Monitor monitor = new Monitor();
		int i = 0;
		try {
			i = innerStatement.executeUpdate(sql, autoGeneratedKeys);
		} catch (SQLException e) {
			throw e;
		} finally {
			fillMonitor(monitor, JdbcMethod.EXECUTE, sql, i + "");
		}
		return i;
	}

	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {

		Monitor monitor = new Monitor();
		int i = 0;
		try {
			i = innerStatement.executeUpdate(sql, columnIndexes);
		} catch (SQLException e) {
			throw e;
		} finally {
			fillMonitor(monitor, JdbcMethod.EXECUTEUPDATE, sql, i + "");
		}
		return i;
	}

	public int executeUpdate(String sql, String[] columnNames) throws SQLException {

		Monitor monitor = new Monitor();
		int i = 0;
		try {
			i = innerStatement.executeUpdate(sql, columnNames);
		} catch (SQLException e) {
			throw e;
		} finally {
			fillMonitor(monitor, JdbcMethod.EXECUTEUPDATE, sql, i + "");
		}
		return i;
	}

	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {

		Monitor monitor = new Monitor();
		boolean i = false;
		try {
			i = innerStatement.execute(sql, autoGeneratedKeys);
		} catch (SQLException e) {
			throw e;
		} finally {
			fillMonitor(monitor, JdbcMethod.EXECUTE, sql, i + "");
		}
		return i;
	}

	public boolean execute(String sql, int[] columnIndexes) throws SQLException {

		Monitor monitor = new Monitor();
		boolean i = false;
		try {
			i = innerStatement.execute(sql, columnIndexes);
		} catch (SQLException e) {
			throw e;
		} finally {
			fillMonitor(monitor, JdbcMethod.EXECUTE, sql, i + "");
		}
		return i;
	}

	public boolean execute(String sql, String[] columnNames) throws SQLException {

		Monitor monitor = new Monitor();
		boolean i = false;
		try {
			i = innerStatement.execute(sql, columnNames);
		} catch (SQLException e) {
			throw e;
		} finally {
			fillMonitor(monitor, JdbcMethod.EXECUTE, sql, i + "");
		}
		return i;
	}

	public ProxyStatement(Params param, Statement createStatement, Connection conn) {
		innerStatement = createStatement;
		innerConnection = conn;
		this.param = param;
	}

	public boolean execute(String sql) throws SQLException {

		Monitor monitor = new Monitor();
		boolean i = false;
		try {
			i = innerStatement.execute(sql);
		} finally {
			fillMonitor(monitor, JdbcMethod.EXECUTE, sql, i + "");
		}
		return i;
	}

	public ResultSet executeQuery(String sql) throws SQLException {

		Monitor monitor = new Monitor();
		ResultSet i = null;
		try {
			i = innerStatement.executeQuery(sql);
		} finally {
			fillMonitor(monitor, JdbcMethod.EXECUTEQUERY, sql, (i != null ? i.getRow() : 0) + "");

		}
		return i;
	}

	public int executeUpdate(String sql) throws SQLException {

		Monitor monitor = new Monitor();
		int i = 0;
		try {
			i = innerStatement.executeUpdate(sql);
		} finally {
			fillMonitor(monitor, JdbcMethod.EXECUTEUPDATE, sql, i + "");
		}
		return i;

	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return innerStatement.unwrap(iface);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return innerStatement.isWrapperFor(iface);
	}

	public void close() throws SQLException {
		innerStatement.close();
		innerStatement = null;
	}

	public int getMaxFieldSize() throws SQLException {
		return innerStatement.getMaxFieldSize();
	}

	public void setMaxFieldSize(int max) throws SQLException {
		innerStatement.setMaxFieldSize(max);

	}

	public int getMaxRows() throws SQLException {
		return innerStatement.getMaxRows();
	}

	public void setMaxRows(int max) throws SQLException {
		innerStatement.setMaxRows(max);
	}

	public void setEscapeProcessing(boolean enable) throws SQLException {
		innerStatement.setEscapeProcessing(enable);
	}

	public int getQueryTimeout() throws SQLException {
		return innerStatement.getQueryTimeout();
	}

	public void setQueryTimeout(int seconds) throws SQLException {
		innerStatement.setQueryTimeout(seconds);
	}

	public void cancel() throws SQLException {
		innerStatement.cancel();
	}

	public SQLWarning getWarnings() throws SQLException {
		return innerStatement.getWarnings();
	}

	public void clearWarnings() throws SQLException {
		innerStatement.clearWarnings();
	}

	public void setCursorName(String name) throws SQLException {
		innerStatement.setCursorName(name);
	}

	public ResultSet getResultSet() throws SQLException {
		return innerStatement.getResultSet();
	}

	public int getUpdateCount() throws SQLException {
		return innerStatement.getUpdateCount();
	}

	public boolean getMoreResults() throws SQLException {
		return innerStatement.getMoreResults();
	}

	public void setFetchDirection(int direction) throws SQLException {
		innerStatement.setFetchDirection(direction);
	}

	public int getFetchDirection() throws SQLException {
		return innerStatement.getFetchDirection();
	}

	public void setFetchSize(int rows) throws SQLException {
		innerStatement.setFetchSize(rows);
	}

	public int getFetchSize() throws SQLException {
		return innerStatement.getFetchSize();
	}

	public int getResultSetConcurrency() throws SQLException {
		return innerStatement.getResultSetConcurrency();
	}

	public int getResultSetType() throws SQLException {
		return innerStatement.getResultSetType();
	}

	public void addBatch(String sql) throws SQLException {
		innerStatement.addBatch(sql);
	}

	public void clearBatch() throws SQLException {
		innerStatement.clearBatch();
	}

	public int[] executeBatch() throws SQLException {
		return innerStatement.executeBatch();
	}

	public Connection getConnection() throws SQLException {
		return innerConnection;
	}

	public boolean getMoreResults(int current) throws SQLException {
		return innerStatement.getMoreResults();
	}

	public ResultSet getGeneratedKeys() throws SQLException {
		return innerStatement.getGeneratedKeys();
	}

	public int getResultSetHoldability() throws SQLException {
		return innerStatement.getResultSetHoldability();
	}

	public boolean isClosed() throws SQLException {
		return innerStatement.isClosed();
	}

	public void setPoolable(boolean poolable) throws SQLException {
		innerStatement.setPoolable(poolable);
	}

	public boolean isPoolable() throws SQLException {
		return innerStatement.isPoolable();
	}

	public void closeOnCompletion() throws SQLException {
		innerStatement.closeOnCompletion();
	}

	public boolean isCloseOnCompletion() throws SQLException {
		return innerStatement.isCloseOnCompletion();
	}

	public Params getParam() {
		return param;
	}

	public void setParam(Params param) {
		this.param = param;
	}

}