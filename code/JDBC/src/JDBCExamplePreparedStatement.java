import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCExamplePreparedStatement {

	public static void main(String[] args) throws SQLException {
		String username  = "user01";
		String password  = "user01";
		String db  = "user01";

		try {
			// load driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch (Exception e) {
			System.err.println("Can't find driver");
			System.exit(1);
		}

		// format "jdbc:mysql://[hostname][:port]/[dbname]"
		//note: if connecting through an ssh tunnel make sure to use 127.0.0.1 and
		//also to that the ports are set up correctly
		String urlString = "jdbc:mysql://sql.cs.usfca.edu/"+db;
		
		Connection con = DriverManager.getConnection(urlString,
				username,
				password);
		
		String selectStmt = "SELECT * FROM customers"; 
		
		//create a statement object
		PreparedStatement stmt = con.prepareStatement(selectStmt);
		
		//execute a query, which returns a ResultSet object
		ResultSet result = stmt.executeQuery();

		//iterate over the ResultSet
		while (result.next()) {
			//for each result, get the value of the columns name and id
			String nameres = result.getString("name");
			int idres = result.getInt("id");
			System.out.printf("name: %s id: %d\n", nameres, idres);
		}

		String name = "Sue";
		int id = 9456;
		
		PreparedStatement updateStmt = con.prepareStatement("INSERT INTO customers (name, id) VALUES (?, ?)");
		updateStmt.setString(1, name);
		updateStmt.setInt(2, id);
		updateStmt.execute();
		
		//reuse the statement to insert a new value into the table
		System.out.println("\n***\n");		

		//print the updated table
		result = stmt.executeQuery();
		
		while (result.next()) {
			String nameres = result.getString("name");
			int idres = result.getInt("id");
			System.out.printf("name: %s id: %d\n", nameres, idres);
		}

		con.close();
	}
}