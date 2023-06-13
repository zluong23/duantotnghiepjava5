package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.ChatLieu;
import com.example.duanquanaojava5.Model.DongSP;
import com.example.duanquanaojava5.Model.SanPham;
import com.example.duanquanaojava5.Model.ThuongHieu;
import com.example.duanquanaojava5.Service.ChatLieuService;
import com.example.duanquanaojava5.Service.DongSPService;
import com.example.duanquanaojava5.Service.SanPhamService;
import com.example.duanquanaojava5.Service.ThuongHieuService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    DongSPService dongSPService;
    @Autowired
    ChatLieuService chatLieuService;
    @Autowired
    ThuongHieuService thuongHieuService;

    @GetMapping("/test")
    public String hienthi(Model model) {

        return "admin/index";
    }

    @GetMapping("/sanpham")
    public String hienthi1(Model model) {
        List<SanPham> sanPhams = sanPhamService.getallSP();
        model.addAttribute("sanpham", sanPhams);
        return "admin/sanpham";
    }

    @PostMapping("/import")
    public String importData(Model model,
                             @RequestParam("file") MultipartFile file) throws IOException {
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue; // skip header row
            }
            String tenSanPham = row.getCell(0).getStringCellValue().trim();
            Double giaBan = row.getCell(1).getNumericCellValue();
            Double giaNhap = row.getCell(2).getNumericCellValue();
            String hinhAnh = row.getCell(3).getStringCellValue().trim();
            String moTa = row.getCell(4).getStringCellValue().trim();
            String tenThuongHieu = row.getCell(5).getStringCellValue().trim();
            String tenChatLieu = row.getCell(6).getStringCellValue().trim();
            String tenDongSP = row.getCell(7).getStringCellValue().trim();

            ThuongHieu thuongHieu = thuongHieuService.findByTenThuongHieu(tenThuongHieu);
            if (thuongHieu == null) {
                thuongHieu = new ThuongHieu();
                thuongHieu.setTenThuongHieu(tenThuongHieu);
                thuongHieuService.save(thuongHieu);
            }
            ChatLieu chatLieu = chatLieuService.findByTenChatLieu(tenChatLieu);
            if (chatLieu == null) {
                chatLieu = new ChatLieu();
                chatLieu.setTenChatLieu(tenChatLieu);
                chatLieuService.save(chatLieu);
            }
            DongSP dongSP = dongSPService.findByTenDongSP(tenDongSP);
            if (dongSP == null) {
                dongSP = new DongSP();
                dongSP.setTenDongSP(tenDongSP);
                dongSPService.save(dongSP);
            }
            SanPham sanPham = new SanPham();
            sanPham.setTenSanPham(tenSanPham);
            sanPham.setGiaBan(giaBan);
            sanPham.setGiaNhap(giaNhap);
            sanPham.setHinhAnh(hinhAnh);
            sanPham.setMoTa(moTa);
            sanPham.setTh(thuongHieu);
            sanPham.setCl(chatLieu);
            sanPham.setDsp(dongSP);
            sanPhamService.save(sanPham);
        }
        workbook.close();
        return "redirect:/admin/sanpham";
    }
}
