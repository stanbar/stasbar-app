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

import {Button, createStyles, Grid, Theme, withStyles, WithStyles} from "@material-ui/core";
import * as React from "react";
import {Component} from "react";
import Header from "./Header";
import Introduction from "./Introduction";
import MyApps from "./MyApps";
import MyProjects from "./MyProjects";
import More from "./More";

const styles = (theme: Theme) => createStyles({

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

class AboutMe extends Component<WithStyles<typeof styles>> {

  public render() {
    return (
      <div>
        <Header/>
        <Introduction/>
        <MyApps/>
        <MyProjects/>
        <More/>
      </div>
    );
  }
}

export default withStyles(styles)(AboutMe)
