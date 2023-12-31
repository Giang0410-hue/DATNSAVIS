package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hoa_don")
@Builder
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_hoa_don", length = 20)
    private String maHoaDon;

    @Column(name = "ngay_thanh_toan")
    private Date ngayThanhToan;

    @Column(name = "loai_hoa_don")
    private Integer loaiHoaDon;

    @Column(name = "phi_ship")
    private Long phiShip;

    @Column(name = "tong_tien")
    private Long tongTien;

    @Column(name = "tong_tien_khi_giam")
    private Long tongTienKhiGiam;

    @Column(name = "ghi_chu", length = 255)
    private String ghiChu;

    @Column(name = "nguoi_nhan", length = 100)
    private String nguoiNhan;

    @Column(name = "sdt_nguoi_nhan", length = 15)
    private String sdtNguoiNhan;
    @Column(name = "thanh_pho", length = 50)
    private String thanhPho;

    @Column(name = "quan_huyen", length = 50)
    private String quanHuyen;

    @Column(name = "phuong_xa", length = 50)
    private String phuongXa;

    @Column(name = "dia_chi_nguoi_nhan", length = 100)
    private String diaChiNguoiNhan;

    @Column(name = "email_nguoi_nhan", length = 100)
    private String emailNguoiNhan;

    @Column(name = "ngay_nhan")
    private Date ngayNhan;

    @Column(name = "ngay_mong_muon")
    private Date ngayMongMuon;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_sua")
    private Date ngaySua;

    @Column(name = "nguoi_tao", length = 100)
    private String nguoiTao;

    @Column(name = "nguoi_sua", length = 100)
    private String nguoiSua;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    private Voucher voucher;



    @OneToMany(mappedBy = "hoaDon")
    private List<HoaDonChiTiet> lstHoaDonChiTiet;




    public static String timeFm(LocalDateTime currentTime) {
        // LocalDateTime currentTime = LocalDateTime.now();

        // Định dạng thời gian theo yêu cầu: giờ, phút, ngày, tháng, năm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }


    public String getStringTrangThai() {
        switch (this.trangThai) {
            case 0:
                return "Chờ xác nhận";
            case 1:
                return "Chờ giao";
            case 2:
                return "Đang giao";

            case 3:
                return "Hoàn thành";
            case 4:
                return "Chờ thanh toán";
            case 5:
                return "Đã hủy";
            default:
                break;
        }
        return "";
    }
}
