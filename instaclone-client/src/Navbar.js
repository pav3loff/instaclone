import React, { useState } from "react";
import { Redirect } from "react-router-dom";

import { Button } from "@material-ui/core";

import instalogo from "./static/instalogo.svg";

import "./Navbar.css";

export default function Navbar() {
  const [loginClicked, setLoginClicked] = useState(false);

  return (
    <div className="Navbar-header">
      <div className="Navbar-logo-div">
        <img className="Navbar-logo" src={instalogo} alt="Navbar-logo" />
      </div>

      <div className="Navbar-actions-div">
        <Button
          className="Navbar-button-signin"
          onClick={() => setLoginClicked(true)}
        >
          Sign in
        </Button>
        <a className="Navbar-link-register" href="/register">
          Register
        </a>
      </div>

      {loginClicked && <Redirect to="/login" />}
    </div>
  );
}
