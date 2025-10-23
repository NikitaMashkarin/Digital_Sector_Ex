package ru.practicum.model;

import lombok.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @EqualsAndHashCode.Include
    private int id;

    private String firstName;
    private String lastName;
    private int salary;
}

