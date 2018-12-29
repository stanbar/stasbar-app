package com.stasbar.app.goodreads;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class GoodreadsInt {
    @XmlAttribute
    public String type;
    @XmlValue
    public int content;

    public GoodreadsInt() {
        this(0, "");
    }

    public GoodreadsInt(int content) {
        this(content, "integer");
    }

    public GoodreadsInt(int content, String type) {
        this.content = content;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodreadsInt that = (GoodreadsInt) o;
        return content == that.content &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, content);
    }
}
