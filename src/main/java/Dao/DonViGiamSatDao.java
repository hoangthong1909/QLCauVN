package Dao;

import JPAUtils.JpaUtil;
import entitys.DonViGiamSat;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DonViGiamSatDao {
    private EntityManager em;

    public DonViGiamSatDao() {
        this.em = JpaUtil.getEntityManager();
    }


    public List<DonViGiamSat> all() {
        String jpql = "SELECT obj from DonViGiamSat obj ";
        TypedQuery<DonViGiamSat> query = this.em.createQuery(jpql, DonViGiamSat.class);
        List<DonViGiamSat> list = query.getResultList();
        return list;
    }


    public DonViGiamSat findByID(int id) {
        DonViGiamSat entity = this.em.find(DonViGiamSat.class, id);
        return entity;
    }
}
