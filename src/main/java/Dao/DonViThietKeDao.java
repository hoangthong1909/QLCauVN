package Dao;

import JPAUtils.JpaUtil;
import entitys.DonViGiamSat;
import entitys.DonViQuanLy;
import entitys.DonViThiCong;
import entitys.DonViThietKe;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DonViThietKeDao {
    private EntityManager em;

    public DonViThietKeDao() {
        this.em = JpaUtil.getEntityManager();
    }


    public List<DonViThietKe> all() {
        String jpql = "SELECT obj from DonViThietKe obj ";
        TypedQuery<DonViThietKe> query = this.em.createQuery(jpql, DonViThietKe.class);
        List<DonViThietKe> list = query.getResultList();
        return list;
    }


    public DonViThietKe findByID(int id) {
        DonViThietKe entity = this.em.find(DonViThietKe.class, id);
        return entity;
    }
}
