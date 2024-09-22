package EAM.TiendaProducto.service;//package service;
import EAM.TiendaProducto.dto.DtoStore;
import EAM.TiendaProducto.model.Product;
import EAM.TiendaProducto.model.Store;
import EAM.TiendaProducto.dto.DtoProduct;
import EAM.TiendaProducto.repository.RepositoryStore;
import EAM.TiendaProducto.repository.RepositoryProduct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProduct {

    @Autowired
    private RepositoryProduct repositoryProduct;

    public List<Product> findAll() {
        return repositoryProduct.findAll();
    }

    public Product searchProduct(Long id) {
        return repositoryProduct.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return repositoryProduct.save(product);
    }

    public void updateProduct(Long id, Product updatedProductData) {
        Product existingProduct = repositoryProduct.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        existingProduct.setName(updatedProductData.getName());
        existingProduct.setDescription(updatedProductData.getDescription());
        existingProduct.setPrice(updatedProductData.getPrice());
        existingProduct.setStock(updatedProductData.getStock());
        repositoryProduct.save(existingProduct);
    }


    public void deleteProduct(Long id) {
        if (repositoryProduct.existsById(id)) {
            repositoryProduct.deleteById(id);
        } else {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }

}
