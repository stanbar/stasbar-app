import React from "react";
import ReactDOM from "react-dom";
import ReactGA from 'react-ga';
import App from "./App";
import "./index.css"
import 'typeface-roboto-mono';
import * as serviceWorker from "./serviceWorker";

ReactGA.initialize('UA-123888398-1');

ReactDOM.render(<App/>, document.getElementById("root"));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
