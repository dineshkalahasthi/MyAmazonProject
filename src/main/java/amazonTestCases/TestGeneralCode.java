package amazonTestCases;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TestGeneralCode {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
String line = null;
//Scanner in=new Scanner(System.in);
DataInputStream in1=new DataInputStream(System.in);

while((line=in1.readLine())!=null) {
	for(int i=1;i<line.length();i++) {
		char ch=line.charAt(i);
		if(ch==' ') {
			System.out.println(line.charAt(i-1));
			break;
		}
	}
	break;
}
	}

}
