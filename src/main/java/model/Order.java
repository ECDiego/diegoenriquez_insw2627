package model;

import com.uem.Calculator;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private List<Article> articles;

   
    public Order() {
        this.articles = new ArrayList<>();
    }
    public Order(String id, List<Article> articles) {
        this.id = id;
        this.articles = (articles != null) ? articles : new ArrayList<>();
    }

 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Article article) {
        this.articles.add(article);
    }

   
    public double getGrossTotal() {
        List<Double> importes = new ArrayList<>();
        for (Article art : articles) {
            importes.add(art.getGrossAmount());
        }
        Calculator calc = new Calculator();
        return calc.calculateTotal(importes);
    }

    // Suma total con desc de cada art (revisar + dudaclase)
    public double getDiscountedTotal() {
        List<Double> importesConDesc = new ArrayList<>();
        for (Article art : articles) {
            importesConDesc.add(art.getDiscountedAmount());
        }
        Calculator calc = new Calculator();
        return calc.calculateTotal(importesConDesc);
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", articles=" + articles + "]";
    }
}