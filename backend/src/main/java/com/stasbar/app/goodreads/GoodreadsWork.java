package com.stasbar.app.goodreads;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "work")
public class GoodreadsWork {
    @XmlElement
    public String id = "";
    @XmlElement
    public String uri = "";

    public GoodreadsWork() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodreadsWork that = (GoodreadsWork) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uri, that.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uri);
    }
}
