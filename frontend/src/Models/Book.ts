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


export default class Book {
    public hash: string;
    public isbn10: string | null;
    public isbn13: string | null;
    public title: string;
    public goodreadsId: string;
    public authorName: string;
    public rating: Number;
    public imageUrl: string;
    public smallImageUrl: string;


    constructor(hash: string, isbn10: string | null, isbn13: string | null, title: string, goodreadsId: string, authorName: string, rating: Number, imageUrl: string, smallImageUrl: string) {
        this.hash = hash;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.title = title;
        this.goodreadsId = goodreadsId;
        this.authorName = authorName;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.smallImageUrl = smallImageUrl;
    }
}