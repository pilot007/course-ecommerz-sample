package eticret.com.controller;

import eticret.com.model.Product;
import eticret.com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getall")
    List<Product> get_products() {
      return  productRepository.findAll();
    }

    @GetMapping("/getbyid/{id}")
    Optional<Product> get_productById(@PathVariable("id") Long id) {
        return productRepository.findById(id);
    }

    @PostMapping()
    Product add_product(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("{id}")
    String deleteById(@PathVariable("id") Long id)
    {
        productRepository.deleteById(id);
        return "Product deleted";
    }


    @GetMapping
    String helloWorld(){

        Product urun= new Product();
        urun.setDescription("Chat GPT kitabi");
        urun.setName("kitap");
        urun.setPrice(10);
        urun.setStock(99);

        Product urun2= new Product(1L,"kitap2","AWS kitabi",20,9);

        Product urun3 = new Product(2L,"kitap3",5);

        return "Hello World";
    }
}
