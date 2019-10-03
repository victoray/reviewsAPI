package com.udacity.course3.reviews.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "review")
    String review;

    @Column(name = "product_id")
    int productId;

    @Column(name = "time")
    String time;

    Product product;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "review")
    Set<Comment> comments = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "review")
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    public Product getProduct(){
        return product;
    }
}
