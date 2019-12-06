package com.example.carrentals;

import java.util.ArrayList;
import java.util.List;

public class customer {

        private int id;
        private String name;
        int custAge;
       String  phone;
        private String username;
        private String password;
        private List<Integer> prodNo = new ArrayList<Integer>();

        public customer(int id, String name,int custAge,String phone, String username, String password) {
            this.id = id;
            this.name = name;
            this.custAge = custAge;
            this.phone = phone;
            this.username = username;
            this.password = password;

        }

        public void addPurchasedProduct(int prodNo) {
            this.prodNo.add(prodNo);
        }

        public int getId() {
            return id;
        }
        public String getName() {return name;}
        public String getUsername(){return username;}
        public String getPassword(){return password;}
        public int getCustAge(){return  custAge;}
        public List<Integer> getPurchasedProducts(){
            return prodNo;
        }
    }

