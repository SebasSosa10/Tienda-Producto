package EAM.TiendaProducto.dto;
import java.util.List;

public class DtoStore {
    private String name;
    private String location;

    public DtoStore() {
        super();
    }

    public DtoStore(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
