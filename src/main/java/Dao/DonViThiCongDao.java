package Dao;

import JPAUtils.JpaUtil;
import entitys.DonViGiamSat;
import entitys.DonViQuanLy;
import entitys.DonViThiCong;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DonViThiCongDao {
    private EntityManager em;

    public DonViThiCongDao() {
        this.em = JpaUtil.getEntityManager();
    }


    public List<DonViThiCong> all() {
        String jpql = "SELECT obj from DonViThiCong obj ";
        TypedQuery<DonViThiCong> query = this.em.createQuery(jpql, DonViThiCong.class);
        List<DonViThiCong> list = query.getResultList();
        return list;
    }


    public DonViThiCong findByID(int id) {
        DonViThiCong entity = this.em.find(DonViThiCong.class, id);
        return entity;
    }
}
