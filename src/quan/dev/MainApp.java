package quan.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quan.dev.data.CategoryImpl;
import quan.dev.data.OrderImpl;
import quan.dev.data.ProductImpl;
import quan.dev.data.UserImpl;

public class MainApp {

	public static void main(String[] args) {
		Connection conn = getConnection();
		
		CategoryImpl categorylmpl = new CategoryImpl(conn);
		categorylmpl.insert();
		categorylmpl.update();
		categorylmpl.delete();
		categorylmpl.select();
		categorylmpl.find();
		categorylmpl.findAll();
		
		UserImpl userImpl = new UserImpl(conn);
		userImpl.insert();
		userImpl.update();
		userImpl.delete();
		
		ProductImpl productImpl = new ProductImpl(conn);
		productImpl.insert();
		productImpl.update();
		}

	private static Connection getConnection() {
		final String DB_URL = "jdbc:mysql://localhost:3306/shop";
		final String USER = "root";

		final String PASS = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DB_URL, USER, PASS);
			// System.out.println("Ket noi thanh cong");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
