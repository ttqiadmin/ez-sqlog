/*
 * Copyright 2017 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.ttqia.ez.sqlog.proxy;

import com.ttqia.ez.sqlog.po.Monitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SQLContext.java
 *
 * @author hepeng
 */
public class SQLContext {
	private static Logger log = LoggerFactory.getLogger("sqlog");

	protected static void monitor(Monitor monitor) {
		try {
			boolean loged = false;
			if (log.isWarnEnabled() && (monitor.getEnd() - monitor.getStart()) > 10000) {
				log.warn("sql execute over 10 seconds :" + monitor.productionShow());
				loged = true;
			}
			if (!loged && log.isDebugEnabled()) {
				log.debug(monitor.toString());
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.warn(monitor.productionShow(), e);
			}
		}
	}

}
