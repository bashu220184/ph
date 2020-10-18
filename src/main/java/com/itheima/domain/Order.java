package com.itheima.domain;

import com.itheima.domain.User;

import java.util.Date;

/**
 * @Auther 王飞龙
 * @Date 2020-02-18 9:08
 */
public class Order {
    private int id;
    private Date ordertime;
    private double total;

    //描述当前订单所属哟用户
    private User user;

    public Order(int id, Date ordertime, double total, User user) {
        this.id = id;
        this.ordertime = ordertime;
        this.total = total;
        this.user = user;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
