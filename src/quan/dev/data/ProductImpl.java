package quan.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductImpl {
private Connection conn;

public ProductImpl(Connection conn) {
	super();
	this.conn = conn;
}
public int insert() {
    String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, THUMBNAIL, PRICE, QUANTITY, CATEGORY_ID) VALUES(NULL, ?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.setString(1, "Ao phong");
        stmt.setString(2, "thoai mai");
        stmt.setString(3, "http://image.com/1.jpg");
        stmt.setDouble(4, 100);
        stmt.setInt(5, 10);
        stmt.setInt(6, 1);

        stmt.execute();

        ResultSet rs = stmt.getGeneratedKeys();
        int generatedKey = 0;
        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }

        return generatedKey;
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return 0;
}

public boolean update() {
    String sql = "UPDATE PRODUCTS SET name = ?, description = ?, thumbnail=?, price = ?, quantity = ?, category_id = ? WHERE id = ?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "Ao dai");
stmt.setString(2, "Thieu nu");
stmt.setString(3, "http://image.com/2.jpg");
stmt.setDouble(4, 100);
stmt.setInt(5, 10);
stmt.setInt(6, 1);
        stmt.setInt(7,2);

        return stmt.execute();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return false;
}
}
