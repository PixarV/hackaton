package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "temp")
public class Temp {
    @Id
    @SequenceGenerator(name = "temp_id_seq", sequenceName = "temp_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "temp_id_seq")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;
}
