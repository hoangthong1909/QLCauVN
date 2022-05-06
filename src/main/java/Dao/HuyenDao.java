package Dao;

import JPAUtils.JpaUtil;
import entitys.DonViGiamSat;
import entitys.Huyen;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class HuyenDao {
    private EntityManager em;

    public HuyenDao() {
        this.em = JpaUtil.getEntityManager();
    }


    public List<Huyen> all() {
        String jpql = "SELECT obj from Huyen obj ";
        TypedQuery<Huyen> query = this.em.createQuery(jpql, Huyen.class);
        List<Huyen> list = query.getResultList();
        return list;
    }


    public Huyen findByID(int id) {
        Huyen entity = this.em.find(Huyen.class, id);
        return entity;
    }
}
