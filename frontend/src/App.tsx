import {createMuiTheme, MuiThemeProvider} from "@material-ui/core";
import React from "react";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import "./App.css";
import Books from "./Components/Books/Books";
import Layout from "./Components/Layout/Layout";
import AboutMe from "./Components/About/AboutMe";
import ReactGA from 'react-ga';

const theme = createMuiTheme({
  palette: {
    type: "dark",
    primary: {main: '#343B3A', light: "#343838", dark: "#2E3231"},
    secondary: {main: '#04C78E'},
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
    <h2>Whoops</h2>
    <p>Sorry but {location.pathname} didn’t match any pages</p>
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
          <Route component={NoMatch}/>
        </Switch>
      </Layout>
    </MuiThemeProvider>
  </BrowserRouter>
);

const About = () => <h2>About</h2>;

export default App;
