package pojo;

public class Product {
    private String id;
    private String name;
    private String price;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id == null?null:id.trim();
    }

    public void setName(String name) {
        this.name = name == null ? null:name.trim();
    }

    public void setPrice(String price) {
        this.price = price == null ? null:price.trim();
    }
}
