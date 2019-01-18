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


import * as React from "react";
import {Component} from "react";
import IApp from "../../MyApps/IApp";
import {createStyles, Grid, Theme, Typography, withStyles, WithStyles} from "@material-ui/core";

const styles = (theme: Theme) => createStyles({
  root: {
    display: "flex",
    alignSelf: "flex-start",
    flexDirection: "column",
    justifyItems: "center",
    alignItems: "center",
    textDecoration: "none"
  },
  name: {
    marginBottom: theme.spacing.unit,
    fontSize: "1rem",
    fontWeight: 700
  },
  img: {
    height: "auto",
    width: "100%"
  },
  description: {
    textDecoration: "none",
    color: theme.palette.text.secondary,
    fontSize: "1rem"
  },

  link: {
    textDecoration: "none",
    borderBottom: ".1rem solid currentColor",
    paddingBottom: "0.05rem",
    color: theme.palette.text.primary,
    '&:hover': {
      color: theme.palette.secondary.main,
    }
  }
});

interface IAppsGallery extends WithStyles<typeof styles> {
  app: IApp
}

class MyApp extends Component<IAppsGallery> {
  public render() {
    const {app, classes} = this.props;

    const Link: React.FunctionComponent<{ href: string, text: string }> = (props) =>
      <a className={classes.link} href={props.href}>{props.text}</a>;

    return (
      <Grid item={true}
            sm={app.platform === "mobile" ? 3 : 6}
            md={app.platform === "mobile" ? 3 : 6}
            lg={app.platform === "mobile" ? 3 : 6}
            className={classes.root}
      >
        <Typography variant={"h4"} color={"secondary"} className={classes.name}>{app.name}</Typography>

        <picture>
          <source srcSet={app.imgSrc} type={"image/png"} className={classes.img}/>
          <source srcSet={app.imgWebp} type={"image/webp"} className={classes.img}/>
          <img src={app.imgSrc} alt={app.name} className={classes.img}/>
        </picture>


        <Typography className={classes.description}>{app.description}
          {app.links.googlePlay && app.links.appStore && ". Both on "}
          {app.links.googlePlay && app.links.appStore && <Link href={app.links.googlePlay} text="Android"/>}
          {app.links.googlePlay && app.links.appStore && " and "}
          {app.links.googlePlay && app.links.appStore && <Link href={app.links.appStore} text="iOS"/>}

          {app.links.googlePlay && !app.links.appStore && ". Check out on "}
          {app.links.googlePlay && !app.links.appStore && <Link href={app.links.googlePlay} text="Google Play"/>}

          {app.links.github && ". Check it out on "}
          {app.links.github && <Link href={app.links.github} text="Github"/>}

          {app.links.website && ". See "}
          {app.links.website && <Link href={app.links.website} text="website"/>}
        </Typography>

      </Grid>
    );
  }
}

export default withStyles(styles)(MyApp)




