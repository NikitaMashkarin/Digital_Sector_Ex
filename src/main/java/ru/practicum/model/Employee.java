package ru.practicum.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @EqualsAndHashCode.Include
    private int id;

    private String firstName;
    private String lastName;
    private int salary;
}

