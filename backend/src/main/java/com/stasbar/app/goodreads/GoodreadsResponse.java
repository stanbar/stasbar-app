package com.stasbar.app.goodreads;

import org.jetbrains.annotations.Nullable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "GoodreadsResponse")
public class GoodreadsResponse {
    @XmlElement
    public GoodreadsRequest Request;
    @XmlElement
    @Nullable
    public GoodreadsShelf shelf;

    @XmlElement(required = true)
    public GoodreadsReviews reviews;

    public GoodreadsResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodreadsResponse that = (GoodreadsResponse) o;
        return Objects.equals(Request, that.Request) &&
                Objects.equals(shelf, that.shelf) &&
                Objects.equals(reviews, that.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Request, shelf, reviews);
    }

    @Override
    public String toString() {
        return "GoodreadsResponse{" +
                "Request=" + Request +
                ", shelf=" + shelf +
                ", reviews=" + reviews +
                '}';
    }
}

