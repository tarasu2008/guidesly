package bioPageCheck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class BioPageCheckingXL {
		
	public void readexcel() throws IOException {
		
		FileInputStream excel = new FileInputStream("D:\\Guidesly_imp\\guidebiopage.xlsx");
		Workbook workbook = new XSSFWorkbook(excel);
		XSSFSheet sheet = (XSSFSheet) workbook.getSheet("Sheet1");
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			Row rowValue = rowIterator.next();
			System.out.println(rowValue);
		}
		
		
	}
	
	public static void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
            	System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
            }    
       
            //Fetching and Printing the response code obtained
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
      }
   }

	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BioPageCheckingXL guidebio = new BioPageCheckingXL();
		guidebio.readexcel();
	}

}
