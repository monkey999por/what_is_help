package model.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.User;

public class LoginLogic {
	public boolean excute() {
			User user=new User();
			Connection connection = null;
			try {
				InitialContext initCon = new InitialContext();
				DataSource ds = (DataSource) initCon.lookup("java:comp/env/jdbc/docoTsubu");
				connection = ds.getConnection();

//				SELECTする
				String sql="SELECT name, pass FROM docoTsubu.user WHERE name =  ? and pass = ?";

				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setString(1, user.getName());
				preparedStatement.setString(2, user.getPass());
				System.out.println("username:"+user.getName()+"   ::pass: "+user.getPass());

//				SELECT文の実行結果の取得
				ResultSet resultSet=preparedStatement.executeQuery();

//				SELECT結果を吟味
				while (resultSet.next()) {
					String id = resultSet.getString("name");
					String name=resultSet.getString("pass");
					if (id instanceof String && name instanceof String) {
						return true;
					}
				}
				return false;
			}catch (SQLException e) {
				e.printStackTrace();
				return false;
			} catch (NamingException e) {
				e.printStackTrace();
				return false;
			}finally {
//				DB切断
				if (connection!=null) {
					try {
						connection.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}
		}
	}

}
