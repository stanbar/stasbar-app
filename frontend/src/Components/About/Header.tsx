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
import LinkedinIcon from "../../icons/LinkedinIcon";
import GithubIcon from "../../icons/GithubIcon";
import KeybaseIcon from "../../assets/svg/KeybaseLogo.svg";
import StackOverflowIcon from "../../assets/svg/StackOverflowIcon.svg";
import VapeToolIcon from "../../assets/svg/VapeToolLogo.svg";
import TaxLedgerIcon from "../../assets/svg/TaxLedgerLogo.svg";

const styles = (theme: Theme) => createStyles({
  nameTitle: {
    fontFamily: "Roboto ",
    fontWeight: 600,

  },
  heroUnit: {
    backgroundColor: theme.palette.primary.light,
  },
  heroContent: {
    maxWidth: 600,
    margin: '0 auto',
    padding: `${theme.spacing.unit * 8}px 0 ${theme.spacing.unit * 6}px`,
  },
  heroButtons: {
    marginTop: theme.spacing.unit * 4,
  },
  keyword: {
    borderBottom: ".1rem solid currentColor",
    textDecoration: "none"
  }
});

const IntentButton: React.FunctionComponent<{
  name: string,
  Icon: any,
  href: string,
  textColor: string,
  backgroundColor: string
}> = (props) =>
  <Grid item={true}>
    <Button href={props.href}
            variant="contained" color="primary"
            style={{color: props.textColor, backgroundColor: props.backgroundColor}}>
      {props.name}
      {props.Icon}
    </Button>
  </Grid>;

class Header extends Component<WithStyles<typeof styles>> {

  public render() {
    const {classes} = this.props;
    return (
      <div className={classes.heroUnit}>
        <div className={classes.heroContent}>
          <Typography variant="h3" align="center" color="textPrimary" gutterBottom={true} className={classes.nameTitle}>
            STANISLAW BARANSKI
          </Typography>
          <Typography variant="h5" align="center" color="textPrimary" gutterBottom={true}>
            <u className={classes.keyword}>full stack software developer</u>, <u className={classes.keyword}>beginner
            entrepreneur</u>, <u className={classes.keyword}>{new Date().getUTCFullYear() - 1995} years old</u>
          </Typography>
          <div className={classes.heroButtons}>
            <Grid container={true} spacing={16} justify="center">
              <IntentButton name={"LinkedIn"}
                            href={"https://www.linkedin.com/in/stasbar/"}
                            Icon={<LinkedinIcon/>}
                            textColor={"#243641"}
                            backgroundColor={"#FFF"}/>
              <IntentButton name={"Github"}
                            href={"https://www.linkedin.com/in/stasbar/"}
                            Icon={<GithubIcon/>}
                            textColor={"#FFF"}
                            backgroundColor={"#212529"}/>
              <IntentButton name={"StackOverflow"}
                            href={"https://www.linkedin.com/in/stasbar/"}
                            Icon={<img src={StackOverflowIcon} width={20}/>}
                            textColor={"#343536"}
                            backgroundColor={"#F9F9FA"}/>
              <IntentButton name={"Keybase"}
                            href={"https://www.linkedin.com/in/stasbar/"}
                            Icon={<img src={KeybaseIcon} width={20}/>}
                            textColor={"#FFF"}
                            backgroundColor={"#3095F4"}/>
              <IntentButton name={"TaxLedger"}
                            href={"https://www.linkedin.com/in/stasbar/"}
                            Icon={<img src={TaxLedgerIcon} width={20}/>}
                            textColor={"#243641"}
                            backgroundColor={"#FFF"}/>
              <IntentButton name={"VapeTool"}
                            href={"https://www.linkedin.com/in/stasbar/"}
                            Icon={<img src={VapeToolIcon} width={20}/>}
                            textColor={"#FFF"}
                            backgroundColor={"#3546A7"}/>
            </Grid>
          </div>
        </div>
      </div>
    );
  }
}

export default withStyles(styles)(Header)
