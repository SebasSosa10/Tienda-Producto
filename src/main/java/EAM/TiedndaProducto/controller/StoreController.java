package EAM.TiedndaProducto.controller;

import EAM.TiedndaProducto.model.Store;
import EAM.TiedndaProducto.service.TiendaProductoStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Store")
public class StoreController {

    @Autowired
    private TiendaProductoStore storeService;

    @GetMapping
    public List<Store> getAllProducts() {
        return storeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getProductById(@PathVariable int id) {
        Optional<Store> product = storeService.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Store createProduct(@RequestBody Store product) {
        return storeService.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> updateProduct(@PathVariable int id, @RequestBody Store productDetails) {
        Optional<Store> product = storeService.findById(id);

        if (product.isPresent()) {
            Store updatedProduct = product.get();
            updatedProduct.setName(productDetails.getName());
            updatedProduct.setLocation(productDetails.getLocation());
            return ResponseEntity.ok(storeService.save(updatedProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        if (storeService.findById(id).isPresent()) {
            storeService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
