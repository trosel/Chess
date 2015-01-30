import java.util.*;
 
public class GameHelper {
	
	Scanner sc = new Scanner(System.in);
	
	public String getUserAns(String question) {
		System.out.println(question);
		String userIn = sc.next();
		return userIn;
	}
}
