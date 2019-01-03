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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "review")
public class GoodreadsReview {
    @XmlElement(name = "spoiler_flag")
    public boolean spoilerFlag;
    @XmlElement
    public String body= "";
    @XmlElement(name = "comments_count")
    public int commentsCount;
    @XmlElement
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String link= "";
    @XmlElement(name = "shelf")
    @XmlElementWrapper(name = "shelves")
    public List<GoodreadsShelf> shelves = new ArrayList<>();
    @XmlElement
    public int votes;
    @XmlElement(name = "spoilers_state")
    public String spoilersState= "";
    @XmlElement(name = "recommended_by")
    public String recommendedBy= "";
    @XmlElement
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String url= "";
    @XmlElement
    public int owned;
    @XmlElement(name = "read_count")
    public int readCount;
    @XmlElement
    public String id= "";
    @XmlElement(name = "date_added")
    public String dateAdded= "";
    @XmlElement(name = "date_updated")
    public String dateUpdated= "";
    @XmlElement(name = "read_at")
    public String readAt= "";
    @XmlElement
    public GoodreadsBook book;
    @XmlElement(name = "started_at")
    public String startedAt= "";
    @XmlElement
    public int rating;
    @XmlElement(name = "recommended_for")
    public String recommendedFor= "";


    public GoodreadsReview() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodreadsReview that = (GoodreadsReview) o;
        return Objects.equals(spoilerFlag, that.spoilerFlag) &&
                Objects.equals(body, that.body) &&
                Objects.equals(commentsCount, that.commentsCount) &&
                Objects.equals(link, that.link) &&
                Objects.equals(shelves, that.shelves) &&
                Objects.equals(votes, that.votes) &&
                Objects.equals(spoilersState, that.spoilersState) &&
                Objects.equals(recommendedBy, that.recommendedBy) &&
                Objects.equals(url, that.url) &&
                Objects.equals(owned, that.owned) &&
                Objects.equals(readCount, that.readCount) &&
                Objects.equals(id, that.id) &&
                Objects.equals(dateAdded, that.dateAdded) &&
                Objects.equals(dateUpdated, that.dateUpdated) &&
                Objects.equals(readAt, that.readAt) &&
                Objects.equals(book, that.book) &&
                Objects.equals(startedAt, that.startedAt) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(recommendedFor, that.recommendedFor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spoilerFlag, body, commentsCount, link, shelves, votes, spoilersState, recommendedBy, url, owned, readCount, id, dateAdded, dateUpdated, readAt, book, startedAt, rating, recommendedFor);
    }

    @Override
    public String toString() {
        return "GoodreadsReview{" +
                "spoilerFlag='" + spoilerFlag + '\'' +
                ", body='" + body + '\'' +
                ", commentsCount='" + commentsCount + '\'' +
                ", link='" + link + '\'' +
                ", shelves=" + shelves +
                ", votes='" + votes + '\'' +
                ", spoilersState='" + spoilersState + '\'' +
                ", recommendedBy='" + recommendedBy + '\'' +
                ", url='" + url + '\'' +
                ", owned='" + owned + '\'' +
                ", readCount='" + readCount + '\'' +
                ", id='" + id + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                ", dateUpdated='" + dateUpdated + '\'' +
                ", readAt='" + readAt + '\'' +
                ", book=" + book +
                ", startedAt='" + startedAt + '\'' +
                ", rating='" + rating + '\'' +
                ", recommendedFor='" + recommendedFor + '\'' +
                '}';
    }
}
