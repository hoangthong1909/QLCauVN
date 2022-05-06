package entitys;

import javax.persistence.*;

@Entity
public class ViTriXa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "TenXa", length = 50)
    private String tenXa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHuyen")
    private Huyen idHuyen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenXa() {
        return tenXa;
    }

    public void setTenXa(String tenXa) {
        this.tenXa = tenXa;
    }

    public Huyen getIdHuyen() {
        return idHuyen;
    }

    public void setIdHuyen(Huyen idHuyen) {
        this.idHuyen = idHuyen;
    }

}