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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "reviews")
public class GoodreadsReviews {
  @XmlAttribute
  public int total;
  @XmlAttribute
  public int start;
  @XmlAttribute
  public int end;

  @XmlElement(name = "review")
  public List<GoodreadsReview> reviews = new ArrayList<>();

  public GoodreadsReviews() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GoodreadsReviews that = (GoodreadsReviews) o;
    return Objects.equals(total, that.total)
      && Objects.equals(start, that.start)
      && Objects.equals(end, that.end)
      && Objects.equals(reviews, that.reviews);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, start, end, reviews);
  }

  @Override
  public String toString() {
    return "GoodreadsReviews{"
      + "total='"
      + total
      + '\''
      + ", start='"
      + start
      + '\''
      + ", end='"
      + end
      + '\''
      + ", review="
      + reviews
      + '}';
  }
}
