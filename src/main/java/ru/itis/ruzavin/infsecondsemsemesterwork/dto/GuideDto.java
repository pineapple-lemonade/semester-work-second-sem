package ru.itis.ruzavin.infsecondsemsemesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.Guide;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuideDto {
	private Integer id;

	private String title;
	private String text;
	private String photoUrl;
	private String userNick;
	private LocalDateTime date;

	public static GuideDto from(Guide guide) {
		return GuideDto.builder()
				.id(guide.getId())
				.date(guide.getDate())
				.photoUrl(guide.getPhotoUrl())
				.text(guide.getText())
				.title(guide.getTitle())
				.userNick(guide.getUser().getNick())
				.build();
	}

	public static List<GuideDto> from(List<Guide> guides) {
		return guides.stream()
				.map(GuideDto::from)
				.collect(Collectors.toList());
	}
}
