package com.example.division.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Divisions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "divisions_id")
    private Integer id;

    @Column(name = "divisions_name")
    private String name;

    @Column(name = "dt_from")
    private LocalDateTime dt_from;

    @Nullable
    @Column(name = "dt_till", updatable = true)
    private LocalDateTime dt_till;

    @Column(name = "sort_priority")
    private int sort_priority;

    @Column(name = "in_system")
    private boolean in_system;

    @Column(name = "creation_date")
    private LocalDateTime creation_date;

    @Nullable
    @Column(name = "correction_date")
    private LocalDateTime correction_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "FK_PARENT_ID"))
    @JsonBackReference
    private Divisions parent;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private List<Divisions> children = new ArrayList<>();

}
