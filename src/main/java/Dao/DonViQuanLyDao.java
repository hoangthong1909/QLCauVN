package Dao;

import JPAUtils.JpaUtil;
import entitys.Admin;
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
        String jpql = "SELECT obj from DonViQuanLy obj where obj.status=true ";
        TypedQuery<DonViQuanLy> query = this.em.createQuery(jpql, DonViQuanLy.class);
        List<DonViQuanLy> list = query.getResultList();
        return list;
    }


    public DonViQuanLy findByID(int id) {
        DonViQuanLy entity = this.em.find(DonViQuanLy.class, id);
        return entity;
    }
    public DonViQuanLy findByEmail(String email) {
        String jpql = "SELECT obj FROM DonViQuanLy obj " + "WHERE obj.email = :email";
        TypedQuery<DonViQuanLy> query = this.em.createQuery(jpql, DonViQuanLy.class);
        query.setParameter("email", email);
        List<DonViQuanLy> result = query.getResultList();
        if (result.isEmpty()){
            return null;
        }
        return result.get(0);
    }
    public DonViQuanLy create(DonViQuanLy entity) throws Exception {
        try {
            this.em.getTransaction().begin();
            this.em.persist(entity);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
            throw e;
        }
        return entity;
    }

    public DonViQuanLy update(DonViQuanLy entity) throws Exception {
        try {
            this.em.getTransaction().begin();
            this.em.merge(entity);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
            throw e;
        }
        return entity;
    }
    public DonViQuanLy findByPhone(String phone){
        String jpql="SELECT obj from DonViQuanLy obj where obj.phone= :phone ";
        TypedQuery<DonViQuanLy> query =this.em.createQuery(jpql,DonViQuanLy.class);
        query.setParameter("phone",phone);
        List<DonViQuanLy> list =query.getResultList();
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
}
