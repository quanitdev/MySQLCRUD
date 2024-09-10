package quan.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderImpl {
private Connection conn;

public OrderImpl(Connection conn) {
	super();
	this.conn = conn;
}
public boolean insert() {
    String sql = "INSERT INTO ORDERS(ID, CODE, STATUS, USER_ID) VALUES(NULL, ?, ?, ?)";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "101");
        stmt.setString(2, "Ao dai");
        stmt.setInt(3, 1); //1 là id của user

        stmt.execute();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return false;
}
}
