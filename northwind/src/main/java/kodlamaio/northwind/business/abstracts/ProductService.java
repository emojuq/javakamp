package kodlamaio.northwind.business.abstracts;

import java.util.List;


import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

public interface ProductService {
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAll(int pageNo,int pageSize);//sayfalama
	DataResult<List<Product>> getAllSorted(); //datayı istediğim şarta göre sırala
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId); //and her ikisinin de doğru olduğundda çalışır
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName,int categoryId); //Or productname ya da categoryid'nin herhangi biri doğru olduğunda çalışır
	DataResult<List<Product>> getByCategoryIdIn(List<Integer>categories);
	DataResult<List<Product>>getByProductNameContains(String productName );//ürün ismine göre arama
	DataResult<List<Product>>getByProductNameStartsWith(String productName); //ürünün bir harf ile başlama olayı(örneğin a ile başlayan ürünleri listelemek)
	DataResult<List<Product>>getByNameAndCategory(String productName,int categoryId);

	
}
