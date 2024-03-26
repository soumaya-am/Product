package com.example.orm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Product  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id ;
    private String name;
    private double price ;
   private int quantity;
}
