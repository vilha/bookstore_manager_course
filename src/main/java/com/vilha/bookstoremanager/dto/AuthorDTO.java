package com.vilha.bookstoremanager.controller.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    private Long id;

    @NotBlank
    @Size(Max = 200)
    private String name;

    @NotNull
    @Size(Max = 100)
    private Integer age;
}

