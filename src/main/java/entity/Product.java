package entity;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class  Product
{
    private String WorkbookPath;
    private String XSSFSheet;
    private int XSSFRow;
    private int productName;
    private int productPrice;
    private int productQuantity;

    public Product (String workbookPath, String XSSFSheet, int XSSFRow) {
        this.WorkbookPath = workbookPath;
        this.XSSFSheet = XSSFSheet;
        this.XSSFRow = XSSFRow;
    }

    public Product(String workbookPath, String XSSFSheet, int XSSFRow, int productName, int productPrice, int productQuantity) {
        this.WorkbookPath = workbookPath;
        this.XSSFSheet = XSSFSheet;
        this.XSSFRow = XSSFRow;
        this.productName =  productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public String getDataFromExcel() {
        try {
            FileInputStream file = new FileInputStream(new File(WorkbookPath));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(XSSFSheet);
            Row row = sheet.getRow(XSSFRow);

            StringBuilder rowData = new StringBuilder();
            for (Cell cell : row) {
                rowData.append(cell.toString()).append(" | ");
            }
            return rowData.toString();
        } catch (Exception e) {
            return "Error reading data from excel file: " + e.getMessage();
        }
    }

    public String readName() {
        String cellName = String.valueOf(productName);
        try {
            FileInputStream file = new FileInputStream(new File (WorkbookPath));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(XSSFSheet);
            Row row = sheet.getRow(XSSFRow);
            Cell cell = row.getCell(productName);
            cellName = cell.getStringCellValue();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellName;
    }

    public int readQuantity() {
        double cellQuantityValue = productQuantity;
        try {
            FileInputStream file = new FileInputStream(new File (WorkbookPath));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(XSSFSheet);
            Row row = sheet.getRow(XSSFRow);
            Cell cell = row.getCell(productQuantity);
            cellQuantityValue = cell.getNumericCellValue();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) cellQuantityValue;
    }

    public int readPrice() {
        double cellPriceValue = productPrice;
        try {
            FileInputStream file = new FileInputStream(new File (WorkbookPath));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(XSSFSheet);
            Row row = sheet.getRow(XSSFRow);
            Cell cell = row.getCell(productPrice);
            cellPriceValue = cell.getNumericCellValue();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) cellPriceValue;
    }

    @Override
    public String toString() {
        return getDataFromExcel();
    }

    public String getWorkbookPath() {
        return WorkbookPath;
    }

    public void setWorkbookPath(String workbookPath) {
        WorkbookPath = workbookPath;
    }

    public String getXSSFSheet() {
        return XSSFSheet;
    }

    public void setXSSFSheet(String XSSFSheet) {
        this.XSSFSheet = XSSFSheet;
    }

    public int getXSSFRow() {
        return XSSFRow;
    }

    public void setXSSFRow(int XSSFRow) {
        this.XSSFRow = XSSFRow;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductName() {
        return productName;
    }

    public void setProductName(int productName) {
        this.productName = productName;
    }

    public Product() {
        super();
    }
}

