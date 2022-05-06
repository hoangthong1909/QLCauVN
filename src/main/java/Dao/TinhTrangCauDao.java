package Dao;

import JPAUtils.JpaUtil;
import entitys.DonViGiamSat;
import entitys.Huyen;
import entitys.TinhTrang;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TinhTrangCauDao {
    private EntityManager em;

    public TinhTrangCauDao() {
        this.em = JpaUtil.getEntityManager();
    }


    public List<TinhTrang> all() {
        String jpql = "SELECT obj from TinhTrang obj ";
        TypedQuery<TinhTrang> query = this.em.createQuery(jpql, TinhTrang.class);
        List<TinhTrang> list = query.getResultList();
        return list;
    }


    public TinhTrang findByID(int id) {
        TinhTrang entity = this.em.find(TinhTrang.class, id);
        return entity;
    }
}
