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

import React, {Component} from 'react'
import {
  Button,
  createStyles,
  Grid,
  GridListTile,
  GridListTileBar,
  Theme,
  Typography,
  withStyles,
  WithStyles,
} from '@material-ui/core'
import Book from '../../models/Book'
import {Link} from 'gatsby'
import Api from '../../Api'
import LibraryBookIcon from '@material-ui/icons/LibraryBooks'

const styles = (theme: Theme) =>
  createStyles({
    root: {
      margin: '0 auto',
      padding: `${theme.spacing(8)}px 0 ${theme.spacing(6)}px`,
    },
    layout: {
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
    nameTitle: {
      fontWeight: 500,
      fontSize: '2rem',
    },
    moreBooksButton: {
      width: 'auto',
      alignSelf: 'center',
      marginTop: 50,
      marginLeft: -12,
      marginRight: 20,
    },
    rightIcon: {
      marginLeft: theme.spacing(1),
    },
  })

interface IBestBooksState {
  books: Book[]
  loading: boolean
}

class BestBooks extends Component<WithStyles<typeof styles>, IBestBooksState> {
  public state: IBestBooksState = {
    books: new Array<Book>(),
    loading: true,
  }

  componentDidMount(): void {
    this.fetchBooks()
  }

  public render() {
    const {classes} = this.props
    const {books, loading} = this.state

    return (
      <div className={classes.root}>
        <Typography
          variant="h2"
          align="center"
          color="textPrimary"
          gutterBottom={true}
          className={classes.nameTitle}
        >
          My favorite books
        </Typography>
        <div className={classes.layout}>
          <Grid container={true} spacing={5} justify={'center'}>
            {loading && (
              <Grid item={true} sm={12}>
                <Typography variant="h5">Loading...</Typography>
              </Grid>
            )}
            {books.map((book: Book) => (
              <Grid
                key={book.hash}
                item={true}
                xs={6}
                sm={3}
                md={2}
                lg={2}
                style={{height: 'auto', width: '100%'}}
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

          <Button
            className={classes.moreBooksButton}
            variant="outlined"
            component={(props: any) => <Link {...props} to="/books"/>}
            color="secondary"
          >
            Books
            <LibraryBookIcon className={classes.rightIcon}/>
          </Button>
        </div>
      </div>
    )
  }

  private async fetchBooks() {
    try {
      const books: Book[] = await Api.fetchFeaturedBooks()
      this.setState({books, loading: false})
    } catch (e) {
      console.error(e)
      this.setState({loading: false})
    }
  }
}

export default withStyles(styles)(BestBooks)
