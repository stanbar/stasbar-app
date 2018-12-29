package com.stasbar.app.goodreads;

import javax.xml.bind.annotation.*;
import java.util.Objects;

public class GoodreadsString {
    @XmlAttribute
    public String type;

    @XmlValue
    public String content;

    public GoodreadsString() {
        this("", "");
    }

    public GoodreadsString(String content, String type) {
        this.content = content;
        this.type = type;
    }

    public GoodreadsString(String content) {
        this(content, "integer");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodreadsString that = (GoodreadsString) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, content);
    }
}
