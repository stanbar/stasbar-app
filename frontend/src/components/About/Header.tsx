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
  Button,
  createStyles,
  Grid,
  Theme,
  Typography,
  withStyles,
  WithStyles,
  Container
} from "@material-ui/core";
import * as React from "react";
import { Component } from "react";
import LinkedinIcon from "../../icons/LinkedinIcon";
import GithubIcon from "../../icons/GithubIcon";

const KeybaseIcon = require("../../assets/svg/KeybaseLogo.svg");
const StackOverflowIcon = require("../../assets/svg/StackOverflowIcon.svg");
const VapeToolIcon = require("../../assets/svg/VapeToolLogo.svg");
const TaxLedgerIcon = require("../../assets/svg/TaxLedgerLogo.svg");
const { OutboundLink } = require("gatsby-plugin-google-analytics");

const styles = (theme: Theme) =>
  createStyles({
    nameTitle: {
      fontSize: "2rem",
      fontWeight: 600,
      marginBottom: "1rem",
      color: theme.palette.text.primary
    },
    content: {
      maxWidth: 700,
      margin: "0 auto",
      padding: `${theme.spacing(8)}px 0 ${theme.spacing(6)}px`
    },
    buttons: {
      marginTop: theme.spacing(4)
    },
    intentButton: {
      margin: theme.spacing(1)
    },
    specs: {
      marginTop: theme.spacing(4)
    },
    keyword: {
      color: theme.palette.secondary.main,
      borderBottom: ".1rem solid currentColor",
      textDecoration: "none",
      textOverflow: "ellipsis",
      whiteSpace: "nowrap"
    },
    specGridItem: {
      background: "inherit",
      padding: theme.spacing(1)
    },
    specName: {
      color: theme.palette.secondary.main,
      margin: theme.spacing(1),
      fontSize: "1rem",
      fontWeight: 700,
      textAlign: "center"
    },
    specDesc: {
      align: "justify"
    }
  });

class Header extends Component<WithStyles<typeof styles>> {
  public render() {
    const { classes } = this.props;

    function getMyAge(): number {
      const current = new Date();
      return current.getUTCFullYear() - 1995;
    }

    const LinkImageButton: React.FunctionComponent<{
      name: string;
      Icon: any;
      href: string;
      textColor: string;
      backgroundColor: string;
    }> = props => (
      <Grid item={true} className={classes.intentButton}>
        <OutboundLink
          href={props.href}
          label={props.name}
          target="_blank"
          style={{ textDecoration: "none" }}
        >
          <Button
            variant="contained"
            color="primary"
            style={{
              color: props.textColor,
              backgroundColor: props.backgroundColor
            }}
          >
            {props.Icon}
            {props.name}
          </Button>
        </OutboundLink>
      </Grid>
    );

    return (
      <Container className={classes.content} maxWidth="lg">
        <Typography
          variant="h1"
          align="center"
          gutterBottom={true}
          className={classes.nameTitle}
        >
          STANISLAW BARANSKI
        </Typography>
        <Typography variant="h6" align="center" gutterBottom={true}>
          <u className={classes.keyword}>full stack android developer</u>,
          &nbsp;
          <u className={classes.keyword}>beginner entrepreneur</u>, &nbsp;
          <u className={classes.keyword}>blockchain enthusiast</u>, &nbsp;
          <u className={classes.keyword}>b.eng. computer science</u>, &nbsp;
          <u className={classes.keyword}>{getMyAge()} years old</u>
        </Typography>

        <Grid
          container={true}
          spacing={0}
          justify="center"
          className={classes.buttons}
        >
          <LinkImageButton
            name={"LinkedIn"}
            href={"https://www.linkedin.com/in/stasbar/"}
            Icon={<LinkedinIcon />}
            textColor={"#243641"}
            backgroundColor={"#FFF"}
          />
          <LinkImageButton
            name={"Github"}
            href={"https://github.com/stasbar"}
            Icon={<GithubIcon />}
            textColor={"#FFF"}
            backgroundColor={"#212529"}
          />
          <LinkImageButton
            name={"Keybase"}
            href={"https://keybase.io/stasbar"}
            Icon={<img src={KeybaseIcon} width={20} />}
            textColor={"#FFF"}
            backgroundColor={"#3095F4"}
          />
          <LinkImageButton
            name={"StackOverflow"}
            href={"https://stackoverflow.com/story/stasbar"}
            Icon={<img src={StackOverflowIcon} width={20} />}
            textColor={"#343536"}
            backgroundColor={"#F9F9FA"}
          />
          <LinkImageButton
            name={"TaxLedger"}
            href={"https://tax-ledger.com"}
            Icon={<img src={TaxLedgerIcon} width={20} />}
            textColor={"#243641"}
            backgroundColor={"#FFF"}
          />
          <LinkImageButton
            name={"VapeTool"}
            href={"https://vapetool.app"}
            Icon={<img src={VapeToolIcon} width={20} />}
            textColor={"#FFF"}
            backgroundColor={"#3546A7"}
          />
        </Grid>

        <Grid
          container={true}
          spacing={0}
          justify="center"
          className={classes.specs}
        >
          <Grid
            item={true}
            xs={6}
            sm={6}
            md={3}
            lg={3}
            className={classes.specGridItem}
          >
            <Typography className={classes.specName}>Android</Typography>
            <Typography
              component="p"
              color={"textSecondary"}
              className={classes.specDesc}
            >
              My main specialty is mobile applications for Android in Java and
              Kotlin.
            </Typography>
          </Grid>

          <Grid
            item={true}
            xs={6}
            sm={6}
            md={3}
            lg={3}
            className={classes.specGridItem}
          >
            <Typography className={classes.specName}>Backend</Typography>
            <Typography
              component="p"
              color={"textSecondary"}
              className={classes.specDesc}
            >
              I chose Firebase when I need working product ASAP. Then I chose
              Nodejs with Typescript, Kotlin with ktor if JVM is required,
              golang when performance matters, and Python for scripting.
            </Typography>
          </Grid>

          <Grid
            item={true}
            xs={6}
            sm={6}
            md={3}
            lg={3}
            className={classes.specGridItem}
          >
            <Typography className={classes.specName}>Frontend</Typography>
            <Typography
              component="p"
              color={"textSecondary"}
              className={classes.specDesc}
            >
              My favorite framework is React with TS. Concept of all-in-js
              combined with JSX seduced me.
            </Typography>
          </Grid>

          <Grid
            item={true}
            xs={6}
            sm={6}
            md={3}
            lg={3}
            className={classes.specGridItem}
          >
            <Typography className={classes.specName}>Tools</Typography>
            <Typography
              component="p"
              color={"textSecondary"}
              className={classes.specDesc}
            >
              When it comes to tools, I prefer IntelliJ/AS for JVM based
              languages, and Vim/Tmux otherwise. Running on macOS or Arch Linux.
            </Typography>
          </Grid>
        </Grid>
      </Container>
    );
  }
}

export default withStyles(styles)(Header);
