import {createMuiTheme, MuiThemeProvider, Typography} from "@material-ui/core";
import React from "react";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import "./App.css";
import Books from "./Components/Books/Books";
import Layout from "./Components/Layout/Layout";
import AboutMe from "./Components/About/AboutMe";
import ReactGA from 'react-ga';
import Quotes from "./Components/Quotes/Quotes";

const theme = createMuiTheme({
  palette: {
    type: "light",
    primary: {main: '#f7f7f7', light: "#ffffff", dark: "#c4c4c4"},
    secondary: {main: '#3dacd1', light: "#CEEBF6", dark: "#3dacd1"},
    text: { primary: "#5b6a72" },
    // type: "dark",
    // primary: {main: '#343B3A', light: "#343838", dark: "#2E3231"},
    // secondary: {main: '#04C78E'},
  },
  typography: {
    useNextVariants: true,
  },
});

const logPageView = () => {
  ReactGA.set({page: window.location.pathname});
  ReactGA.pageview(window.location.pathname);
  return null;
};

const NoMatch = () => (
  <div>
    <Typography variant={"h2"}>Whoops</Typography>
    <Typography variant={"body1"}>Sorry but {window.location.pathname} didn’t match any pages</Typography>
  </div>
);

const App = () => (
  <BrowserRouter>
    <MuiThemeProvider theme={theme}>
      <Layout>
        <Route path="/" component={logPageView}/>
        <Switch>
          <Route exact={true} path="/" component={AboutMe}/>
          <Route path="/about" component={About}/>
          <Route path="/books" component={Books}/>
          <Route path="/quotes" component={Quotes}/>
          <Route component={NoMatch}/>
        </Switch>
      </Layout>
    </MuiThemeProvider>
  </BrowserRouter>
);

const About = () => <h2>About</h2>;

export default App;
