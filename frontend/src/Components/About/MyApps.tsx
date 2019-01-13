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

import {
  Card,
  CardContent,
  CardHeader,
  CardMedia,
  createStyles,
  Grid,
  Theme,
  Typography,
  withStyles,
  WithStyles
} from "@material-ui/core";
import * as React from "react";
import {Component} from "react";
import Apps from "../../MyApps/Apps"

const styles = (theme: Theme) => createStyles({
  nameTitle: {
    fontFamily: "Roboto ",
    fontWeight: 600,
  },
  myAppCard: {
    height: 'auto',
    display: 'flex',
    flexDirection: 'column',
  },
  myAppCardMedia: {
    paddingTop: '100%', // 16:9
  },
  myAppCardContent: {
    flexGrow: 1,
  },
  myAppImg: {
    height: 0,
    paddingTop: "50%",
  },
  heroUnit: {
    backgroundColor: theme.palette.primary.light,
  },
  layout: {
    width: 'auto',
    marginLeft: theme.spacing.unit * 3,
    marginRight: theme.spacing.unit * 3,
    padding: `${theme.spacing.unit * 8}px 0`,
    [theme.breakpoints.up(1100 + theme.spacing.unit * 3 * 2)]: {
      width: 1100,
      marginLeft: 'auto',
      marginRight: 'auto',
    },
  },
  cardGrid: {
    padding: `${theme.spacing.unit * 8}px 0`,
  },
});

class MyApps extends Component<WithStyles<typeof styles>> {

  public render() {
    const {classes} = this.props;

    const MyApp: React.FunctionComponent<{
      name: string,
      href: string,
      imgsrc: any,
      imgwebp: any,
      description: any
    }> = (props) =>
      <Grid item={true} sm={12} md={6} lg={4}>
        <Card className={classes.myAppCard}>
          <CardHeader
            title={props.name}
          />

          <CardContent className={classes.myAppCardContent}>
            <CardMedia
              className={classes.myAppImg}
              image={props.imgwebp}
            />
            {/*<picture className={classes.myAppImg}>*/}
            {/*<source srcSet={props.imgsrc} type={"image/png"}/>*/}
            {/*<source srcSet={props.imgwebp} type={"image/webp"}/>*/}
            {/*<img src={props.imgsrc} alt={props.name}/>*/}
            {/*</picture>*/}
            <Typography>{props.description}</Typography>
          </CardContent>
        </Card>
      </Grid>;


    return (

      <div>

        <Typography variant="h3" align="center" color="textPrimary" gutterBottom={true} className={classes.nameTitle}>
          My Apps
        </Typography>

        <div className={classes.layout}>
          <Grid container={true} spacing={40}>
            {Apps.map((app) => <MyApp key={app.name} name={app.name} href={app.href}
                                      imgsrc={app.imgSrc} imgwebp={app.imgWebp}
                                      description={app.description}/>
            )}
          </Grid>
        </div>
      </div>
    );
  }
}

export default withStyles(styles)(MyApps)
