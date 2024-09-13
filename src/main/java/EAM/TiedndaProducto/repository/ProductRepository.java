package EAM.TiedndaProducto.repository;
import EAM.TiedndaProducto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
