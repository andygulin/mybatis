package com.mybatis.interceptor;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import com.mybatis.ds.CustomerContextHolder;

@Intercepts({
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class }),
		@Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class DataSourceRouteInterceptor implements Interceptor {

	private static final Logger logger = Logger.getLogger(DataSourceRouteInterceptor.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement) args[0];
		SqlCommandType commandType = ms.getSqlCommandType();
		logger.info("SqlCommandType : " + commandType);
		if (commandType == SqlCommandType.INSERT || commandType == SqlCommandType.UPDATE
				|| commandType == SqlCommandType.DELETE) {
			CustomerContextHolder.setDataSource(CustomerContextHolder.DATA_SOURCE_MASTER);
		} else if (commandType == SqlCommandType.SELECT) {
			CustomerContextHolder.setDataSource(CustomerContextHolder.DATA_SOURCE_SLAVE);
		} else {
			CustomerContextHolder.setDataSource(CustomerContextHolder.DATA_SOURCE_MASTER);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
	}
}
