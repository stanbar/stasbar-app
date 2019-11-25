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

import {
  createStyles,
  Grid,
  GridListTile,
  GridListTileBar,
  Theme,
  Typography,
  withStyles,
  WithStyles,
} from '@material-ui/core'
import React, { Component } from 'react'
import Api from '../Api'
import Book from '../models/Book'
import BookView from '../components/Books/BookView'

const styles = (theme: Theme) =>
  createStyles({
    root: {
      width: 'auto',
      marginLeft: theme.spacing(3),
      marginRight: theme.spacing(3),
      [theme.breakpoints.up(1100 + theme.spacing(6))]: {
        width: 1100,
        marginLeft: 'auto',
        marginRight: 'auto',
      },

      display: 'flex',
      flexWrap: 'wrap',
      flexGrow: 1,
      flexDirection: 'column',
      justifyContent: 'space-around',
      overflow: 'hidden',
      padding: `${theme.spacing(8)}px 0`,
    },
    img: {
      width: '100%',
      height: 'auto',
    },
  })

interface IBooksState {
  books: Book[]
  loading: boolean
}

class Books extends Component<WithStyles<typeof styles>, IBooksState> {
  public state: IBooksState = {
    books: new Array<Book>(),
    loading: true,
  }

  componentDidMount(): void {
    this.fetchBooks()
  }

  public render() {
    const { classes } = this.props
    const { books, loading } = this.state
    const bookView = (props: any) => (
      <BookView
        {...props}
        book={books.find((book: Book) => book.hash === props.match.params.hash)}
      />
    )

    return (
      <div className={classes.root}>
        <Grid container={true} spacing={16}>
          {loading && (
            <Grid item={true} sm={12}>
              <Typography variant="h5">Loading...</Typography>
            </Grid>
          )}
          {books.map((book: Book) => (
            <Grid
              key={book.hash}
              item={true}
              xs={4}
              sm={3}
              md={3}
              lg={2}
              style={{ height: 'auto', width: '100%' }}
            >
              <GridListTile>
                <img
                  src={book.imageUrl}
                  alt={book.title}
                  className={classes.img}
                />
                <GridListTileBar
                  title={book.title}
                  subtitle={<span>by: {book.author}</span>}
                />
              </GridListTile>
            </Grid>
          ))}
        </Grid>
      </div>
    )
  }

  private async fetchBooks() {
    try {
      const books: Book[] = await Api.fetchAllBooks()
      this.setState({ books, loading: false })
    } catch (e) {
      console.error(e)
      this.setState({ loading: false })
    }
  }
}

export default withStyles(styles)(Books)
