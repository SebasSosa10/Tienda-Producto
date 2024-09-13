package EAM.TiedndaProducto.service;//package service;
import EAM.TiedndaProducto.model.Product;
import EAM.TiedndaProducto.model.Store;
import EAM.TiedndaProducto.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TiendaProductoStore {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Optional<Store> findById(int id) {
        return storeRepository.findById(id);
    }

    public Store save(Store product) {
        return storeRepository.save(product);
    }

    public void deleteById(int id) {
        storeRepository.deleteById(id);
    }

}
