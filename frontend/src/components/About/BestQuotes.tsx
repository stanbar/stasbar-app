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

import React, {Component} from "react";
import {Button, Card, createStyles, Grid, Theme, Typography, withStyles, WithStyles} from "@material-ui/core";
import {Link} from 'gatsby';
import Api from "../../Api";
import Quote from "../../models/Quote";
import FormatQuoteIcon from '@material-ui/icons/FormatQuote'

const styles = (theme: Theme) => createStyles({
  root: {
    margin: '0 auto',
    padding: `${theme.spacing.unit * 8}px 0 ${theme.spacing.unit * 6}px`,
  },
  layout: {
    width: 'auto',
    marginLeft: theme.spacing.unit * 3,
    marginRight: theme.spacing.unit * 3,
    [theme.breakpoints.up(1100 + theme.spacing.unit * 3 * 2)]: {
      width: 1100,
      marginLeft: 'auto',
      marginRight: 'auto',
    },

    display: "flex",
    flexWrap: "wrap",
    flexGrow: 1,
    flexDirection: "column",
    justifyContent: "space-around",
    overflow: "hidden",
    padding: `${theme.spacing.unit * 8}px 0`,
  },
  cardQuote: {
    backgroundColor: theme.palette.primary.light,
    textDecoration: "none",
    margin: `${theme.spacing.unit}px 0`,
    padding: `${theme.spacing.unit}px`,
  },
  nameTitle: {
    fontWeight: 500,
    fontSize: "2rem"
  },
  moreQuotesButton: {
    width: "auto",
    alignSelf: "center",
    marginTop: 50,
    marginLeft: -12,
    marginRight: 20,
  },
  rightIcon: {
    marginLeft: theme.spacing.unit,
  },
});

interface IBestQuotesState {
  quotes: Quote[];
  loading: boolean;
}

class BestQuotes extends Component<WithStyles<typeof styles>, IBestQuotesState> {

  public state: IBestQuotesState = {
    quotes: new Array<Quote>(),
    loading: true
  };

  componentDidMount(): void {
    this.fetchQuotes();
  }

  public render() {
    const {classes} = this.props;
    const {quotes, loading} = this.state;

    return (
      <div className={classes.root}>
        <Typography variant="h2" align="center" color="textPrimary" gutterBottom={true} className={classes.nameTitle}>
          My favorite quotes
        </Typography>
        <div className={classes.layout}>

          {loading && <Grid item={true} sm={12}>
              <Typography variant="h5">Loading...</Typography>
          </Grid>
          }
          {quotes.map((quote: Quote) =>
            <Card
              key={quote.hash}
              className={classes.cardQuote}
            >
              <Typography variant="body1">
                <i>{quote.text}</i> ~{quote.author}
              </Typography>
            </Card>
          )}
          <Button
            className={classes.moreQuotesButton}
            variant="outlined"
            component={(props: any) => <Link {...props} to="/quotes"/>}
            color="secondary">
            Quotes
            <FormatQuoteIcon className={classes.rightIcon}/>
          </Button>
        </div>
      </div>
    );
  }

  private async fetchQuotes() {
    try {
      const quotes: Quote[] = await Api.fetchFeaturedQuotes();
      this.setState({quotes, loading: false});
    } catch (e) {
      console.error(e);
      this.setState({loading: false});
    }
  }
}

export default withStyles(styles)(BestQuotes)

