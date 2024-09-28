package EAM.TiendaProducto.controller;

import EAM.TiendaProducto.model.Product;
import EAM.TiendaProducto.model.Store;
import EAM.TiendaProducto.dto.DtoStore;
import EAM.TiendaProducto.service.ServiceProduct;
import EAM.TiendaProducto.service.ServiceStore;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class ControllerStore {

    @Autowired
    private ServiceStore serviceStore;

    @GetMapping
    public List<Store> getAllStores() {
        return serviceStore.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
        Store store = serviceStore.searchStore(id);
        return store != null ? ResponseEntity.ok(store) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Store> createStore(@Valid @RequestBody Store store) {
        Store createdStore = serviceStore.createStore(store);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStore);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStore(@PathVariable Long id, @Valid @RequestBody Store store) {
        try {
            serviceStore.updateStore(id, store);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        try {
            serviceStore.deleteStore(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}