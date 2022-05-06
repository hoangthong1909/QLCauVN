package Dao;

import JPAUtils.JpaUtil;
import entitys.DonViGiamSat;
import entitys.Huyen;
import entitys.Tinh;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TinhDao {
    private EntityManager em;

    public TinhDao() {
        this.em = JpaUtil.getEntityManager();
    }


    public List<Tinh> all() {
        String jpql = "SELECT obj from Tinh obj ";
        TypedQuery<Tinh> query = this.em.createQuery(jpql, Tinh.class);
        List<Tinh> list = query.getResultList();
        return list;
    }


    public Tinh findByID(int id) {
        Tinh entity = this.em.find(Tinh.class, id);
        return entity;
    }
}
