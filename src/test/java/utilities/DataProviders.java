package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="EmployeeData")
	public String [][] getData() throws IOException{
		
		String path = ".\\testdata\\EmployeeDetails.xlsx";//taking excel file from testdata
		ExcelUtility xlutil = new ExcelUtility(path);//creating an object for excel util
		int totalRows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		String EmployeeDetails[][] = new String[totalRows][totalcols];
		for(int i=1;i<=totalRows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				EmployeeDetails[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return EmployeeDetails;
	}

}
