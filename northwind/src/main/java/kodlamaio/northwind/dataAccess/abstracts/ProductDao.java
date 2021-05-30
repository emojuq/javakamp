package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer> { 
	//jparepo. product için pk alanının da bana ne olduğunu ver diyor,
	//ürünle ilgili crud operasyonları hazır.
	Product getByProductName(String productName);
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId); //and her ikisinin de doğru olduğundda çalışır
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId); //Or productname ya da categoryid'nin herhangi biri doğru olduğunda çalışır
	List<Product> getByCategoryIn(List<Integer>categories);
	List<Product>getByProductNameContains(String productName );//ürün ismine göre arama
	List<Product>getByProductNameStartsWith(String productName); //ürünün bir harf ile başlama olayı(örneğin a ile başlayan ürünleri listelemek)
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product>getByNameAndCategory(String productName,int categoryId);

	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p") //dto işlemi 9. ders
	List<ProductWithCategoryDto>getProductWithCategoryDetails(); //dto işlemi 9. ders

}
 