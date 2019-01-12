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

import {Button, createStyles, Grid, Theme, Typography, withStyles, WithStyles} from "@material-ui/core";
import * as React from "react";
import {Component} from "react";
import LinkedinIcon from "../../Icons/LinkedinIcon";
import GithubIcon from "../../Icons/GithubIcon";
import KeybaseIcon from "../../Svgs/KeybaseLogo.svg";
import StackOverflowIcon from "../../Svgs/StackOverflowIcon.svg";
import VapeToolIcon from "../../Svgs/VapeToolLogo.svg";
import TaxLedgerIcon from "../../Svgs/TaxLedgerLogo.svg";
import GooglePlayIcon from "../../Svgs/GooglePlayLogo.svg";

const styles = (theme: Theme) => createStyles({

  heroUnit: {
    backgroundColor: theme.palette.background.paper,
  },
  heroContent: {
    maxWidth: 600,
    margin: '0 auto',
    padding: `${theme.spacing.unit * 8}px 0 ${theme.spacing.unit * 6}px`,
  },
  heroButtons: {
    marginTop: theme.spacing.unit * 4,
  },
});

class AboutMe extends Component<WithStyles<typeof styles>> {

  public render() {
    const {classes} = this.props;
    return (
      <div className={classes.heroUnit}>
        <div className={classes.heroContent}>
          <Typography component="h1" variant="h2" align="center" color="textPrimary" gutterBottom={true}>
            Stanislaw Baranski
          </Typography>
          <Typography variant="h6" align="center" color="textSecondary" paragraph={true}>
            Something short and leading about the collection below—its contents, the creator, etc.
            Make it short and sweet, but not too short so folks don&apos;t simply skip over it
            entirely.
          </Typography>
          <div className={classes.heroButtons}>
            <Grid container={true} spacing={16} justify="center">
              <Grid item={true}>
                <Button href={"http://bit.ly/stasbarlinkedin"} variant="contained" color="inherit"
                        style={{color: "#243641", backgroundColor: "#FFF"}}>
                  linkedIn
                  <LinkedinIcon/>
                </Button>
              </Grid>
              <Grid item={true}>
                <Button variant="contained" color="primary" style={{backgroundColor: "#212529"}}>
                  Github
                  <GithubIcon/>
                </Button>
              </Grid>
              <Grid item={true}>
                <Button variant="contained" color="primary" style={{color: "#343536", backgroundColor: "#F9F9FA"}}>
                  StackOverflow
                  <img src={StackOverflowIcon} width={20}/>
                </Button>
              </Grid>
              <Grid item={true}>
                <Button variant="contained" color="primary" style={{color: "#6E6E6E", backgroundColor: "#EFEFEF"}}>
                  Google Play
                  <img src={GooglePlayIcon} width={20}/>
                </Button>
              </Grid>
              <Grid item={true}>
                <Button variant="contained" color="primary" style={{color: "#FFF", backgroundColor: "#3095F4"}}>
                  Keybase
                  <img src={KeybaseIcon} width={20}/>
                </Button>
              </Grid>
              <Grid item={true}>
                <Button variant="contained" color="primary" style={{color: "#243641", backgroundColor: "#FFF"}}>
                  TaxLedger
                  <img src={TaxLedgerIcon} width={20}/>
                </Button>
              </Grid>
              <Grid item={true}>
                <Button variant="contained" color="primary" style={{backgroundColor: "#3546A7"}}>
                  VapeTool
                  <img src={VapeToolIcon} width={20}/>
                </Button>
              </Grid>
            </Grid>
          </div>
        </div>
      </div>
    );
  }
}

export default withStyles(styles)(AboutMe)
