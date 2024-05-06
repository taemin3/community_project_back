package protest.test.dto;

import lombok.Data;
import protest.test.entity.Post;

@Data
public class PostListDto {
    Long id;
    String title;
    String content;
    String memberName;
    int goodCount;
    int commentCount;

    public PostListDto(Post post) {
        id = post.getId();
        title = post.getTitle();
        content = post.getContent();
        memberName = post.getMember().getName();
        goodCount = post.getGoodCount();
        commentCount = post.getCommentCount();
    }

}
