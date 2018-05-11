package org.jdbcpractice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.jdbcpractice.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
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
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForObject(sql,Integer.class);
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
