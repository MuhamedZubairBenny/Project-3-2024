package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService{
    private ProductRepository repository;

    @Autowired
    ProductService(ProductRepository repository){this.repository = repository;}

    @Override
    public Product create(Product product) {return repository.save((product));}

    @Override
    public Product read(String id) {return repository.findById(id).orElse(null);}

    @Override
    public Product update(Product product) {return repository.save(product);}

    @Override
    public void delete(String id) { repository.deleteById(id);}

    @Override
    public List<Product> getAll(){ return repository.findAll();}
}
