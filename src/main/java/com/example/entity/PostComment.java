package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class PostComment {
    @Id
    @GeneratedValue
    private Long id;

    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    public PostComment(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PostComment)) {
            return false;
        }
        return id != null && id.equals(((PostComment) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
