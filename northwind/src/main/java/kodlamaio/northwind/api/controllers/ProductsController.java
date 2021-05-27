package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

@RestController //sen bir controllersin demek
@RequestMapping("/api/products") //angulardaki newPath görevi gibi 
public class ProductsController {

	private ProductService productService;
	
	@Autowired //projeyi tarıyor,ProductService'i implemente etmişleri buluyor.
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}
	

	@GetMapping ("/getall") //HttpGet görevi gibi sanki
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) { //post işlemi olduğu için RequestBody kullanırız,
		//RequestBody senin gönderdiğin datayı Product içinde arıyor onlara yerleştiriyor
		return this.productService.add(product);
	}
	
	
	@GetMapping("/getByProductName")
	public DataResult<Product>getByProductName(@RequestParam String productName){
		//RequestParam yapılan isteğin yapılan parametrelerine bak orda productname adlı parametrelerini oku,atamasını yap ve gönder.
		return this.productService.getByProductName(productName);
	}
	
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
		
	}
	
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return this.productService.getAll(pageNo-1, pageSize);
	}
	
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	
	
}
