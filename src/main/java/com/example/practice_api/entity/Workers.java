package com.example.practice_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.print.attribute.standard.DateTimeAtCreation;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NonNull
    private String Name;
    private String department;
    private String email;
    private DateTimeAtCreation createdAt;

}
