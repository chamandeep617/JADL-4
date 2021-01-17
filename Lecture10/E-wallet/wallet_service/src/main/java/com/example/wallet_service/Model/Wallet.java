package com.example.wallet_service.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "balance")
    private int balance;

    @Column(name = "is_active")
    private Boolean is_active;

    @Column(name = "wallet_type")
    private String wallet_type;

}