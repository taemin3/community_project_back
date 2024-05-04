package protest.test.dto;

import lombok.Data;

@Data
public class PostDto {
    private String title;
    private String content;
    private String boardName;
    private String memberId;
}
