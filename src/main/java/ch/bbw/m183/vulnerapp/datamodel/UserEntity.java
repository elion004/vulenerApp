package ch.bbw.m183.vulnerapp.datamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@NotBlank(message = "username is mandatory")
	@Pattern(regexp = "^[^;<>&|]*$", message = "Invalid input")
	String username;

	@Column
	@Pattern(regexp = "^[^;<>&|]*$", message = "Invalid input")
	String fullname;

	@Column
	@NotBlank(message = "password is mandatory")
	@Pattern(regexp = "^[^;<>&|]*$", message = "Invalid input")
	String password;

}
