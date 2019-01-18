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

import {AppBar, CssBaseline, Toolbar} from '@material-ui/core'
import {withStyles} from '@material-ui/core/styles';
import * as React from 'react'
import {Component, Fragment} from 'react'
import {Link, withRouter} from 'react-router-dom'
import {compose} from 'recompose'
import Button from "@material-ui/core/Button";
import LibraryBookIcon from '@material-ui/icons/LibraryBooks'
import FormatQuoteIcon from '@material-ui/icons/FormatQuote'
import Footer from "./Footer";
import "../../index.css"
import Typography from "@material-ui/core/Typography";

const styles = (theme) => ({
  appBar: {
    position: 'relative',
  },
  main: {
    flexGrow: 1,
  },
  logoText: {
    [theme.breakpoints.down(500 + theme.spacing.unit * 3 * 2)]: {
      marginRight: 20,
      marginLeft: -12,
    },
    textDecoration: "none",
    fontFamily: 'B612Mono, monospace',
    whiteSpace: 'pre',
    fontStyle: 'bold',
    flexGrow: 1,
    fontSize: 5
  },
  menuButton: {
    marginRight: 0,
    marginLeft: 0,
    [theme.breakpoints.up(500 + theme.spacing.unit * 3 * 2)]: {
      marginRight: 20,
      marginLeft: -12,
    }
  },
  rightIcon: {
    marginLeft: theme.spacing.unit,
  },
  content: {
    display: "flex",
    flexGrow: 1,
    padding: theme.spacing.unit * 3,

  },
  mainPaper: {
    flexGrow: 1,
    alignSelf: 'center',
    ...theme.mixins.gutters(),
    maxWidth: 1200,
    paddingTop: theme.spacing.unit * 2,
    paddingBottom: theme.spacing.unit * 2,
  },


});


class Layout extends Component {

  render() {
    const logoString = `
          __             __
    _____/ /_____ ______/ /_  ____ ______
   / ___/ __/ __ \`/ ___/ __ \\/ __ \`/ ___/
  (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
 /____/\\__/\\__,_/____/_.___/\\__,_/_/
            `;
    const {classes, children} = this.props;

    const appBar = <AppBar position="static" className={classes.appBar}>
      <Toolbar>
        <Typography
          component={Link}
          to={"/"}
          className={classes.logoText} color="secondary">{logoString}</Typography>
        <Button
          className={classes.menuButton}
          variant="outlined"
          component={Link}
          to="/books"
          color="secondary">
          Books
          <LibraryBookIcon className={classes.rightIcon}/>

        </Button>
        <Button
          className={classes.menuButton}
          variant="outlined"
          component={Link}
          to="/quotes"
          color="secondary">
          Quotes
          <FormatQuoteIcon className={classes.rightIcon}/>
        </Button>
      </Toolbar>
    </AppBar>;

    return (
      <Fragment>
        <CssBaseline/>
        {appBar}

        <main className={classes.main}>
          {children}
        </main>

        <Footer/>
      </Fragment>
    )
  }
}

export default compose(withRouter, withStyles(styles))(Layout)
