package entitys;

import javax.persistence.*;

@Entity
public class Huyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "TenHuyen", length = 50)
    private String tenHuyen;

    @ManyToOne
    @JoinColumn(name = "idTinh")
    private Tinh idTinh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenHuyen() {
        return tenHuyen;
    }

    public void setTenHuyen(String tenHuyen) {
        this.tenHuyen = tenHuyen;
    }

    public Tinh getIdTinh() {
        return idTinh;
    }

    public void setIdTinh(Tinh idTinh) {
        this.idTinh = idTinh;
    }

}