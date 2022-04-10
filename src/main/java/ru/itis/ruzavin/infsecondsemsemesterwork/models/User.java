package ru.itis.ruzavin.infsecondsemsemesterwork.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nick;
	private String email;
	private String password;
	private String avatarUrl;

	@OneToMany(mappedBy = "user")
	private Set<Guide> guides;

	@OneToMany(mappedBy = "user")
	private Set<Build> builds;
}
