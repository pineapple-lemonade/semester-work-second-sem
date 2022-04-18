package ru.itis.ruzavin.infsecondsemsemesterwork.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class GuideComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String text;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "guide_id", referencedColumnName = "id")
	private Guide guide;
}
