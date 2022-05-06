package Dao;

import JPAUtils.JpaUtil;
import entitys.Admin;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AdminDao {
    private EntityManager em;

    public AdminDao() {
        this.em = JpaUtil.getEntityManager();
    }

    public Admin create(Admin entity) throws Exception {
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

    public Admin update(Admin entity) throws Exception {
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


    public List<Admin> all() {
        String jpql = "SELECT obj FROM Admin obj where obj.status=true ";
        TypedQuery<Admin> query = this.em.createQuery(jpql, Admin.class);
        List<Admin> ds = query.getResultList();
        return ds;
    }

    public Admin findByID(int id) {
        Admin entity = this.em.find(Admin.class, id);
        return entity;
    }

    public Admin findByEmail(String email) {
        String jpql = "SELECT obj FROM Admin obj " + "WHERE obj.email = :email";
        TypedQuery<Admin> query = this.em.createQuery(jpql, Admin.class);
        query.setParameter("email", email);
        List<Admin> result = query.getResultList();
        if (result.isEmpty()){
            return null;
        }
        return result.get(0);
    }
    public Admin findByPhone(String phone){
        String jpql="SELECT obj from Admin obj where obj.phone= :phone ";
        TypedQuery<Admin> query =this.em.createQuery(jpql,Admin.class);
        query.setParameter("phone",phone);
        List<Admin> list =query.getResultList();
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

}
