package com.stasbar.app.goodreads;

import com.stasbar.app.utils.AdapterCDATA;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;

public class GoodreadsImageUrl {
    @XmlAttribute
    public boolean nophoto;

    @XmlValue
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String content= "";

    public GoodreadsImageUrl() {
    }

    public GoodreadsImageUrl(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodreadsImageUrl that = (GoodreadsImageUrl) o;
        return nophoto == that.nophoto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nophoto);
    }
}
