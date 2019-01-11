/*
 * Copyright 2019 Stanislaw stasbar Baranski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *          __             __
 *    _____/ /_____ ______/ /_  ____ ______
 *   / ___/ __/ __ `/ ___/ __ \/ __ `/ ___/
 *  (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
 * /____/\__/\__,_/____/_.___/\__,_/_/
 *            stasbar@stasbar.com
 */

package com.stasbar.app.goodreads;

import com.stasbar.app.utils.AdapterCDATA;
import org.jetbrains.annotations.NotNull;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "book")
public class GoodreadsBook {
    @XmlElement
    public GoodreadsInt id;
    @XmlElement
    public String isbn = "";
    @XmlElement
    public String isbn13 = "";
    @XmlElement
    public String title = "";
    @XmlElement(name = "title_without_series")
    public String titleWithoutSeries;
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String link = "";
    @XmlElement
    public GoodreadsWork work;
    @XmlElement(name = "num_pages")
    public int numPages;
    @XmlElement(name = "large_image_url")
    public String largeImageUrl = "";
    @XmlElement(name = "average_rating")
    public double averageRating;
    @XmlElement(name = "ratings_count")
    public int ratingsCount;
    @XmlElement
    public String format = "";
    @XmlElement(name = "small_image_url")
    @NotNull
    public String smallImageUrl = "";
    @XmlElement
    public String uri = "";
    @XmlElement
    public String published = "";
    @XmlElement
    public String publisher = "";
    @XmlElement(name = "author")
    @XmlElementWrapper(name = "authors")
    public List<GoodreadsAuthor> authors = new ArrayList<>();
    @XmlElement(name = "publication_day")
    public int publicationDay;
    @XmlElement(name = "publication_month")
    public int publicationMonth;
    @XmlElement(name = "publication_year")
    public int publicationYear;
    @XmlElement(name = "image_url")
    @NotNull
    public String imageUrl = "";
    @XmlElement
    public String description = "";
    @XmlElement(name = "text_reviews_count")
    public GoodreadsInt reviewsCount;
    @XmlElement(name = "edition_information")
    public String editionInformation = "";

    public GoodreadsBook() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodreadsBook that = (GoodreadsBook) o;
        return numPages == that.numPages &&
                Double.compare(that.averageRating, averageRating) == 0 &&
                ratingsCount == that.ratingsCount &&
                publicationDay == that.publicationDay &&
                publicationMonth == that.publicationMonth &&
                publicationYear == that.publicationYear &&
                Objects.equals(id, that.id) &&
                Objects.equals(isbn, that.isbn) &&
                Objects.equals(isbn13, that.isbn13) &&
                Objects.equals(title, that.title) &&
                Objects.equals(titleWithoutSeries, that.titleWithoutSeries) &&
                Objects.equals(work, that.work) &&
                Objects.equals(largeImageUrl, that.largeImageUrl) &&
                Objects.equals(format, that.format) &&
                Objects.equals(smallImageUrl, that.smallImageUrl) &&
                Objects.equals(uri, that.uri) &&
                Objects.equals(published, that.published) &&
                Objects.equals(publisher, that.publisher) &&
                Objects.equals(authors, that.authors) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(description, that.description) &&
                Objects.equals(reviewsCount, that.reviewsCount) &&
                Objects.equals(editionInformation, that.editionInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, isbn13, title, titleWithoutSeries, work, numPages, largeImageUrl, averageRating, ratingsCount, format, smallImageUrl, uri, published, publisher, authors, publicationDay, publicationMonth, publicationYear, imageUrl, description, reviewsCount, editionInformation);
    }
}
