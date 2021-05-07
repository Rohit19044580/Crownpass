import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.sql.*;

 
public class GenerateQrCode {
	public static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException  
	{  
	  
	BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);  
	MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));  
	}  
	
	
	
	public static void main(String args[]) throws WriterException, IOException, NotFoundException  
	{  
		String ID = null;
		String age = null;
		String name = null;
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
	String s1= "User ID\t" +ID;
	String s2= "\nUser name\t" + name;
	String s3= "\nUser Age\t" + age;
		
	String str= s1 + s2 + s3; 
	
	
	String path = "C:\\Users\\eclipse-workspace\\QR_Code\\Quote.png";  
	
	String charset = "UTF-8";  
	Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();  
	
	hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  
	 
	generateQRcode(str, path, charset, hashMap, 200, 200);

	System.out.println("QR Code created successfully.");  
	}  
	
	
}
