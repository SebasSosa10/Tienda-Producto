package EAM.TiendaProducto.repository;
import EAM.TiendaProducto.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryStore extends JpaRepository<Store, Long> {
    @Modifying
    @Query("UPDATE Store s SET s.name = :name, s.location = :location WHERE s.idStore = :id")
    int updateNameAndLocationById(@Param("id") Long id, @Param("name") String name, @Param("location") String location);
}
