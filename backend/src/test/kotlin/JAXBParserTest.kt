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

package com.stasbar.app

import com.stasbar.app.goodreads.*
import org.junit.Test
import java.text.SimpleDateFormat
import kotlin.test.assertEquals


class JAXBParserTest {
    val dateformat = SimpleDateFormat("EEE MMM dd HH:mm:ss Z YYYY")

    private val exampleBook = GoodreadsBook().apply {
        id = GoodreadsString("3028")
        isbn = "0517548233"
        isbn13 = "9780517548233"
        reviewsCount = GoodreadsInt(840)
        uri = "kca://book/amzn1.gr.book.v1.Z3Z_wYLn5VGxl4WoxZa8_Q"
        title = "Economics in One Lesson: The Shortest  Surest Way to Understand Basic Economics"
        titleWithoutSeries = "Economics in One Lesson: The Shortest  Surest Way to Understand Basic\nEconomics"
        imageUrl = "https://images.gr-assets.com/books/1320423284m/3028.jpg"
        smallImageUrl = "https://images.gr-assets.com/books/1320423284s/3028.jpg"
        largeImageUrl = ""
        link = "https://www.goodreads.com/book/show/3028.Economics_in_One_Lesson"
        numPages = 218
        format = "Paperback"
        editionInformation = ""
        publisher = "Three Rivers Press"
        publicationDay = 0
        publicationYear = 1979
        publicationMonth = 0
        averageRating = 4.21
        ratingsCount = 12163
        published = "1979"
        description = """
            A million copy seller Henry Hazlitt’s ltigtEconomics in One Lessonlt/igt is a
                    classic economic primer. But it is also much more having become a fundamental influence on modern
                    “libertarian” economics of the type espoused by Ron Paul and others.ltbr /gtltbr /gtConsidered
                    among the leading economic thinkers of the “Austrian School” which includes Carl Menger Ludwig von
                    Mises Friedrich (F.A.) Hayek and others Henry Hazlitt (1894-1993) was a libertarian philosopher
            """.trimIndent()
        authors = listOf(
            GoodreadsAuthor().apply {
                id = "2062"
                name = "Henry Hazlitt"
                role = ""
                imageUrl =
                        GoodreadsImageUrl("https://images.gr-assets.com/authors/1243288736p5/2062.jpg")
                smallImageUrl =
                        GoodreadsImageUrl("https://images.gr-assets.com/authors/1243288736p2/2062.jpg")
                link = "https://www.goodreads.com/author/show/2062.Henry_Hazlitt"
                averageRating = 4.21
                ratingsCount = 13815
                reviewsCount = "1121"
            }
        )
        work = GoodreadsWork().apply {
            id = "6894"
            uri = "kca://work/amzn1.gr.work.v1.cMKjhXFbc6A6-5YJyXqLoQ"
        }
    }

    private val xmlExampleBook = """
            <book>
                <id type="integer">${exampleBook.id.content}</id>
                <isbn>${exampleBook.isbn}</isbn>
                <isbn13>${exampleBook.isbn13}</isbn13>
                <text_reviews_count type="integer">${exampleBook.reviewsCount.content}</text_reviews_count>
                <uri>${exampleBook.uri}</uri>
                <title>${exampleBook.title}</title>
                <title_without_series>${exampleBook.titleWithoutSeries}</title_without_series>
                <image_url>${exampleBook.imageUrl}</image_url>
                <small_image_url>${exampleBook.smallImageUrl}</small_image_url>
                <large_image_url/>
                <link>${exampleBook.link}</link>
                <num_pages>${exampleBook.numPages}</num_pages>
                <format>${exampleBook.format}</format>
                <edition_information/>
                <publisher>${exampleBook.publisher}</publisher>
                <publication_day/>
                <publication_year>${exampleBook.publicationYear}</publication_year>
                <publication_month/>
                <average_rating>${exampleBook.averageRating}</average_rating>
                <ratings_count>${exampleBook.ratingsCount}</ratings_count>
                <description>${exampleBook.description}</description>
                <authors>
                    <author>
                        <id>${exampleBook.authors[0].id}</id>
                        <name>${exampleBook.authors[0].name}</name>
                        <role>${exampleBook.authors[0].role}</role>
                        <image_url nophoto='false'><![CDATA[${exampleBook.authors[0].imageUrl.content}]]></image_url>
                        <small_image_url nophoto='false'><![CDATA[${exampleBook.authors[0].smallImageUrl.content}]]></small_image_url>
                        <link><![CDATA[${exampleBook.authors[0].link}]]></link>
                        <average_rating>${exampleBook.authors[0].averageRating}</average_rating>
                        <ratings_count>${exampleBook.authors[0].ratingsCount}</ratings_count>
                        <text_reviews_count>${exampleBook.authors[0].reviewsCount}</text_reviews_count>
                    </author>
                </authors>
                <published>${exampleBook.published}</published>
                <work>
                    <id>${exampleBook.work.id}</id>
                    <uri>${exampleBook.work.uri}</uri>
                </work>
            </book>
        """

