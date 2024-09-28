package EAM.TiendaProducto.dto;
import jakarta.validation.constraints.*;

import java.util.List;

public class DtoStore {
    @NotBlank(message = "Este campo no puede estar Vacio")
    @Size(min = 6, message = "Es menor de 6 caracteres")
    private String name;
    @NotBlank(message = "Este campo no puede estar Vacio")
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
