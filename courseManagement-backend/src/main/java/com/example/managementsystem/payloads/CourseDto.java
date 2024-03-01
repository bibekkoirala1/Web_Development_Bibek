package com.example.managementsystem.payloads;

//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CourseDto {
    private int id;
    @NotBlank
    @Size(min = 4, message = "The title should be of minimum 4 characters")
    private String title;
    @NotBlank
    @Size(min = 8, message = "The description should be of minimum 8 characters ")
    private String description;
}
