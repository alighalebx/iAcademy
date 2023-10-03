package com.example.iacdemy.entities.courses;

import com.example.iacdemy.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "courses")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity {

    @NotNull
    @NotBlank(message = "NoBlank")
    @Column(name = "title", length = 100)
    @Size(max = 100, message = "No More than 100 characters")
    private String title;

    @NotNull
    @NotBlank(message = "NoBlank")
    @Column(name = "description", length = 100) // Changed column name to "description"
    @Size(max = 100, message = "No More than 100 characters")
    private String description;

    @NotNull(message = "No Null :c")
    @DecimalMin("1.00")
    private BigDecimal price;
}
