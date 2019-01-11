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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;

@XmlRootElement(name = "author")
public class GoodreadsAuthor {
  @XmlElement
  public String id = "";

  @XmlElement(name = "image_url")
  public GoodreadsImageUrl imageUrl;

  @XmlElement
  public String name = "";

  @XmlJavaTypeAdapter(AdapterCDATA.class)
  public String link = "";

  @XmlElement
  public String role = "";

  @XmlElement(name = "average_rating")
  public double averageRating;

  @XmlElement(name = "text_reviews_count")
  public String reviewsCount = "";

  @XmlElement(name = "ratings_count")
  public int ratingsCount;

  @XmlElement(name = "small_image_url")
  public GoodreadsImageUrl smallImageUrl;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GoodreadsAuthor that = (GoodreadsAuthor) o;
    return Double.compare(that.averageRating, averageRating) == 0
      && ratingsCount == that.ratingsCount
      && Objects.equals(id, that.id)
      && Objects.equals(imageUrl, that.imageUrl)
      && Objects.equals(name, that.name)
      && Objects.equals(role, that.role)
      && Objects.equals(reviewsCount, that.reviewsCount)
      && Objects.equals(smallImageUrl, that.smallImageUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      id, imageUrl, name, role, averageRating, reviewsCount, ratingsCount, smallImageUrl);
  }
}
