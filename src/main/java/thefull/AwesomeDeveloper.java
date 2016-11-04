
package thefull;

public class AwesomeDeveloper extends JavaDeveloper{

	private String firstName = "John";
	private String lastName = "Kautzner";
	private String email = "misterkautzner@gmail.com";
	private String github = "https://github.com/misterkautzner";
	private String linkedIn = "https://www.linkedin.com/in/john-kautzner";
	
	AwesomeDeveloper(int num) {
		int how_awesome = num*10;
		
		for(int i = 0; i < how_awesome; i++) {
			String awesome_line = firstName + " " + lastName + " is AWESOME!!!";
			System.out.println(awesome_line);
		}
	}

	
}



