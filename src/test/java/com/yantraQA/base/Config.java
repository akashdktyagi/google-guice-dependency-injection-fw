package com.yantraQA.base;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Config {
    Integer timeOut = 20;
    String url = "https://parabank.parasoft.com/parabank/index.htm";
    String userName = "john";
    String password = "demo";
}
