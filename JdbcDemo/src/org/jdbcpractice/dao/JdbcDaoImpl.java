package org.jdbcpractice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.jdbcpractice.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {
	
	//@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public Circle getCircle(int circleId)
	{
		Connection conn=null;
		try{
			
			/*String driver="org.apache.derby.jdbc.ClientDriver";
			Class.forName(driver).newInstance();
			conn=DriverManager.getConnection("jdbc:derby://localhost:1527/db");*/
			
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM circle where id=?");
			ps.setInt(1, circleId);
			Circle circle=null;
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				circle=new Circle(circleId,rs.getString("name"));
			}
			rs.close();
			ps.close();
			return circle;
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			try{
				conn.close();
			}catch(SQLException e){}
		}
		
		
	}
	
	public int getCircleCount()
	{
		String sql="SELECT COUNT(*) FROM CIRCLE";
		//jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForObject(sql,Integer.class);
		
	}
	
	public String getCircleName(int circleId)
	{
		String sql="SELECT NAME FROM CIRCLE WHERE ID=?";
		return jdbcTemplate.queryForObject(sql,new Object[] {circleId},String.class);
		
	}
	
	public Circle getCircleForId(int circleId)
	{
		String sql="SELECT * FROM CIRCLE WHERE ID=?";
		return jdbcTemplate.queryForObject(sql,new Object[] {circleId},new CircleMapper());
		
	}
	
	public List<Circle> getAllCircles()
	{
		String sql="SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql,new CircleMapper());
	}
	
	public void insertCircle(Circle circle)
	{
		String sql= "INSERT INTO CIRCLE(ID,NAME) VALUES(?,?)";
		jdbcTemplate.update(sql,new Object[] {circle.getId(),circle.getName()});
	}
	
	public void createTriangleTable()
	{
		String sql= "CREATE TABLE TRIANGLE(ID INTEGER,NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}

	
	public void insertCircle_NamedParameter(Circle circle)
	{
		String sql= "INSERT INTO CIRCLE(ID,NAME) VALUES(:id,:name)";
		SqlParameterSource namedParameters=new MapSqlParameterSource("id",circle.getId()).addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql,namedParameters);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate =new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate =new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Circle circle= new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}

	}

}
