package Dao;

import JPAUtils.JpaUtil;
import entitys.ChuDauTu;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ChuDauTuDao {
    private EntityManager em;

    public ChuDauTuDao() {
        this.em = JpaUtil.getEntityManager();
    }

    public ChuDauTu create(ChuDauTu entity) throws Exception {
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

    public ChuDauTu update(ChuDauTu entity) throws Exception {
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


    public List<ChuDauTu> all() {
        String jpql = "SELECT obj FROM ChuDauTu obj where obj.trangThai=true ";
        TypedQuery<ChuDauTu> query = this.em.createQuery(jpql, ChuDauTu.class);
        List<ChuDauTu> ds = query.getResultList();
        return ds;
    }

    public ChuDauTu findByID(int id) {
        ChuDauTu entity = this.em.find(ChuDauTu.class, id);
        return entity;
    }

    public ChuDauTu findByCMND(String cmnd){
        String jpql="SELECT obj from ChuDauTu obj where obj.cmnd= :cmnd ";
        TypedQuery<ChuDauTu> query =this.em.createQuery(jpql,ChuDauTu.class);
        query.setParameter("cmnd",cmnd);
        List<ChuDauTu> list =query.getResultList();
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    public ChuDauTu findByPhone(String phone){
        String jpql="SELECT obj from ChuDauTu obj where obj.sdt= :phone  ";
        TypedQuery<ChuDauTu> query =this.em.createQuery(jpql,ChuDauTu.class);
        query.setParameter("phone",phone);
        List<ChuDauTu> list =query.getResultList();
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    public ChuDauTu findByEmail(String email){
        String jpql="SELECT obj from ChuDauTu obj where obj.email= :email  ";
        TypedQuery<ChuDauTu> query =this.em.createQuery(jpql,ChuDauTu.class);
        query.setParameter("email",email);
        List<ChuDauTu> list =query.getResultList();
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

}
