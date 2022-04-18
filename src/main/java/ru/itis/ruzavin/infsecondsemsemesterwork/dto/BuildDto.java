package ru.itis.ruzavin.infsecondsemsemesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.Build;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.Guide;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuildDto {
	private Integer id;

	private String title;
	private String text;
	private String photoUrl;
	private String userNick;
	private LocalDateTime date;

	public static BuildDto from(Build build) {
		return BuildDto.builder()
				.id(build.getId())
				.date(build.getDate())
				.photoUrl(build.getPhotoUrl())
				.text(build.getText())
				.title(build.getTitle())
				.userNick(build.getUser().getNick())
				.build();
	}

	public static List<BuildDto> from(List<Build> builds) {
		return builds.stream()
				.map(BuildDto::from)
				.collect(Collectors.toList());
	}
}
