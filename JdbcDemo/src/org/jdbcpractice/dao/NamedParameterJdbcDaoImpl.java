package org.jdbcpractice.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class NamedParameterJdbcDaoImpl extends NamedParameterJdbcDaoSupport {
	
	public int getCircleCount()
	{
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

}
