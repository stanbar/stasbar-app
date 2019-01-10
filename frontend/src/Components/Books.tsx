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

import React, {Component} from "react";
import Book from "../Models/Book";
import {Route, RouteComponentProps} from "react-router";
import {Link} from "react-router-dom";
import BookView from "./BookView";
import Api from "../Api";
import {GridList, GridListTile, GridListTileBar} from "@material-ui/core";

interface IBooksProps {

}

interface IBooksState {
    books: Array<Book>;
}

export default class Books extends Component<RouteComponentProps<IBooksProps>, IBooksState> {

    public state: IBooksState = {
        books: new Array<Book>(),
    };


    constructor(props: Readonly<RouteComponentProps<IBooksProps>>) {
        super(props);
        this.fetchBooks()
    }

    public render() {
        const {match} = this.props;
        const {books} = this.state;
        return (
            <div style={{
                display: 'flex',
                flexWrap: 'wrap',
                justifyContent: 'space-around',
                overflow: 'hidden'
            }}>
                <GridList cols={4} cellHeight={300} style={{width: 800, height: 800}}>
                    {books.map((book: Book) =>
                        <Link to={`${match.url}/${book.hash}`}>
                            <GridListTile key={book.hash} style={{height: 300}}>
                                <img src={book.imageUrl} alt={book.title}/>
                                <GridListTileBar
                                    title={book.title}
                                    subtitle={<span>by: {book.authorName}</span>}
                                />
                            </GridListTile>
                        </Link>
                    )}


                </GridList>

                <Route path={`${match.path}/:hash`} component={(props: any) =>
                    <BookView {...props} book={books.find((book: Book) => book.hash === props.match.params.hash)}/>
                }/>

                {/*<Route*/}
                {/*exact*/}
                {/*path={match.path}*/}
                {/*render={() => <h3>Please select a book.</h3>}*/}
                {/*/>*/}
            </div>
        );
    }


    private async fetchBooks() {
        const books: Book[] = await Api.fetchBooks();
        console.log(books);
        this.setState({books});
    }
}

