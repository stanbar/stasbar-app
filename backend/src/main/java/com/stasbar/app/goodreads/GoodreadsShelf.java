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
    return Objects.equals(id, that.id)
      && Objects.equals(reviewShelfId, that.reviewShelfId)
      && Objects.equals(exclusive, that.exclusive)
      && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, reviewShelfId, exclusive, name);
  }
}
