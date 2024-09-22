package EAM.TiendaProducto.service;//package service;
import EAM.TiendaProducto.model.Store;
import EAM.TiendaProducto.repository.RepositoryStore;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceStore {

    @Autowired
    private RepositoryStore repositoryStore;

    public List<Store> findAll() {
        return repositoryStore.findAll();
    }

    public Store searchStore(Long id) {
        return repositoryStore.findById(id).orElse(null);
    }

    public Store createStore(Store store) {
        return repositoryStore.save(store);
    }

    @Transactional
    public void updateStore(Long id, Store updatedStoreData) {
        Store existingStore = repositoryStore.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Store not found with id: " + id));
        existingStore.setName(updatedStoreData.getName());
        existingStore.setLocation(updatedStoreData.getLocation());
        existingStore.setProducts(updatedStoreData.getProducts()); // If you want to update products too

        repositoryStore.save(existingStore);
    }

    public void deleteStore(Long id) {
        if (repositoryStore.existsById(id)) {
            repositoryStore.deleteById(id); // La eliminación en cascada de los productos asociados ocurre aquí
        } else {
            throw new EntityNotFoundException("Tienda no encontrada con id: " + id);
        }
    }
}
