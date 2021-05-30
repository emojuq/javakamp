package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getters ve setters ekler
@Entity
@Table(name="products")  //bu class hangi tabloya ait
@AllArgsConstructor //tüm argümanları kullanarak constructor ekle demek
@NoArgsConstructor //boş bir constructor ekle demek
public class Product {
	
	@Id //bu tablonun id'sinin ne olduğunu verdik
	@GeneratedValue(strategy=GenerationType.IDENTITY) //id'yi primary key yapar
	@Column (name="product_id")		//bu alan veritabanında hangi kolona denk geliyor yani postgre
	private int id;
	 
	//@Column (name="category_id")
	//private int categoryId;
	
	@Column (name="product_name")
	private String productName;
	
	@Column (name="unit_price")
	private double unitPrice;
	
	@Column (name="units_in_stock")
	private short unitsInStock;
	
	@Column (name="quantity_per_unit")
	private String quantityPerUnit;
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	

}