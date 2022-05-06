package Dao;

import JPAUtils.JpaUtil;
import entitys.DonViGiamSat;
import entitys.Huyen;
import entitys.QuocLo;
import entitys.Tinh;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class QuocLoDao {
    private EntityManager em;

    public QuocLoDao() {
        this.em = JpaUtil.getEntityManager();
    }


    public List<QuocLo> all() {
        String jpql = "SELECT obj from QuocLo obj ";
        TypedQuery<QuocLo> query = this.em.createQuery(jpql, QuocLo.class);
        List<QuocLo> list = query.getResultList();
        return list;
    }


    public QuocLo findByID(int id) {
        QuocLo entity = this.em.find(QuocLo.class, id);
        return entity;
    }
}
