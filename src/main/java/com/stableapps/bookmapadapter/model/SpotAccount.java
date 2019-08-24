package com.stableapps.bookmapadapter.model;

import lombok.Data;

@Data
public class SpotAccount {

    double balance;
    double available;
    String currency;
    String id;
    double hold;
}
