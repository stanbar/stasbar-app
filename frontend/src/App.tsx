import {createMuiTheme, MuiThemeProvider} from "@material-ui/core";
import {blue, blueGrey} from "@material-ui/core/colors";
import React from "react";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import "./App.css";
import Books from "./Components/Books/Books";
import Layout from "./Components/Layout";

const theme = createMuiTheme({
  palette: {
    primary: blue,
    secondary: blueGrey,
  },
  typography: {
    useNextVariants: true,
  },
});

const App = () => (
  <Router>
    <MuiThemeProvider theme={theme}>
      <Layout>
        <Switch>
          <Route exact={true} path="/" component={Home}/>
          <Route path="/about" component={About}/>
          <Route path="/books" component={Books}/>
        </Switch>
      </Layout>
    </MuiThemeProvider>
  </Router>
);
const Home = () => <h2>Home</h2>;
const About = () => <h2>About</h2>;

export default App;
