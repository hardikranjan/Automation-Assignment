package Exception;

import java.io.IOException;

import Utils.TakeScreenShot;

public class FileNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public FileNotFoundException(String message) throws IOException{
		super(message);
    } 
	
}