package ru.itis.ruzavin.infsecondsemsemesterwork.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.BuildComment;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.GuideComment;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CommentDto {
	private Integer id;
	private String userAvatar;
	private String userNick;
	private Integer userId;
	private String text;

	public static CommentDto from(BuildComment buildComment) {
		return CommentDto.builder()
				.id(buildComment.getId())
				.userId(buildComment.getUser().getId())
				.userAvatar(buildComment.getUser().getAvatarUrl())
				.userNick(buildComment.getUser().getNick())
				.text(buildComment.getText())
				.build();
	}

	public static CommentDto from(GuideComment guideComment) {
		return CommentDto.builder()
				.id(guideComment.getId())
				.userId(guideComment.getUser().getId())
				.userAvatar(guideComment.getUser().getAvatarUrl())
				.userNick(guideComment.getUser().getNick())
				.text(guideComment.getText())
				.build();
	}

	public static List<CommentDto> fromBuildComments(List<BuildComment> comments) {
		return comments.stream()
				.map(CommentDto::from)
				.collect(Collectors.toList());
	}

	public static List<CommentDto> fromGuideComments(List<GuideComment> comments) {
		return comments.stream()
				.map(CommentDto::from)
				.collect(Collectors.toList());
	}

}
