package edu.miu.lab1.Entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {
    private long id;
    private String title;
    private String content;
    private String author;
}
