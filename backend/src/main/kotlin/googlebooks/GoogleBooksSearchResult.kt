/*
 * Copyright 2019 Stanislaw Baranski @stasbar
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

package googlebooks

import com.squareup.moshi.Json


class GoogleBooksSearchResult {
  @Json(name = "kind")
  var kind: String? = null
  @Json(name = "totalItems")
  var totalItems: Int? = null
  @Json(name = "items")
  var items: List<Item>? = null
}

class AccessInfo {
  @Json(name = "country")
  var country: String? = null
  @Json(name = "viewability")
  var viewability: String? = null
  @Json(name = "embeddable")
  var embeddable: Boolean? = null
  @Json(name = "publicDomain")
  var publicDomain: Boolean? = null
  @Json(name = "textToSpeechPermission")
  var textToSpeechPermission: String? = null
  @Json(name = "epub")
  var epub: Epub? = null
  @Json(name = "pdf")
  var pdf: Pdf? = null
  @Json(name = "webReaderLink")
  var webReaderLink: String? = null
  @Json(name = "accessViewStatus")
  var accessViewStatus: String? = null
  @Json(name = "quoteSharingAllowed")
  var quoteSharingAllowed: Boolean? = null
}

class Epub {
  @Json(name = "isAvailable")
  var isAvailable: Boolean? = null
}

class ImageLinks {
  @Json(name = "smallThumbnail")
  var smallThumbnail: String? = null
  @Json(name = "thumbnail")
  var thumbnail: String? = null
}

class IndustryIdentifier {
  @Json(name = "type")
  var type: String? = null
  @Json(name = "identifier")
  var identifier: String? = null
}

class Item {
  @Json(name = "kind")
  var kind: String? = null
  @Json(name = "id")
  var id: String? = null
  @Json(name = "etag")
  var etag: String? = null
  @Json(name = "selfLink")
  var selfLink: String? = null
  @Json(name = "volumeInfo")
  var volumeInfo: VolumeInfo? = null
  @Json(name = "saleInfo")
  var saleInfo: SaleInfo? = null
  @Json(name = "accessInfo")
  var accessInfo: AccessInfo? = null
  @Json(name = "searchInfo")
  var searchInfo: SearchInfo? = null
}

class Pdf {
  @Json(name = "isAvailable")
  var isAvailable: Boolean? = null
}

class ReadingModes {
  @Json(name = "text")
  var text: Boolean? = null
  @Json(name = "image")
  var image: Boolean? = null
}

class SaleInfo {
  @Json(name = "country")
  var country: String? = null
  @Json(name = "saleability")
  var saleability: String? = null
  @Json(name = "isEbook")
  var isEbook: Boolean? = null
}

class SearchInfo {
  @Json(name = "textSnippet")
  var textSnippet: String? = null
}

class VolumeInfo {
  @Json(name = "title")
  var title: String? = null
  @Json(name = "subtitle")
  var subtitle: String? = null
  @Json(name = "authors")
  var authors: List<String>? = null
  @Json(name = "publisher")
  var publisher: String? = null
  @Json(name = "publishedDate")
  var publishedDate: String? = null
  @Json(name = "description")
  var description: String? = null
  @Json(name = "industryIdentifiers")
  var industryIdentifiers: List<IndustryIdentifier>? = null
  @Json(name = "readingModes")
  var readingModes: ReadingModes? = null
  @Json(name = "pageCount")
  var pageCount: Int? = null
  @Json(name = "printType")
  var printType: String? = null
  @Json(name = "categories")
  var categories: List<String>? = null
  @Json(name = "averageRating")
  var averageRating: Double? = null
  @Json(name = "ratingsCount")
  var ratingsCount: Int? = null
  @Json(name = "maturityRating")
  var maturityRating: String? = null
  @Json(name = "allowAnonLogging")
  var allowAnonLogging: Boolean? = null
  @Json(name = "contentVersion")
  var contentVersion: String? = null
  @Json(name = "imageLinks")
  var imageLinks: ImageLinks? = null
  @Json(name = "language")
  var language: String? = null
  @Json(name = "previewLink")
  var previewLink: String? = null
  @Json(name = "infoLink")
  var infoLink: String? = null
  @Json(name = "canonicalVolumeLink")
  var canonicalVolumeLink: String? = null
}
