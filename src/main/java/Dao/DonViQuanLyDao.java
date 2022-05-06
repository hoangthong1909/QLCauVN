package Dao;

import JPAUtils.JpaUtil;
import entitys.DonViGiamSat;
import entitys.DonViQuanLy;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DonViQuanLyDao {
    private EntityManager em;

    public DonViQuanLyDao() {
        this.em = JpaUtil.getEntityManager();
    }


    public List<DonViQuanLy> all() {
        String jpql = "SELECT obj from DonViQuanLy obj ";
        TypedQuery<DonViQuanLy> query = this.em.createQuery(jpql, DonViQuanLy.class);
        List<DonViQuanLy> list = query.getResultList();
        return list;
    }


    public DonViQuanLy findByID(int id) {
        DonViQuanLy entity = this.em.find(DonViQuanLy.class, id);
        return entity;
    }
}
