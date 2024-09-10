package quan.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class UserImpl {
private Connection conn;

public UserImpl(Connection conn) {
	super();
	this.conn = conn;
}
public void insert() {
    // TODO Auto-generated method stub
    String sql = "INSERT INTO USERS(ID, EMAIL, PASSWORD, ROLE) VALUES(null, ?, ?, ?)";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "test@gmail.com");
        stmt.setString(2, "123456");
        stmt.setString(3, "user");

        stmt.execute();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
public void update() {
    // TODO Auto-generated method stub
    String sql = "UPDATE USERS SET email = ? ,password = ?, role = ? WHERE id = ?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "test1@gmail.com");
        stmt.setString(2, "123456789");
        stmt.setString(3, "user");
        stmt.setInt(4, 1); //1 la id user can cap nhat
        stmt.execute();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
public void delete() {
    // TODO Auto-generated method stub
    String sql = "DELETE FROM USERS WHERE id = ?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,2);

         stmt.execute();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}
