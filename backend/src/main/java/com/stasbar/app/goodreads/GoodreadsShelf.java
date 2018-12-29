package com.stasbar.app.goodreads;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "shelf")
public class GoodreadsShelf {
    @XmlAttribute
    public String id = "";
    @XmlAttribute(name = "review_shelf_id")
    public String reviewShelfId = "";
    @XmlAttribute
    public boolean exclusive;
    @XmlAttribute
    public String name = "";
    @XmlAttribute
    public boolean sortable;

    public GoodreadsShelf() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodreadsShelf that = (GoodreadsShelf) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(reviewShelfId, that.reviewShelfId) &&
                Objects.equals(exclusive, that.exclusive) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reviewShelfId, exclusive, name);
    }
}
