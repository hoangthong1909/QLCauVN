package entitys;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "TenTinh", length = 50)
    private String tenTinh;
    @OneToMany(mappedBy = "idTinh")
    private List<Huyen> listH;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }

    public List<Huyen> getListH() {
        return listH;
    }

    public void setListH(List<Huyen> listH) {
        this.listH = listH;
    }
}