    @Test
    fun xmlBookToKotlin() {
        val parsedBook :GoodreadsBook = XML.parse(xmlExampleBook)
        assertEquals(exampleBook, parsedBook)
    }


    private val exampleReview = GoodreadsReview().apply {
        id = "2634851867"
        rating = 0
        votes = 0
        spoilerFlag = false
        spoilersState = "none"
        recommendedFor = ""
        recommendedBy = ""
        startedAt = ""
        readAt = ""
        dateAdded = "Sat Dec 22 08:36:38 -0800 2018"
        dateUpdated = "Sat Dec 22 08:36:38 -0800 2018"
        readCount = 0
        body = ""
        commentsCount = 0
        url = "https://www.goodreads.com/review/show/2634851867"
        link = "https://www.goodreads.com/review/show/2634851867"
        owned = 0
        shelves = listOf(GoodreadsShelf().apply {
            this.exclusive = true
            this.id = "183390186"
            name = "to-read"
            reviewShelfId = "2280164511"
            sortable = true
        })
        this.book = exampleBook
    }
    private val xmlExampleReviewContent = """
        <review>
            <id>${exampleReview.id}</id>
            <rating>${exampleReview.rating}</rating>
            <votes>${exampleReview.votes}</votes>
            <spoiler_flag>${exampleReview.spoilerFlag}</spoiler_flag>
            <spoilers_state>${exampleReview.spoilersState}</spoilers_state>
            <recommended_for>${exampleReview.recommendedFor}</recommended_for>
            <recommended_by>${exampleReview.recommendedBy}</recommended_by>
            <started_at>${exampleReview.startedAt}</started_at>
            <read_at>${exampleReview.readAt}</read_at>
            <date_added>${exampleReview.dateAdded}</date_added>
            <date_updated>${exampleReview.dateUpdated}</date_updated>
            <read_count>${exampleReview.readCount}</read_count>
            <body>${exampleReview.body}</body>
            <comments_count>${exampleReview.commentsCount}</comments_count>
            <url><![CDATA[${exampleReview.url}]]></url>
            <link><![CDATA[${exampleReview.link}]]></link>
            <owned>${exampleReview.owned}</owned>
            <shelves>
                <shelf exclusive='${exampleReview.shelves[0].exclusive}' id='${exampleReview.shelves[0].id}'
                name='${exampleReview.shelves[0].name}' review_shelf_id='${exampleReview.shelves[0].reviewShelfId}'
                       sortable='${exampleReview.shelves[0].sortable}'></shelf>
            </shelves>
            $xmlExampleBook
        </review>
        """

    @Test
    fun xmlReviewToKotlin() {
        val parsedReview: GoodreadsReview = XML.parse(xmlExampleReviewContent)
        assertEquals(parsedReview, exampleReview)
    }

    @Test
    fun xmlResponseToKotlin() {
        val response = GoodreadsResponse().apply {
            Request = GoodreadsRequest().apply {
                authentication = true
                key = Config.GOODREADS_API_KEY
                method = "review_list"
            }
            shelf = null
            reviews = GoodreadsReviews().apply {
                reviews = listOf(
                    exampleReview,
                    exampleReview,
                    exampleReview
                )
                start = 1
                end = reviews.size
                total = 20
            }
        }
        val responeContent = """
        <GoodreadsResponse>
            <Request>
                <authentication>${response.Request.authentication}</authentication>
                <key><![CDATA[${response.Request.key}]]></key>
                <method><![CDATA[${response.Request.method}]]></method>
            </Request>

            <reviews start="${response.reviews.start}" end="${response.reviews.end}" total="${response.reviews.total}">
            $xmlExampleReviewContent
            $xmlExampleReviewContent
            $xmlExampleReviewContent
            </reviews>
        </GoodreadsResponse>
        """

        val parsedResponse: GoodreadsResponse = XML.parse(responeContent)
        println(XML.stringify(parsedResponse))
        assertEquals(response, parsedResponse)
    }
}