package com.example.wallet_service.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private int id;
    private int amount;
    private int sid;//sender's id
    private int rid;//receiver id
    private Date date;
    private String status;

    public Transaction() {
    }

    public Transaction(int id, int amount, int sid, int rid, Date date,String status) {
        this.id = id;
        this.amount = amount;
        this.sid = sid;
        this.rid = rid;
        this.date = date;
        this.status=status;
    }
}
