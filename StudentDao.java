package Dao;

import java.util.List;
import studentException.StudentNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dto.StudentDto;

public class StudentDao {
	public void insert(StudentDto dto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager emgr = emf.createEntityManager();
		EntityTransaction etr = emgr.getTransaction();
		etr.begin();
		emgr.persist(dto);
		etr.commit();
	}

	public void readById(int id) throws StudentNotFoundException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager emgr = emf.createEntityManager();
		StudentDto dto = emgr.find(StudentDto.class, id);
		System.out.println(dto.toString());
	}

	public void readAll() throws InterruptedException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager emgr = emf.createEntityManager();
		StudentDto dto = new StudentDto();
		Query query = emgr.createQuery("select x from StudentDto x");
		List<StudentDto> list = query.getResultList();
		for (StudentDto st : list) {
			Thread.sleep(2000);
			System.out.println(st.getSid() + " " + st.getSname() + " " + st.getMob() + "\n");
		}
	}

	public void update(StudentDto set) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager emgr = emf.createEntityManager();
		EntityTransaction etr = emgr.getTransaction();
		etr.begin();
		emgr.merge(set);
		etr.commit();
		System.out.println("Updated .......");
	}

	public void deleteById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager emgr = emf.createEntityManager();
		EntityTransaction etr = emgr.getTransaction();
		StudentDto dto = emgr.find(StudentDto.class, id);
		etr.begin();
		emgr.remove(dto);
		etr.commit();
		System.out.println("Deleted......");
	}

	public void deleteAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager emgr = emf.createEntityManager();
		EntityTransaction etr = emgr.getTransaction();
		Query qry = emgr.createQuery("delete from studentdto");
		etr.begin();
		qry.executeUpdate();
		etr.commit();
	}

}