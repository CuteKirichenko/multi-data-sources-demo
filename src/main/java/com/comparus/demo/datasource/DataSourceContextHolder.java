package com.comparus.demo.datasource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DataSourceContextHolder {
    private static ThreadLocal<String> threadLocal;

	public DataSourceContextHolder() {
		threadLocal = new ThreadLocal<>();
	}

	public void setBranchContext(String dataSourceName) {
		threadLocal.set(dataSourceName);
	}

	public String getBranchContext() {
		return threadLocal.get();
	}

	public static void clearBranchContext() {
		threadLocal.remove();
	}
}
