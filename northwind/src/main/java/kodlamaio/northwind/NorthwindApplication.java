package kodlamaio.northwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 //swagger'ı başlatan anotasyon,7.ders
public class NorthwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	}
	
	 @Bean //uygulama ilk çalıştığı anda bean i gördüğü yerde belleğe alıyor
	    public Docket api() { //7. ders yazıldı,docket üzerinden bütün controllerları tarayıp apileri bulur
		 //ve onları yayınlanabilir bir noktaya taşır
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("kodlamaio.northwind"))         
	          .build();                                           
	    }
	 
	 //pom.xml'e springfox-swagger2 ve springfox-swagger-ui dependency'leri eklendi,7.ders

}
