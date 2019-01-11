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

import {createStyles, GridList, GridListTile, GridListTileBar, WithStyles} from "@material-ui/core";
import React, {Component} from "react";
import {Route, RouteComponentProps} from "react-router";
import {Link} from "react-router-dom";
import Api from "../../Api";
import Book from "../../Models/Book";
import BookView from "./BookView";

const styles = createStyles({
  root: {
    display: "flex",
    flexWrap: "wrap",
    justifyContent: "space-around",
    overflow: "hidden",
  },
});

interface IBooksState {
  books: Book[];
}

export default class Books extends Component<RouteComponentProps & WithStyles<typeof styles>, IBooksState> {

  public state: IBooksState = {
    books: new Array<Book>(),
  };

  constructor(props: Readonly<RouteComponentProps & WithStyles<typeof styles>>) {
    super(props);
    this.fetchBooks();
  }

  public render() {
    const {match, classes} = this.props;
    const {books} = this.state;
    const bookView = (props: any) =>
      <BookView
        {...props}
        book={books.find((book: Book) => book.hash === props.match.params.hash)}
      />;

    return (
      <div className={classes.root}>
        <GridList cols={4} cellHeight={300} style={{width: 800, height: 800}}>
          {books.map((book: Book) =>
            <Link to={`${match.url}/${book.hash}`}>
              <GridListTile key={book.hash} style={{height: 300}}>
                <img src={book.imageUrl} alt={book.title}/>
                <GridListTileBar
                  title={book.title}
                  subtitle={<span>by: {book.author}</span>}
                />
              </GridListTile>
            </Link>,
          )}

        </GridList>

        <Route
          path={`${match.path}/:hash`}
          component={bookView}
        />
      </div>
    );
  }

  private async fetchBooks() {
    const books: Book[] = await Api.fetchBooks();
    console.log(books);
    this.setState({books});
  }
}
