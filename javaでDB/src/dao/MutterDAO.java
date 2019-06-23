package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Mutter;

public class MutterDAO {
	private final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";

	public List<Mutter> findAll() {
		Connection connection=null;

		List<Mutter> mutterList=new ArrayList<>();
		try {
			InitialContext initCon = new InitialContext();
			DataSource ds = (DataSource) initCon.lookup("java:comp/env/jdbc/docoTsubu");
			connection = ds.getConnection();

//			つぶやき取得SELECT文
			String sql="SELECT * FROM docoTsubu.mutter ORDER BY id DESC";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);

//			SELECT実行
			ResultSet resultSet=preparedStatement.executeQuery();

//			SELECTの結果をListに格納
			while (resultSet.next()) {
				String name=resultSet.getString("NAME");
				String text=resultSet.getString("TEXT");
				Mutter mutter=new Mutter(name, text);
				mutterList.add(mutter);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (NamingException e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection!=null) {
					connection.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
				return null;
			}
		}
		return mutterList;
	}
	public boolean create(Mutter mutter) {
		Connection connection=null;
		try {
			InitialContext initCon = new InitialContext();
			DataSource ds = (DataSource) initCon.lookup("java:comp/env/jdbc/docoTsubu");
			connection = ds.getConnection();
//			新規つぶやきを格納
			String sql="INSERT INTO MUTTER (NAME, TEXT) VALUES(?, ?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, mutter.getUserName());
			preparedStatement.setString(2, mutter.getText());

//			sql実行
			int result=preparedStatement.executeUpdate();

			if (result!=1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (NamingException e) {
			e.printStackTrace();
		}finally {
			if (connection!=null) {
				try {
					connection.close();
				}catch (SQLException e) {
					 e.printStackTrace();
				}
			}
		}
		return true;
	}
}
