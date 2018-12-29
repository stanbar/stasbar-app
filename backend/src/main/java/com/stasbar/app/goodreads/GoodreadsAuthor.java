package com.stasbar.app.goodreads;

import com.stasbar.app.utils.AdapterCDATA;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;

@XmlRootElement(name = "author")
public class GoodreadsAuthor {
    @XmlElement
    public String id= "";
    @XmlElement(name = "image_url")
    public GoodreadsImageUrl imageUrl;
    @XmlElement
    public String name= "";
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String link= "";
    @XmlElement
    public String role= "";
    @XmlElement(name = "average_rating")
    public double averageRating;
    @XmlElement(name = "text_reviews_count")
    public String reviewsCount= "";
    @XmlElement(name = "ratings_count")
    public int ratingsCount;
    @XmlElement(name = "small_image_url")
    public GoodreadsImageUrl smallImageUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodreadsAuthor that = (GoodreadsAuthor) o;
        return Double.compare(that.averageRating, averageRating) == 0 &&
                ratingsCount == that.ratingsCount &&
                Objects.equals(id, that.id) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(name, that.name) &&
                Objects.equals(role, that.role) &&
                Objects.equals(reviewsCount, that.reviewsCount) &&
                Objects.equals(smallImageUrl, that.smallImageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imageUrl, name, role, averageRating, reviewsCount, ratingsCount, smallImageUrl);
    }
}
