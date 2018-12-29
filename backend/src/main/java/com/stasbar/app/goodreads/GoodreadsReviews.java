package com.stasbar.app.goodreads;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "reviews")
public class GoodreadsReviews {
    @XmlAttribute
    public int total;
    @XmlAttribute
    public int start;
    @XmlAttribute
    public int end;
    @XmlElement(name = "review")
    public List<GoodreadsReview> reviews = new ArrayList<>();

    public GoodreadsReviews() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodreadsReviews that = (GoodreadsReviews) o;
        return Objects.equals(total, that.total) &&
                Objects.equals(start, that.start) &&
                Objects.equals(end, that.end) &&
                Objects.equals(reviews, that.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, start, end, reviews);
    }

    @Override
    public String toString() {
        return "GoodreadsReviews{" +
                "total='" + total + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", review=" + reviews +
                '}';
    }
}
