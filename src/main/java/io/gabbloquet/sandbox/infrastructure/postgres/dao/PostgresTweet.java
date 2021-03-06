package io.gabbloquet.sandbox.infrastructure.postgres.dao;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.gabbloquet.sandbox.infrastructure.postgres.dao.PostgresUser.fromUser;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tweets")
@Builder
public class PostgresTweet {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String message;

    @ManyToOne
    private PostgresUser user;

    @ManyToMany
    private List<PostgresUser> likes = new ArrayList<>();

    @ManyToOne
    private PostgresTweet linkedTweet;
    private Timestamp date;

    public static PostgresTweet fromTweet(Tweet tweet) {
        return new PostgresTweet().builder()
            .message(tweet.getMessage())
            .user(fromUser(tweet.getUser()))
            .likes(tweet.getLikes().stream().map(PostgresUser::fromUser).collect(Collectors.toList()))
            .linkedTweet(tweet.getLinkedTweet() != null ? fromTweet(tweet.getLinkedTweet()) : null)
            .date(Timestamp.valueOf(tweet.getDate()))
            .build();
    }

    public Tweet toTweet() {
        return new Tweet().builder()
            .id(id.toString())
            .message(message)
            .user(user.toUser())
            .likes(likes.stream().map(PostgresUser::toUser).collect(Collectors.toList()))
            .linkedTweet(linkedTweet != null ? linkedTweet.toTweet() : null)
            .date(date.toLocalDateTime())
            .build();
    }
}
