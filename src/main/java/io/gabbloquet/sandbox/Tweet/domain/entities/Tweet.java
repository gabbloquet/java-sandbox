package io.gabbloquet.sandbox.Tweet.domain.entities;

import io.gabbloquet.sandbox.User.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {

    private String id;
    private User user;
    private String message;
    private List<User> likes;
    private Tweet linkedTweet;
    private LocalDateTime date;

}
