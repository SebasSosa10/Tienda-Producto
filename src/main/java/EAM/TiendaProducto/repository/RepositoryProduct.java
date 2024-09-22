package EAM.TiendaProducto.repository;
import EAM.TiendaProducto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduct extends JpaRepository<Product, Long> {

}
