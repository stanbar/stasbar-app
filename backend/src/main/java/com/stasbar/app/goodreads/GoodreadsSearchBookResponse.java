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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "GoodreadsResponse")
public class GoodreadsSearchBookResponse {
  public GoodreadsRequest Request;
  public GoodreadsSearchBook search;

  @XmlRootElement(name = "search")
  public static class GoodreadsSearchBook {
    @XmlElement(name = "work")
    @XmlElementWrapper(name = "results")
    public List<GoodreadsSearchWork> results;

    @XmlRootElement(name = "work")
    public static class GoodreadsSearchWork {
      @XmlElement
      public GoodreadsInt id;

      @XmlElement(name = "best_book")
      public GoodreadsBestBook bestBook;

      @XmlRootElement(name = "best_book")
      public static class GoodreadsBestBook {
        @XmlElement
        public GoodreadsInt id;
        @XmlElement
        public String title;
        @XmlElement
        public GoodreadsBestBookAuthor author;

        @XmlElement(name = "image_url")
        public String imageUrl;

        @XmlElement(name = "small_image_url")
        public String smallImageUrl;

        @XmlRootElement(name = "author")
        public static class GoodreadsBestBookAuthor {
          @XmlElement
          public GoodreadsInt id;
          @XmlElement
          public String name;
        }
      }
    }
  }
}
