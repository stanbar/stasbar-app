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

import React from "react";
import {
  createStyles,
  Theme,
  Typography,
  withStyles
} from "@material-ui/core";
import publications, { Publication } from "../../myapps/Publications";

const styles = (theme: Theme) =>
  createStyles({
    root: {
      margin: "0 auto",
      padding: theme.spacing(6, 2)
    },
    layout: {
      width: "auto",
      fontSize: "20px",
      lineHeight: "30px",
      marginLeft: theme.spacing(3),
      marginRight: theme.spacing(3),
      [theme.breakpoints.up(1100 + theme.spacing(6))]: {
        width: 1100,
        marginLeft: "auto",
        marginRight: "auto"
      },

      display: "flex",
      flexWrap: "wrap",
      flexGrow: 1,
      flexDirection: "column",
      justifyContent: "space-around",
      overflow: "hidden",
      padding: `${theme.spacing(8)}px 0`
    },
    dt: {
      marginTop: "2em",
      fontSize: "1.2em"
    },
    cardQuote: {
      backgroundColor: theme.palette.primary.light,
      textDecoration: "none",
      margin: `${theme.spacing(1)}px 0`,
      padding: `${theme.spacing(1)}px`
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
      marginRight: 20
    },
    rightIcon: {
      marginLeft: theme.spacing(1)
    }
  });

const Publications: React.FC = ({ classes }: { classes: any }) => {
  return (
    <div className={classes.root}>
      <Typography
        variant="h2"
        align="center"
        color="textPrimary"
        gutterBottom={true}
        className={classes.nameTitle}
      >
        Publications
      </Typography>
      <div className={classes.layout}>
        <dl>
          {publications.map((pub: Publication) => (
            <>
              <a style={{textDecoration: "none", color: "#3dacd1"}} href={pub.link}>
                <dt className={classes.dt}>{pub.title}</dt>
              </a>
              <dd>
                {pub.what}, {pub.when}, {pub.where}
              </dd>
            </>
          ))}
        </dl>
      </div>
    </div>
  );
};

export default withStyles(styles)(Publications);
