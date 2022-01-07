package main3;

import file.IFile;
import main1.NhanVienSuaChua;
import main2.HoaDon;
import main2.NhaSanXuat;
import main2.SanPham;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiSanPham implements IFile {
   private ArrayList<SanPham>  danhSachSanPham = new ArrayList<>();

   public QuanLiSanPham(ArrayList<SanPham> danhSachSanPham) {
      this.danhSachSanPham = danhSachSanPham;
   }

   public QuanLiSanPham() {

   }


   public ArrayList<SanPham> getDanhSachSanPham() {
      return danhSachSanPham;
   }

   public void setDanhSachSanPham(ArrayList<SanPham> danhSachSanPham) {
      this.danhSachSanPham = danhSachSanPham;
   }

   public boolean themSanPham(SanPham SP) {
      danhSachSanPham.add(SP);
      return true;
   }

   public boolean xoaSanPham(String maSP) {
      for (SanPham x : danhSachSanPham) {
         if (x.getMaSanPham().equals(maSP)) {
            danhSachSanPham.remove(x);
            return true;
         }
      }
      return false;
   }

   public boolean capNhatGiaBan(String maSP) {
      Scanner sc = new Scanner(System.in);
      for (SanPham x : danhSachSanPham) {
         if (x.getMaSanPham().equals(maSP))
            System.out.print("Nhập giá bán: "); x.setGiaBan(sc.nextDouble());
            return true;
      }
      return false;
   }
   public void sapXepSanPhamTheoGiaBan() {
      danhSachSanPham.sort((SP1, SP2) -> (SP1.soSanh(SP2)));
      hienThiDanhSachSanPham();
   }

   public void hienThiDanhSachSanPham() {
      for (SanPham x : danhSachSanPham) {
        x.hienThiChiTiet();
         System.out.println();
      }
   }
   public void inDanhSachSanPhamTheoLoaiSanPham(String loaiSP) {
      for (SanPham x : danhSachSanPham) {
         if(x.getLoaiSanPham().equals(loaiSP))
            System.out.println(x);
      }
   }

   public  ArrayList<SanPham> timKiemSanPham(String key) {
      ArrayList<SanPham> list = new ArrayList<>();
      for (SanPham x : danhSachSanPham) {
         if (x.getTenSanPham().contains(key))
            list.add(x);
      }
      return list;
   }
   public void hienThiChiTietThongTin1SanPham(String maSP) {
      for (SanPham x : danhSachSanPham) {
         if (x.getMaSanPham().equals(maSP)) {
            x.hienThiChiTiet();
            return;
         }
      }
   }
   public void hienThiSanPhamTheoMucGia(double dau, double cuoi) {
      for (SanPham x : danhSachSanPham) {
         if (x.getGiaBan() > dau && x.getGiaBan() < cuoi) {
            x.hienThiChiTiet();
         }
      }
   }

   @Override
   public void docFile(String link) {
      File F = new File(link);
      try( Scanner sc = new Scanner(F)) {
         while(sc.hasNext()) {
            String a = sc.nextLine();
            String[] s = a.split(", ");
            NhaSanXuat nsx = new NhaSanXuat(s[2], s[3]);
            double giaBan = Double.parseDouble(s[4]);
            int soLuong = Integer.parseInt(s[5]);
            int thoiGianBaoHanh = Integer.parseInt(s[7]);
            SanPham sp = new SanPham(s[0], s[1], nsx, giaBan, soLuong, s[6], thoiGianBaoHanh);
            danhSachSanPham.add(sp);
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void ghiFile(String link) {
      try{
         FileWriter fw = new FileWriter(link);
         BufferedWriter bw = new BufferedWriter(fw);
         for (SanPham x : danhSachSanPham) {
            bw.write(x.toString());
            bw.newLine();
         }
         bw.close();
         fw.close();

      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
