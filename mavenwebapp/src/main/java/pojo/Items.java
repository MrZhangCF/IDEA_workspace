package pojo;

import java.util.Date;

public class Items {
    private Integer id;
    private String name;
    private Integer price;
    private Date createTime;
    private String detail;

    public Items(Integer id, String name, Integer price, Date createTime, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createTime = createTime;
        this.detail = detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", detail='" + detail + '\'' +
                '}';
    }
}
