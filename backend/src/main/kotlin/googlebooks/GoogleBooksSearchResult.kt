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


import com.google.gson.annotations.SerializedName

class GoogleBooksSearchResult {
  @SerializedName("kind")
  var kind: String? = null
  @SerializedName("totalItems")
  var totalItems: Int? = null
  @SerializedName("items")
  var items: List<Item>? = null
}

class AccessInfo {
  @SerializedName("country")
  var country: String? = null
  @SerializedName("viewability")
  var viewability: String? = null
  @SerializedName("embeddable")
  var embeddable: Boolean? = null
  @SerializedName("publicDomain")
  var publicDomain: Boolean? = null
  @SerializedName("textToSpeechPermission")
  var textToSpeechPermission: String? = null
  @SerializedName("epub")
  var epub: Epub? = null
  @SerializedName("pdf")
  var pdf: Pdf? = null
  @SerializedName("webReaderLink")
  var webReaderLink: String? = null
  @SerializedName("accessViewStatus")
  var accessViewStatus: String? = null
  @SerializedName("quoteSharingAllowed")
  var quoteSharingAllowed: Boolean? = null
}

class Epub {
  @SerializedName("isAvailable")
  var isAvailable: Boolean? = null
}

class ImageLinks {
  @SerializedName("smallThumbnail")
  var smallThumbnail: String? = null
  @SerializedName("thumbnail")
  var thumbnail: String? = null
}

class IndustryIdentifier {
  @SerializedName("type")
  var type: String? = null
  @SerializedName("identifier")
  var identifier: String? = null
}

class Item {
  @SerializedName("kind")
  var kind: String? = null
  @SerializedName("id")
  var id: String? = null
  @SerializedName("etag")
  var etag: String? = null
  @SerializedName("selfLink")
  var selfLink: String? = null
  @SerializedName("volumeInfo")
  var volumeInfo: VolumeInfo? = null
  @SerializedName("saleInfo")
  var saleInfo: SaleInfo? = null
  @SerializedName("accessInfo")
  var accessInfo: AccessInfo? = null
  @SerializedName("searchInfo")
  var searchInfo: SearchInfo? = null
}

class Pdf {
  @SerializedName("isAvailable")
  var isAvailable: Boolean? = null
}

class ReadingModes {
  @SerializedName("text")
  var text: Boolean? = null
  @SerializedName("image")
  var image: Boolean? = null
}

class SaleInfo {
  @SerializedName("country")
  var country: String? = null
  @SerializedName("saleability")
  var saleability: String? = null
  @SerializedName("isEbook")
  var isEbook: Boolean? = null
}

class SearchInfo {
  @SerializedName("textSnippet")
  var textSnippet: String? = null
}

class VolumeInfo {
  @SerializedName("title")
  var title: String? = null
  @SerializedName("subtitle")
  var subtitle: String? = null
  @SerializedName("authors")
  var authors: List<String>? = null
  @SerializedName("publisher")
  var publisher: String? = null
  @SerializedName("publishedDate")
  var publishedDate: String? = null
  @SerializedName("description")
  var description: String? = null
  @SerializedName("industryIdentifiers")
  var industryIdentifiers: List<IndustryIdentifier>? = null
  @SerializedName("readingModes")
  var readingModes: ReadingModes? = null
  @SerializedName("pageCount")
  var pageCount: Int? = null
  @SerializedName("printType")
  var printType: String? = null
  @SerializedName("categories")
  var categories: List<String>? = null
  @SerializedName("averageRating")
  var averageRating: Double? = null
  @SerializedName("ratingsCount")
  var ratingsCount: Int? = null
  @SerializedName("maturityRating")
  var maturityRating: String? = null
  @SerializedName("allowAnonLogging")
  var allowAnonLogging: Boolean? = null
  @SerializedName("contentVersion")
  var contentVersion: String? = null
  @SerializedName("imageLinks")
  var imageLinks: ImageLinks? = null
  @SerializedName("language")
  var language: String? = null
  @SerializedName("previewLink")
  var previewLink: String? = null
  @SerializedName("infoLink")
  var infoLink: String? = null
  @SerializedName("canonicalVolumeLink")
  var canonicalVolumeLink: String? = null
}
