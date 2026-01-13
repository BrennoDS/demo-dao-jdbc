package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		SellerDao sellerDao=  DaoFactory.createSellerDao();
		
		
		System.out.println("===Teste 1: findById===");
		Seller seller = sellerDao.findByID(3);
		System.out.println(seller);
		
		System.out.println("===Teste 1: findByDepartment===");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department); 
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("===Teste 3: findAll===");
		list = sellerDao.findAll(); 
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("===Teste 4: Insert===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted, new ID: "+ newSeller.getId());
		
		
		System.out.println("===Teste 5: Update===");
		seller = sellerDao.findByID(1);
		seller.setName("Mario");
		sellerDao.update(seller);
		System.out.println("Update Complete");
		
	}
}
	