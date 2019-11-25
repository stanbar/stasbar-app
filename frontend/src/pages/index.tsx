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

import {createStyles, Theme, withStyles, WithStyles} from "@material-ui/core";
import * as React from "react";
import {Component} from "react";
import Introduction from "../components/About/Introduction";
import Header from "../components/About/Header";
import AppsGallery from "../components/About/AppsGallery";
import BestBooks from "../components/About/BestBooks";
import BestQuotes from "../components/About/BestQuotes";
import Apps from "../myapps/Apps";
import Projects from "../myapps/Projects";

const styles = (theme: Theme) => createStyles({
  odd: {
    backgroundColor: theme.palette.primary.light
  },
  even: {
    backgroundColor: theme.palette.primary.main
  }
});

class Index extends Component<WithStyles<typeof styles>> {

  public render() {

    const {classes} = this.props;
    return (
      <div>
        <div className={classes.odd}>
          <Header/>
        </div>
        <div className={classes.even}>
          <Introduction/>
        </div>
        <div className={classes.odd}>
          <AppsGallery title={"My Apps"} apps={Apps}/>
        </div>
        <div className={classes.even}>
          <AppsGallery title={"Other Projects"} apps={Projects}/>
        </div>
        <div className={classes.odd}>
          <BestBooks/>
        </div>
        <div className={classes.even}>
          <BestQuotes/>
        </div>
      </div>
    );
  }
}

export default withStyles(styles)(Index)
