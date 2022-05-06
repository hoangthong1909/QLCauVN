package entitys;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(mappedBy = "idHuyen")
    private List<ViTriXa> listX;

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

    public List<ViTriXa> getListX() {
        return listX;
    }

    public void setListX(List<ViTriXa> listX) {
        this.listX = listX;
    }
}