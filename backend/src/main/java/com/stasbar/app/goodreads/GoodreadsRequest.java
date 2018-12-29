package com.stasbar.app.goodreads;

import com.stasbar.app.utils.AdapterCDATA;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;


@XmlRootElement(name = "Request")
public class GoodreadsRequest {
    @XmlElement
    public boolean authentication;
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    @XmlElement
    public String key= "";
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    @XmlElement
    public String method= "";

    public GoodreadsRequest() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodreadsRequest that = (GoodreadsRequest) o;
        return authentication == that.authentication;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authentication);
    }
    @Override
    public String toString() {
        return "GoodreadsRequest{" +
                "authentication=" + authentication +
                ", key='" + key + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
