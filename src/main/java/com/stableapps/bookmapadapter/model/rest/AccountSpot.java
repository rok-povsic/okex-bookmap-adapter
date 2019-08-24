package com.stableapps.bookmapadapter.model.rest;

import lombok.Data;

@Data
public class AccountSpot extends Wallet {

    int id;
    double frozen;
    double holds;
}
