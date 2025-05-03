package restassured.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

public class Dataprovider {

    @DataProvider(name = "readexcledata")
    public Object[][] readdata() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata.xlsx";
        String sheetName = "createissue";

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            List<Object[]> dataList = new ArrayList<>();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null || isRowEmpty(row)) continue;

                Object[] rowData = new Object[cols];
                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    rowData[j] = cell.toString();
                }
                dataList.add(rowData);
            }

            // Convert List to Object[][]
            Object[][] arr = new Object[dataList.size()][cols];
            for (int i = 0; i < dataList.size(); i++) {
                arr[i] = dataList.get(i);
            }

            return arr;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Object[0][0]; // return empty to avoid null in case of failure
    }

    private boolean isRowEmpty(Row row) {
        for (int c = 0; c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }
    

	@DataProvider(name = "summarydata")
	public Object[][] data() {
		Object[][] objarr = { { "issue created with req1" }, { "issue created with req2" },
				{ "issue created with req3" } };
		return objarr;
	}
	
	@DataProvider(name = "dataIterator")
	public Iterator<Object[]> dataIterator() {
		List<Object[]> ls = new ArrayList<Object[]>();
		ls.add( new Object[] {"issue created with req44"});
		ls.add( new Object[] {"issue created with req45"});
		ls.add( new Object[] {"issue created with req46"});
		ls.add( new Object[] {"issue created with req47"});
		
		return ls.iterator();
	}
	
}
