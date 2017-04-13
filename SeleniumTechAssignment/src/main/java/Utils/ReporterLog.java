package Utils;

import java.sql.Timestamp;

import org.testng.Reporter;

public class ReporterLog {
	
	public void info(String msg,boolean state){
        Reporter.log(new Timestamp(System.currentTimeMillis())+" [info]  "+msg,state);
    }
	
    public void verify(String msg,boolean state){
           Reporter.log(new Timestamp(System.currentTimeMillis())+" [Verify]  "+msg,state);
    }
    
}
