package Utils;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ReadFromExcelFile
{
   public static String getExcelData(int row,int col) throws BiffException, IOException, WriteException
   {
      WritableWorkbook wworkbook;
      wworkbook = Workbook.createWorkbook(new File("Resources/EmailSheet.xls"));
      WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
      Label label = new Label(0, 1, "abc.xyz@yopmail.com");
      wsheet.addCell(label);
      label = new Label(0,0,"EmailId's");
      wsheet.addCell(label);
      label = new Label(0,2,"klm.pnq@yopmail.com");
      wsheet.addCell(label);
      Number number = new Number(3, 4, 3.1459);
      wsheet.addCell(number);
      wworkbook.write();
      wworkbook.close();

      Workbook workbook = Workbook.getWorkbook(new File("Resources/EmailSheet.xls"));
      Sheet sheet = workbook.getSheet(0);
      Cell cell1 = sheet.getCell(0, 0);
      Cell cell2 = sheet.getCell(0, 1);
      Cell cell = sheet.getCell(row,col); 
      System.out.println(cell1.getContents());
      System.out.println(cell2.getContents());
      workbook.close();
      
      return cell.getContents();
   }
}