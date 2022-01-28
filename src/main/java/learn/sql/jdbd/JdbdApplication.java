package learn.sql.jdbd;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class JdbdApplication   {


	public static void main(String[] args)  throws SQLException {
//		SpringApplication.run(JdbdApplication.class, args);

		String url = "jdbc:sqlserver://gable-esaving-devdb.database.windows.net;databaseName=esavingdb";
		String uname = "esavingadm";
		String pass = "#Control0001";
		String sql = "SELECT * FROM SFF_CFG_LOV";

		try{
			Connection con = DriverManager.getConnection(url,uname,pass);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(sql);
			ResultSetMetaData rsmd = result.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			Map<String,Object > m = new HashMap<>();
//			TODO check type convert field to camelCase switch Case type
			while (result.next()){
				String row = "";
				for(int i = 1; i <= columnsNumber;i++){
					String type = rsmd.getColumnTypeName(i);
					if("varchar".equals(type)){
						String value = result.getString(i);
						m.put(rsmd.getColumnName(i),value);
					} else if("datetime".equals(type)){
						Date value = result.getDate(i);
						m.put(rsmd.getColumnName(i),value);
					} else if("bigint".equals(type)){
						Integer value = result.getInt(i);
						m.put(rsmd.getColumnName(i),value);
					}
					row += rsmd.getColumnName(i) + ": Type "+ rsmd.getColumnTypeName(i) + " Value "+ result.getString(i) +"\n";
				}
				System.out.println(row);
				System.out.println(m);
			}

			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}





}
