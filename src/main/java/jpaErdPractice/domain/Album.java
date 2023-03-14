package jpaErdPractice.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue("A")
public class Album extends Item {
    private String artist;
    @Builder(builderMethodName = "albumBuilder")
    public Album(Long id, String name, int price, int stockQuantity, List<Category> categories, String artist) {
        super(id, name, price, stockQuantity, categories);
        this.artist = artist;
    }
}
