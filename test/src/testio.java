
	import java.io.FileOutputStream; 
	import java.io.DataOutputStream; 
	import java.io.IOException; 
	public class testio { 
		
		
		
	static String fileName = "hello.txt";// ein Dateiname 
	// ein paar Methoden 
	
	
	public static void writeData() throws IOException { 
	 FileOutputStream fos = new FileOutputStream(fileName); 
	 DataOutputStream out = new DataOutputStream(fos); 
	 out.writeBytes("der test hat funktioniert");
	 out.writeFloat(1234);
	 out.close(); 
	 } 
	
	public static void main(String[] args) throws IOException {
		writeData();
	}
}
