package us.mattgreen.model;

public class Product {
        private String id;
        private String productName;
        private String price;
        private String description;

        public Product(String id, String productName, String price, String description) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String first) {
            this.productName = productName;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
