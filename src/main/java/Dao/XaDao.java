package Dao;

import JPAUtils.JpaUtil;
import entitys.DonViGiamSat;
import entitys.Huyen;
import entitys.ViTriXa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class XaDao {
    private EntityManager em;

    public XaDao() {
        this.em = JpaUtil.getEntityManager();
    }


    public List<ViTriXa> all() {
        String jpql = "SELECT obj from ViTriXa obj ";
        TypedQuery<ViTriXa> query = this.em.createQuery(jpql, ViTriXa.class);
        List<ViTriXa> list = query.getResultList();
        return list;
    }


    public ViTriXa findByID(int id) {
        ViTriXa entity = this.em.find(ViTriXa.class, id);
        return entity;
    }
}
