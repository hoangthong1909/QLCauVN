package Dao;

import JPAUtils.JpaUtil;
import entitys.Cau;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CauDao {
    private EntityManager em;

    public CauDao() {
        this.em = JpaUtil.getEntityManager();
    }

    public Cau create(Cau entity) throws Exception {
        try {
            this.em.getTransaction().begin();
            this.em.persist(entity);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
        return entity;
    }

    public Cau update(Cau entity) throws Exception {
        try {
            this.em.getTransaction().begin();
            this.em.merge(entity);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
        return entity;
    }

    public List<Cau> all(){
        String jpql="SELECT obj from Cau obj where obj.trangThai=1";
        TypedQuery<Cau> query =this.em.createQuery(jpql,Cau.class);
        List<Cau> list=query.getResultList();
        return list;
    }
    public Cau findByID(int id){
        Cau entity=this.em.find(Cau.class,id);
        return entity;
    }
//    public List<Cau> findByIDBuilding(int id){
//        String jpql="SELECT obj from Cau obj where obj.idFloor.id= :id AND obj.status=true ";
//        TypedQuery<RoomEntity> query =this.em.createQuery(jpql,RoomEntity.class);
//        query.setParameter("id",id);
//        List<RoomEntity> list=query.getResultList();
//        return list;
//    }
}
