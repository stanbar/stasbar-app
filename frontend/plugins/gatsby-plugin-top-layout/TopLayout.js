import React from "react";
import { Helmet } from "react-helmet";
import CssBaseline from "@material-ui/core/CssBaseline";
import { MuiThemeProvider, withStyles } from "@material-ui/core/styles";
import theme from "../../src/theme";
import Footer from "../../src/components/Layout/Footer";
import { AppBar, Toolbar } from "@material-ui/core";
import { Link } from "gatsby";
import logoPng from "../../src/assets/png/logo.png";

const styles = theme => ({
  logoImg: {
    [theme.breakpoints.down(500 + theme.spacing.unit * 3 * 2)]: {
      marginRight: 20,
      marginLeft: -12
    },

    maxHeight: 50
  },
  menuButton: {
    marginRight: 0,
    marginLeft: 0,
    color: theme.palette.secondary.dark,
    [theme.breakpoints.up(500 + theme.spacing.unit * 3 * 2)]: {
      marginRight: 20,
      marginLeft: -12
    }
  },
  rightIcon: {
    marginLeft: theme.spacing.unit
  },
  appBar: {
    position: "relative"
  },
  main: {
    flexGrow: 1,
    paddingBottom: "4rem"
  },
  mainPaper: {
    flexGrow: 1,
    alignSelf: "center",
    ...theme.mixins.gutters(),
    maxWidth: 1200,
    paddingTop: theme.spacing.unit * 2,
    paddingBottom: theme.spacing.unit * 2
  },
  pageContent: {
    position: "relative",
    minHeight: "100vh"
  }
});

function TopLayout(props) {
  const { classes, children } = props;
  const appBar = (
    <AppBar position="static" className={classes.appBar}>
      <Toolbar>
        <div style={{ flexGrow: 1 }}>
          <Link to={"/"}>
            <img className={classes.logoImg} src={logoPng} />
          </Link>
        </div>
      </Toolbar>
    </AppBar>
  );

  return (
    <React.Fragment>
      <Helmet>
        <meta
          name="viewport"
          content="minimum-scale=1, initial-scale=1, width=device-width, shrink-to-fit=no"
        />
        <link
          href="https://fonts.googleapis.com/css?family=Roboto:400,500,700&display=swap"
          rel="stylesheet"
        />
      </Helmet>
      <MuiThemeProvider theme={theme}>
        <CssBaseline />
        <div className={classes.pageContent}>
          {appBar}
          <main className={classes.main}>{children}</main>
          <Footer />
        </div>
      </MuiThemeProvider>
    </React.Fragment>
  );
}

export default withStyles(styles)(TopLayout);
