import React, { useEffect, useState } from "react";

import { Button } from "@material-ui/core";
import { getUserInfo } from "./api";

import "./Profile.css";

export default function Profile() {
  const [userInfo, setUserInfo] = useState({
    username: "",
    posts: [],
    displayName: "",
    description: "",
    numOfPosts: 0,
    numOfFollowers: 0,
    numOfFollowing: 0,
    profilePicture: {
      id: null,
      url: "",
    },
  });

  useEffect(() => {
    getUserInfo("paveloff", localStorage.getItem("token")).then((response) => {
      if (response.isSucessful) {
        setUserInfo(response.userInfo);
      }
    });
  }, []);

  return (
    <div className="Profile">
      <div className="Profile-header">
        <img
          className="Profile-avatar"
          src={userInfo.profilePicture.url}
          alt="Profile-avatar"
        />
        <div className="Profile-info">
          <div className="Profile-info-first-row">
            <p className="Profile-info-username">{userInfo.username}</p>
            <Button className="Profile-info-button">Message</Button>
            <Button className="Profile-info-button">Add friend</Button>
          </div>
          <div className="Profile-info-other-row">
            <p className="Profile-info-text">
              Posts: <strong>{userInfo.numOfPosts}</strong>
            </p>
            <p className="Profile-info-text">
              Followers: <strong>{userInfo.numOfFollowers}</strong>
            </p>
            <p className="Profile-info-text">
              Following: <strong>{userInfo.numOfFollowing}</strong>
            </p>
          </div>
          <div className="Profile-info-other-row">
            <p className="Profile-info-text">
              <strong>{userInfo.displayName}</strong>
            </p>
          </div>
          <div className="Profile-info-last-row">
            <p className="Profile-info-text">{userInfo.description}</p>
          </div>
        </div>
      </div>
      <hr />
    </div>
  );
}
