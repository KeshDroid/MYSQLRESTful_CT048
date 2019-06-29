package pizzaloop;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class CartOne {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private String pizName;
    private Double price;
    private Double total;
    private Integer qty;

    public String getPizName() {
        return pizName;
    }

    public void setPizName(String pizName) {
        this.pizName = pizName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
