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

import {createStyles, Theme, Typography, withStyles, WithStyles} from "@material-ui/core";
import * as React from "react";
import {Component} from "react";

const styles = (theme: Theme) => createStyles({
  heroUnit: {
    backgroundColor: theme.palette.primary.dark,
  },
  heroContent: {
    maxWidth: 600,
    margin: '0 auto',
    padding: `${theme.spacing.unit * 8}px 0 ${theme.spacing.unit * 6}px`,
  },
});

class Introduction extends Component<WithStyles<typeof styles>> {

  public render() {
    const {classes} = this.props;
    return (
      <div className={classes.heroUnit}>
        <div className={classes.heroContent}>
          <Typography variant="h6" align="center" color="textSecondary" paragraph={true}>
            Motivated by the newest technologies and business opportunities. Currently focusing on blockchain
            technology.
            Key values in my life: Efficiency, Development, Adaptation, Freedom and Simplicity
          </Typography>
        </div>
      </div>
    );
  }
}

export default withStyles(styles)(Introduction)
