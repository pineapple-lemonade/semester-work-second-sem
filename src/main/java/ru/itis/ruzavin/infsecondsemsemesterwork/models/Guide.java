package ru.itis.ruzavin.infsecondsemsemesterwork.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "guides")
public class Guide {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;
	private String text;
	private String photoUrl;
	private LocalDateTime date;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Guide guide = (Guide) o;
		return id != null && Objects.equals(id, guide.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
