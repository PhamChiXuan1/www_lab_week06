package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(name = "published", nullable = false)
    private boolean published;
    @Lob
    @Column(name = "content", columnDefinition = "text")
    private String content;
    @Column(length = 100)
    private String metaTitle;
    @Lob
    @Column(columnDefinition = "text")
    private String summary;
    @Column(name = "createdAt",nullable = false)
    private Instant createdAt;
    @Column(length = 75, nullable = false)
    private String title;
    @Column(name = "updateAt")
    private Instant updateAt;
    @Column(name = "publishedAt")
    private Instant publishedAt;
    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false)
    private User author;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private Post parent;
    @OneToMany(mappedBy = "parent")
    private Set<Post> posts = new LinkedHashSet<>();
    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments=new LinkedHashSet<>();

    public Post(boolean published, String content, String metaTitle, String summary, Instant createdAt, String title, Instant updateAt, Instant publishedAt, User author, Post parent) {
        this.published = published;
        this.content = content;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.createdAt = createdAt;
        this.title = title;
        this.updateAt = updateAt;
        this.publishedAt = publishedAt;
        this.author = author;
        this.parent = parent;
    }
}
