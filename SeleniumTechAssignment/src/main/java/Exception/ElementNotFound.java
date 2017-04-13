package Exception;

import java.io.IOException;

import Utils.TakeScreenShot;

public class ElementNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public ElementNotFound(String message) throws IOException{
		super(message);
    } 
}
