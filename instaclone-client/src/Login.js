import React, { useState } from "react";
import { Redirect } from "react-router-dom";

import { Button } from "@material-ui/core";

import instalogo from "./static/instalogo.svg";
import facebooklogo from "./static/facebooklogo.svg";
import { login } from "./api";

import "./Login.css";

export default function Login(props) {
  const [formData, setFormData] = useState({ username: "", password: "" });
  const [loggedInSuccessfully, setLoggedInSuccessfully] = useState(false);

  function handleChange(id, value) {
    setFormData({ ...formData, [id]: value });
  }

  function handleSubmit(event) {
    event.preventDefault();
    login(formData.username, formData.password).then((response) => {
      if (response.isSuccessful) {
        props.setLoggedIn(true);
        localStorage.setItem("token", response.token.jwt);
        localStorage.setItem("loggedUserUsername", formData.username);
        setLoggedInSuccessfully(true);
      }
    });
  }

  return loggedInSuccessfully ? (
    <Redirect to="/" />
  ) : (
    <div className="Login">
      <div className="Login-box">
        <img className="Login-logo" src={instalogo} alt="Login-logo" />
        <form className="Login-form" onSubmit={(event) => handleSubmit(event)}>
          <input
            className="Login-input"
            type="text"
            id="username"
            value={formData.username}
            placeholder="Username or email"
            onChange={(event) =>
              handleChange(event.target.id, event.target.value)
            }
          />
          <input
            className="Login-input"
            type="password"
            id="password"
            value={formData.password}
            placeholder="Password"
            onChange={(event) =>
              handleChange(event.target.id, event.target.value)
            }
          />
          <Button className="Login-button-application" type="submit">
            Application
          </Button>
        </form>
        <div className="Login-break">
          <p className="Login-or">OR</p>
          <a className="Login-link-withfacebook" href="/login">
            <img
              className="Login-link-withfacebook-icon"
              src={facebooklogo}
              alt="Login-link-withfacebook-icon"
            />
            <p className="Login-link-withfacebook-text">Log in via facebook</p>
          </a>
          <a className="Login-link-forgotpassword" href="/login">
            Forgot your password?
          </a>
        </div>
      </div>
      <div className="Login-register-box">
        <p className="Login-register-text">Dont' have an account?</p>
        <a className="Login-register-link" href="/register">
          Register
        </a>
      </div>
    </div>
  );
}
