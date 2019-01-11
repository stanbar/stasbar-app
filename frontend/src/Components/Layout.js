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

import {AppBar, CssBaseline, Toolbar} from '@material-ui/core'
import {withStyles} from '@material-ui/core/styles';
import * as React from 'react'
import {Component, Fragment} from 'react'
import {Link, withRouter} from 'react-router-dom'
import {compose} from 'recompose'
import Button from "@material-ui/core/Button";
import LibraryBookIcon from '@material-ui/icons/LibraryBooks'
import FormatQuoteIcon from '@material-ui/icons/FormatQuote'

const styles = (theme) => ({
    root: {
        flexGrow: 1,
    },
    logoText: {
        flexGrow: 1,
        fontSize: 7
    },
    menuButton: {
        marginLeft: -12,
        marginRight: 20,
    },
    rightIcon: {
        marginLeft: theme.spacing.unit,
    },
});


class Layout extends Component {

    render() {
        const logoString = `
          __             __
    _____/ /_____ ______/ /_  ____ ______
   / ___/ __/ __ \`/ ___/ __ \\/ __ \`/ ___/
  (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
 /____/\\__/\\__,_/____/_.___/\\__,_/_/
            `;
        const {classes, children} = this.props;

        return (
            <Fragment>
                <CssBaseline/>
                <div className={classes.root}>
                    <AppBar position="static">
                        <Toolbar>

                            <pre className={classes.logoText} color="inherit">{logoString}</pre>
                            <Button
                                className={classes.menuButton}
                                variant="outlined"
                                component={Link}
                                to="/books"
                                color="inherit">
                                Books
                                <LibraryBookIcon className={classes.rightIcon}/>

                            </Button>
                            <Button
                                className={classes.menuButton}
                                variant="outlined"
                                component={Link}
                                to="/quotes"
                                color="inherit">
                                Quotes
                                <FormatQuoteIcon className={classes.rightIcon}/>
                            </Button>
                        </Toolbar>
                    </AppBar>

                    <main className={classes.content}>
                        <div className={classes.toolbar}/>
                        {children}
                    </main>
                </div>
            </Fragment>
        )
    }
}

export default compose(withRouter, withStyles(styles))(Layout)