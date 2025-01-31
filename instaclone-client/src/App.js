import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import Navbar from "./Navbar";
import Login from "./Login";
import { validateToken } from "./api";
import Profile from "./Profile";

import "./App.css";

export default function App() {
  const [isLoggedIn, setLoggedIn] = useState(false);

  useEffect(() => {
    if (localStorage.getItem("token")) {
      validateToken(localStorage.getItem("token")).then((response) => {
        if (response.isValid) {
          setLoggedIn(true);
        }
      });
    }
  }, []);

  return (
    <div className="App">
      <Router>
        <Navbar isLoggedIn={isLoggedIn} setLoggedIn={setLoggedIn} />
        <Switch>
          <Route
            exact
            path="/login"
            render={(props) => <Login {...props} setLoggedIn={setLoggedIn} />}
          />
          <Route
            exact
            path="/:username"
            render={(props) => <Profile {...props} />}
          />
        </Switch>
      </Router>
    </div>
  );
}
