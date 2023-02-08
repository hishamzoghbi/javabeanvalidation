package de.adesso.beanvalidation.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import de.adesso.beanvalidation.constraint.Phone;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	private Long id;

    @NotNull
    @Size(min = 2, max = 200)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotBlank
    @Phone
    private String phonenumber;


    @NotNull
    @Pattern(regexp = "^(?=.*\\d).{8,30}$", message = "Password must be between 8 and 30 digits long and include at least one numeric digit.")
    private String password;

}
