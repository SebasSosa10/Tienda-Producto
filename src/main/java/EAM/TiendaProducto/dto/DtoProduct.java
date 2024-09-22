package EAM.TiendaProducto.dto;

public class DtoProduct {
        private String name;
        private String description;
        private double price;
        private int stock;
        private int storeId;

    public DtoProduct() {
        super();
    }

    public DtoProduct(String name, String description, double price, int stock, int storeId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.storeId = storeId;
    }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getStoreId() {
            return storeId;
        }

        public void setStoreId(int storeId) {
            this.storeId = storeId;
        }
}
