package application;

import java.util.UUID;

public class randomStringGenerator {
	
    public static String generateString() {
    	
    	int lengteString = 6;
        String uuid = UUID.randomUUID().toString();
        String upToNCharacters = uuid.substring(0, Math.min(uuid.length(), lengteString));
        return upToNCharacters;
    }

}
