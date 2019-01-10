import React from 'react';
import './App.css';
import {BrowserRouter as Router, Link, Route} from "react-router-dom";
import Books from "./Components/Books";

const App = () => (
    <Router>
        <div>
            <Header/>

            <Route exact path="/" component={Home}/>
            <Route path="/about" component={About}/>
            <Route path="/books" component={Books}/>
        </div>
    </Router>
);

const Home = () => <h2>Home</h2>;
const About = () => <h2>About</h2>;

const Header = () => (
    <ul>
        <li>
            <Link to="/">Home</Link>
        </li>
        <li>
            <Link to="/about">About</Link>
        </li>
        <li>
            <Link to="/books">Books</Link>
        </li>
    </ul>
);

export default App;

