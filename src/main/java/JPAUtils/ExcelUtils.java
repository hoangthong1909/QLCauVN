//package JPAUtils;
//
//import Dao.buildingDao;
//import Dao.receiptDao;
//import entitys.BuildingEntity;
//import entitys.ReceiptEntity;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFFont;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//public class ExcelUtils {
//
//
//    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
//        HSSFFont font = workbook.createFont();
//        font.setBold(true);
//        HSSFCellStyle style = workbook.createCellStyle();
//        style.setFont(font);
//        return style;
//    }
//    public void xuatExcelBuiding( String nameExcel) {
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("Tòa Nhà");
//        buildingDao dao=new buildingDao();
//        List<BuildingEntity> list = dao.all();
//        int rownum = 0;
//        Cell cell;
//        Row row;
//        //
//        HSSFCellStyle style = createStyleForTitle(workbook);
//
//        row = sheet.createRow(rownum);
//
//        // EmpNo
//        cell = row.createCell(0, CellType.STRING);
//        cell.setCellValue("ID");
//        cell.setCellStyle(style);
//        // EmpName
//        cell = row.createCell(1, CellType.STRING);
//        cell.setCellValue("Tòa Nhà");
//        cell.setCellStyle(style);
//        // Salary
//        cell = row.createCell(2, CellType.STRING);
//        cell.setCellValue("Địa Chỉ");
//        cell.setCellStyle(style);
//        // Grade
//        cell = row.createCell(3, CellType.STRING);
//        cell.setCellValue("Người Tạo");
//        cell.setCellStyle(style);
//        // Bonus
//        cell = row.createCell(4, CellType.STRING);
//        cell.setCellValue("Ngày Tạo");
//        cell.setCellStyle(style);
//        cell = row.createCell(5, CellType.STRING);
//        cell.setCellValue("Phí Vệ Sinh");
//        cell.setCellStyle(style);
//        cell = row.createCell(6, CellType.STRING);
//        cell.setCellValue("Phí An Ninh");
//        cell.setCellStyle(style);
//        cell = row.createCell(7, CellType.STRING);
//        cell.setCellValue("Phí Chăm Sóc Cảnh Quan");
//        cell.setCellStyle(style);
//        cell = row.createCell(8, CellType.STRING);
//        cell.setCellValue("Phí Hoạt Động Bảo Dưỡng Chung");
//        cell.setCellStyle(style);
//        cell = row.createCell(9, CellType.STRING);
//        cell.setCellValue("Phí Thu Dọn Rác");
//        cell.setCellStyle(style);
//        cell = row.createCell(10, CellType.STRING);
//        cell.setCellValue("Tổng Tiền");
//        cell.setCellStyle(style);
//
//
//        // Data
//        for (BuildingEntity building : list) {
//            rownum++;
//            row = sheet.createRow(rownum);
//
//            cell = row.createCell(0, CellType.NUMERIC);
//            cell.setCellValue(building.getId());
//
//            cell = row.createCell(1, CellType.STRING);
//            cell.setCellValue(building.getNameBuilding());
//
//            cell = row.createCell(2, CellType.STRING);
//            cell.setCellValue(building.getAddress());
//            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//            cell = row.createCell(3, CellType.STRING);
//            cell.setCellValue(sdf.format(building.getDateCreate()));
//
//            cell = row.createCell(4, CellType.STRING);
//            String test=building.getUser().getName();
//            System.out.println(test);
//            cell.setCellValue(test);
//
//            cell = row.createCell(5, CellType.NUMERIC);
//            cell.setCellValue(building.getToilet());
//
//            cell = row.createCell(6, CellType.NUMERIC);
//            cell.setCellValue(building.getSecurity());
//
//            cell = row.createCell(7, CellType.NUMERIC);
//            cell.setCellValue(building.getLandscapeCare());
//
//            cell = row.createCell(8, CellType.NUMERIC);
//            cell.setCellValue(building.getWork());
//
//            cell = row.createCell(9, CellType.NUMERIC);
//            cell.setCellValue(building.getGarbage());
//
//            cell = row.createCell(10, CellType.NUMERIC);
//            cell.setCellValue(building.getGarbage()+building.getWork()+building.getLandscapeCare()+building.getSecurity()+building.getToilet());
//        }
//        File file = new File("/home/thongpro/Desktop/WebQLChungCu/src/main/java/excel/"+nameExcel+".xlsx");
//        file.getParentFile().mkdirs();
//
//        FileOutputStream outFile = null;
//        try {
//            outFile = new FileOutputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            workbook.write(outFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Created file: " + file.getAbsolutePath());
//
//    }
//    public void xuatExcelReceipt( String nameExcel) {
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("Hóa Đơn");
//        receiptDao receiptDao=new receiptDao();
//        List<ReceiptEntity> list = receiptDao.all();
//        int rownum = 0;
//        Cell cell;
//        Row row;
//        //
//        HSSFCellStyle style = createStyleForTitle(workbook);
//
//        row = sheet.createRow(rownum);
//
//        // EmpNo
//        cell = row.createCell(0, CellType.STRING);
//        cell.setCellValue("Chủ Hộ");
//        cell.setCellStyle(style);
//        // EmpName
//        cell = row.createCell(1, CellType.STRING);
//        cell.setCellValue("Căn Hộ");
//        cell.setCellStyle(style);
//        // Salary
//        cell = row.createCell(2, CellType.STRING);
//        cell.setCellValue("Liên Hệ");
//        cell.setCellStyle(style);
//        // Grade
//        cell = row.createCell(3, CellType.STRING);
//        cell.setCellValue("Phí Dịch Vụ");
//        cell.setCellStyle(style);
//        // Bonus
//        cell = row.createCell(4, CellType.STRING);
//        cell.setCellValue("Phí Gửi Xe");
//        cell.setCellStyle(style);
//        cell = row.createCell(5, CellType.STRING);
//        cell.setCellValue("Phí Điện");
//        cell.setCellStyle(style);
//        cell = row.createCell(6, CellType.STRING);
//        cell.setCellValue("Phí Nước");
//        cell.setCellStyle(style);
//        cell = row.createCell(7, CellType.STRING);
//        cell.setCellValue("Internet");
//        cell.setCellStyle(style);
//        cell = row.createCell(8, CellType.STRING);
//        cell.setCellValue("Tổng Tiền");
//        cell.setCellStyle(style);
//
//        // Data
//        for (ReceiptEntity receipt : list) {
//            rownum++;
//            row = sheet.createRow(rownum);
//
//            cell = row.createCell(0, CellType.STRING);
//            cell.setCellValue(receipt.getContract_id().getIdCustomer().getNameCustomer());
//
//            cell = row.createCell(1, CellType.STRING);
//            cell.setCellValue(receipt.getContract_id().getIdRoom().getNameRoom());
//
//            cell = row.createCell(2, CellType.STRING);
//            cell.setCellValue(receipt.getContract_id().getIdCustomer().getPhone());
//
//            cell = row.createCell(3, CellType.NUMERIC);
//            cell.setCellValue(receipt.getService());
//
//            cell = row.createCell(4, CellType.NUMERIC);
//            cell.setCellValue(receipt.getParking());
//
//            cell = row.createCell(5, CellType.NUMERIC);
//            cell.setCellValue(receipt.getElectricity());
//
//            cell = row.createCell(6, CellType.NUMERIC);
//            cell.setCellValue(receipt.getWater());
//
//            cell = row.createCell(7, CellType.NUMERIC);
//            cell.setCellValue(receipt.getInternet());
//
//            cell = row.createCell(8, CellType.NUMERIC);
//            cell.setCellValue(receipt.getInternet()+receipt.getService()+receipt.getParking()+receipt.getWater()+receipt.getElectricity());
//        }
//        File file = new File("/home/thongpro/Desktop/WebQLChungCu/src/main/java/excel/"+nameExcel+".xlsx");
//        file.getParentFile().mkdirs();
//
//        FileOutputStream outFile = null;
//        try {
//            outFile = new FileOutputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            workbook.write(outFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Created file: " + file.getAbsolutePath());
//
//    }
//}
