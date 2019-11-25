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
  createStyles,
  Grid,
  Theme,
  Typography,
  withStyles,
  WithStyles,
} from '@material-ui/core'
import * as React from 'react'
import {Component} from 'react'
import IApp from '../../myapps/IApp'
import MyApp from './MyApp'

const styles = (theme: Theme) =>
  createStyles({
    root: {
      margin: '0 auto',
      padding: `${theme.spacing(1)}px 0 ${theme.spacing(6)}px`,
    },
    nameTitle: {
      fontWeight: 500,
      fontSize: '2rem',
    },
    layout: {
      width: 'auto',
      marginLeft: theme.spacing(3),
      marginRight: theme.spacing(3),
      padding: `${theme.spacing(8)}px 0`,
      [theme.breakpoints.up(800 + theme.spacing(6))]: {
        width: 800,
        marginLeft: 'auto',
        marginRight: 'auto',
      },
      display: 'flex',
      flexWrap: 'wrap',
      flexGrow: 1,
      flexDirection: 'column',
      justifyContent: 'space-around',
      overflow: 'hidden',
    },
  })

interface IAppsGallery extends WithStyles<typeof styles> {
  title: string
  apps: IApp[]
}

class AppsGallery extends Component<IAppsGallery> {
  public render() {
    const {classes} = this.props
    return (
      <div className={classes.root}>
        <Typography
          variant="h2"
          align="center"
          color="textPrimary"
          gutterBottom={true}
          className={classes.nameTitle}
        >
          {this.props.title}
        </Typography>

        <div className={classes.layout}>
          <Grid
            container={true}
            justify={'center'}
            spacing={5}
            style={{
              alignContent: 'flex-start',
              alignItems: 'stretch',
              flexGrow: 1,
            }}
          >
            {this.props.apps.map(app => (
              <MyApp key={app.name} app={app}/>
            ))}
          </Grid>
        </div>
      </div>
    )
  }
}

export default withStyles(styles)(AppsGallery)
