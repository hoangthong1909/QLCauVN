package entitys;

import javax.persistence.*;

@Entity
public class QuocLo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "TenQuocLo", length = 50)
    private String tenQuocLo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenQuocLo() {
        return tenQuocLo;
    }

    public void setTenQuocLo(String tenQuocLo) {
        this.tenQuocLo = tenQuocLo;
    }

}