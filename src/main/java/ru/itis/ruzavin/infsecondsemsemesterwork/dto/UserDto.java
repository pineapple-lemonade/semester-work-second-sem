package ru.itis.ruzavin.infsecondsemsemesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	private Integer id;

	private String nick;
	private String email;
	private String password;
	private String avatarUrl;

	private User.Role role;

	private User.State state;

	public static UserDto from(User user) {
		return UserDto.builder()
				.id(user.getId())
				.email(user.getEmail())
				.password(user.getPassword())
				.avatarUrl(user.getAvatarUrl())
				.nick(user.getNick())
				.role(user.getRole())
				.state(user.getState())
				.build();
	}
}