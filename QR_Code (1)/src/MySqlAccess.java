import java.sql.*;

public class MySqlAccess {
	static String ID;
	static String name;
	static String age;

	public static void main(String[] args) {
		
			
			   try {
				Connection	 connection = DriverManager.getConnection("jdbc:mysql://34.123.70.28:3306/Crownpass_user_db", "root", "12345");//Establishing connection
				System.out.println("Connected With the database successfully");
				PreparedStatement preparedStatement=connection.prepareStatement("select * from C_User");
		        //Creating Java ResultSet object
		        ResultSet resultSet=preparedStatement.executeQuery();
		        while(resultSet.next())
		        {
		             ID=resultSet.getString("id");
		             name=resultSet.getString("Name");
		             age=resultSet.getString("age");
		             //Printing Results
		             System.out.println(ID+" "+name+" "+age);
		        }
			   }
		        catch (SQLException e) {
				
				System.out.println("Error while connecting to the database");
			
					}
			   }

}
