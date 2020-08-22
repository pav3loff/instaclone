import React, { useState } from "react";
import { Redirect } from "react-router-dom";

import { Button, IconButton, MenuItem, Menu } from "@material-ui/core";
import { withStyles } from "@material-ui/core/styles";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faPaperPlane,
  faCompass,
  faHeart,
  faUser,
  faUserCircle,
  faCog,
} from "@fortawesome/free-solid-svg-icons";

import instalogo from "./static/instalogo.svg";
import instaicon from "./static/instaicon.svg";

import "./Navbar.css";

const StyledMenu = withStyles({
  paper: {
    border: "1px solid #d3d4d5",
    width: 220,
  },
})((props) => (
  <Menu
    getContentAnchorEl={null}
    anchorOrigin={{
      vertical: "bottom",
      horizontal: "center",
    }}
    {...props}
  />
));

export default function Navbar(props) {
  const [lastAction, setLastAction] = useState("");
  const [anchorEl, setAnchorEl] = React.useState(null);

  function handleProfileClick(event) {
    setAnchorEl(event.currentTarget);
  }

  function handleClose() {
    setAnchorEl(null);
  }

  return (
    <div className="Navbar-header">
      <div className="Navbar-logo-div">
        {props.isLoggedIn && (
          <img
            className="Navbar-insta-icon"
            src={instaicon}
            alt="Navbar-insta-icon"
          />
        )}
        {props.isLoggedIn && <hr className="Navbar-divider" />}
        <img
          className="Navbar-insta-logo"
          src={instalogo}
          alt="Navbar-insta-logo"
        />
      </div>

      {props.isLoggedIn ? (
        <div className="Navbar-actions-div">
          <IconButton className="Navbar-iconbutton">
            <FontAwesomeIcon icon={faPaperPlane}></FontAwesomeIcon>
          </IconButton>
          <IconButton className="Navbar-iconbutton">
            <FontAwesomeIcon icon={faCompass}></FontAwesomeIcon>
          </IconButton>
          <IconButton className="Navbar-iconbutton">
            <FontAwesomeIcon icon={faHeart}></FontAwesomeIcon>
          </IconButton>
          <IconButton
            className="Navbar-iconbutton"
            onClick={handleProfileClick}
          >
            <FontAwesomeIcon icon={faUser}></FontAwesomeIcon>
          </IconButton>
          <StyledMenu
            anchorEl={anchorEl}
            keepMounted
            open={Boolean(anchorEl)}
            onClose={handleClose}
          >
            <MenuItem
              className="Navbar-menu-item"
              onClick={() => {
                setLastAction("profile");
                handleClose();
              }}
            >
              <FontAwesomeIcon
                className="Navbar-menu-fa-icon"
                icon={faUserCircle}
              ></FontAwesomeIcon>
              <p className="Navbar-menu-item-text">Profile</p>
            </MenuItem>
            <MenuItem className="Navbar-menu-item">
              <FontAwesomeIcon
                className="Navbar-menu-fa-icon"
                icon={faCog}
              ></FontAwesomeIcon>
              <p className="Navbar-menu-item-text">Settings</p>
            </MenuItem>
            <hr></hr>
            <MenuItem
              className="Navbar-menu-item"
              onClick={() => {
                localStorage.removeItem("token");
                props.setLoggedIn(false);
                setLastAction("logout");
              }}
            >
              <p className="Navbar-menu-item-text">Sign out</p>
            </MenuItem>
          </StyledMenu>
        </div>
      ) : (
        <div className="Navbar-actions-div">
          <Button
            className="Navbar-button-signin"
            onClick={() => setLastAction("login")}
          >
            Sign in
          </Button>
          <a className="Navbar-link-register" href="/register">
            Register
          </a>
        </div>
      )}

      {lastAction === "login" && <Redirect to="/login" />}
      {lastAction === "profile" && (
        <Redirect to={"/" + localStorage.getItem("loggedUserUsername")} />
      )}
      {lastAction === "logout" && <Redirect to="/" />}
    </div>
  );
}
