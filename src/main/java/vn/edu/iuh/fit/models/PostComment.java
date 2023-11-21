package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@Table(name = "post_comment")
@Getter
@Setter
@NoArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "published", nullable = false)
    private boolean published;
    @Lob
    @Column(name = "content")
    private String content;
    @Column(name = "publishedAt")
    private Instant publishedAt;
    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private PostComment parent;
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private Post post;
    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments=new LinkedHashSet<>();

    public PostComment(String title, boolean published, String content, Instant publishedAt, Instant createdAt, PostComment parent, User user, Post post, Set<PostComment> postComments) {
        this.title = title;
        this.published = published;
        this.content = content;
        this.publishedAt = publishedAt;
        this.createdAt = createdAt;
        this.parent = parent;
        this.user = user;
        this.post = post;
        this.postComments = postComments;
    }
}
