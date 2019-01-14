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

import {Button, createStyles, Theme, withStyles, WithStyles} from "@material-ui/core";
import * as React from "react";
import {Component} from "react";
import {Link} from "react-router-dom";
import LibraryBookIcon from '@material-ui/icons/LibraryBooks'
import FormatQuoteIcon from '@material-ui/icons/FormatQuote'


const styles = (theme: Theme) => createStyles({
  heroContent: {
    display: 'flex',
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "center",
    maxWidth: 600,
    margin: '0 auto',
    padding: `${theme.spacing.unit * 8}px 0 ${theme.spacing.unit * 6}px`,
  },
  menuButton: {
    marginLeft: -12,
    marginRight: 20,
  },
  rightIcon: {
    marginLeft: theme.spacing.unit,
  },
});

class More extends Component<WithStyles<typeof styles>> {

  public render() {
    const {classes} = this.props;

    return (
      <div className={classes.heroContent}>
        <Button
          className={classes.menuButton}
          variant="outlined"
          component={(props: any) => <Link {...props} to="/books"/>}
          color="secondary">
          Books
          <LibraryBookIcon className={classes.rightIcon}/>

        </Button>
        <Button
          className={classes.menuButton}
          variant="outlined"
          component={(props: any) => <Link {...props} to="/quotes"/>}
          color="secondary">
          Quotes
          <FormatQuoteIcon className={classes.rightIcon}/>
        </Button>
      </div>
    );
  }
}

export default withStyles(styles)(More)
