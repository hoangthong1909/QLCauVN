package entitys;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Cau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "TenCau", length = 50)
    private String tenCau;

    @Column(name = "namXD")
    private Date namXD;

    @Column(name = "namHT")
    private Date namHT;

    @Column(name = "namKT")
    private Date namKT;

    @Column(name = "dateUpdate")
    private Date dateUpdate;

    @Column(name = "TongMucDauTu")
    private Double tongMucDauTu;

    @Column(name = "TaiTrongTK")
    private Double taiTrongTK;

    @ManyToOne
    @JoinColumn(name = "idChuDauTu")
    private ChuDauTu idChuDauTu;

    @ManyToOne
    @JoinColumn(name = "idDonViThiCong")
    private DonViThiCong idDonViThiCong;

    @ManyToOne
    @JoinColumn(name = "idDonViThietKe")
    private DonViThietKe idDonViThietKe;

    @ManyToOne
    @JoinColumn(name = "idDonViGiamSat")
    private DonViGiamSat idDonViGiamSat;

    @ManyToOne
    @JoinColumn(name = "idDonViQuanLy")
    private DonViQuanLy idDonViQuanLy;

    @ManyToOne
    @JoinColumn(name = "IdQuocLo")
    private QuocLo idQuocLo;

    @ManyToOne
    @JoinColumn(name = "idViTri")
    private ViTriXa idViTri;

    @ManyToOne
    @JoinColumn(name = "idTinhTrang")
    private TinhTrang idTinhTrang;

    @Column(name = "trangThai")
    private Integer trangThai;

    @Column(name = "dateCreate")
    private Date dateCreate;

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenCau() {
        return tenCau;
    }

    public void setTenCau(String tenCau) {
        this.tenCau = tenCau;
    }

    public Date getNamXD() {
        return namXD;
    }

    public void setNamXD(Date namXD) {
        this.namXD = namXD;
    }

    public Date getNamHT() {
        return namHT;
    }

    public void setNamHT(Date namHT) {
        this.namHT = namHT;
    }

    public Date getNamKT() {
        return namKT;
    }

    public void setNamKT(Date namKT) {
        this.namKT = namKT;
    }

    public Double getTongMucDauTu() {
        return tongMucDauTu;
    }

    public void setTongMucDauTu(Double tongMucDauTu) {
        this.tongMucDauTu = tongMucDauTu;
    }

    public Double getTaiTrongTK() {
        return taiTrongTK;
    }

    public void setTaiTrongTK(Double taiTrongTK) {
        this.taiTrongTK = taiTrongTK;
    }

    public ChuDauTu getIdChuDauTu() {
        return idChuDauTu;
    }

    public void setIdChuDauTu(ChuDauTu idChuDauTu) {
        this.idChuDauTu = idChuDauTu;
    }

    public DonViThiCong getIdDonViThiCong() {
        return idDonViThiCong;
    }

    public void setIdDonViThiCong(DonViThiCong idDonViThiCong) {
        this.idDonViThiCong = idDonViThiCong;
    }

    public DonViThietKe getIdDonViThietKe() {
        return idDonViThietKe;
    }

    public void setIdDonViThietKe(DonViThietKe idDonViThietKe) {
        this.idDonViThietKe = idDonViThietKe;
    }

    public DonViGiamSat getIdDonViGiamSat() {
        return idDonViGiamSat;
    }

    public void setIdDonViGiamSat(DonViGiamSat idDonViGiamSat) {
        this.idDonViGiamSat = idDonViGiamSat;
    }

    public DonViQuanLy getIdDonViQuanLy() {
        return idDonViQuanLy;
    }

    public void setIdDonViQuanLy(DonViQuanLy idDonViQuanLy) {
        this.idDonViQuanLy = idDonViQuanLy;
    }

    public QuocLo getIdQuocLo() {
        return idQuocLo;
    }

    public void setIdQuocLo(QuocLo idQuocLo) {
        this.idQuocLo = idQuocLo;
    }

    public ViTriXa getIdViTri() {
        return idViTri;
    }

    public void setIdViTri(ViTriXa idViTri) {
        this.idViTri = idViTri;
    }

    public TinhTrang getIdTinhTrang() {
        return idTinhTrang;
    }

    public void setIdTinhTrang(TinhTrang idTinhTrang) {
        this.idTinhTrang = idTinhTrang;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}