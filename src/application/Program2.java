package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {
	public static void main(String[] args) {
		DepartmentDao depDao=  DaoFactory.createDepartmentDao();
		
		
		System.out.println("===Teste 1: findById===");
		Department dep = depDao.findByID(1);
		System.out.println(dep);
	

		System.out.println("===Teste 2: findAll===");
		List<Department>list = depDao.findAll(); 
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("===Teste 4: Insert===");
		Department newDep = new Department(null, "NovoDepartamento");
		depDao.insert(newDep);
		System.out.println("Inserted, new ID: "+ newDep.getId());
		
		
		System.out.println("===Teste 5: Update===");
		dep = depDao.findByID(1);
		dep.setName("Dep update");
		depDao.update(dep);
		System.out.println("Update Complete");
		
		System.out.println("===Teste 6: Delete===");
		int id = 1;
		depDao.deleteById(id);
		System.out.println("Deletado com sucesso");
		
	}
}
	