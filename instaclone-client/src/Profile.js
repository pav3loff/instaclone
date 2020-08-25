import React, { useEffect, useState } from "react";

import { Button } from "@material-ui/core";

import CompactPost from "./CompactPost";
import NonExistingPage from "./NonExistingPage";
import { getUserInfo, getUserCompactPosts, getLoggedUserUsername } from "./api";

import "./Profile.css";

export default function Profile(props) {
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
  const [userDoesNotExist, setUserDoesNotExist] = useState(false);
  const [compactPosts, setCompactPosts] = useState([]);
  const [isOwner, setOwner] = useState(false);

  useEffect(() => {
    var username = props.location.pathname.substr(1); // pathname = /username
    getUserInfo(username, localStorage.getItem("token")).then((response) => {
      if (response.isSucessful) {
        setUserInfo(response.userInfo);
      } else {
        setUserDoesNotExist(true);
      }
    });
  }, [props.location.pathname]);

  useEffect(() => {
    var username = props.location.pathname.substr(1);
    getUserCompactPosts(username, localStorage.getItem("token")).then(
      (response) => {
        if (response.isSucessful) {
          setCompactPosts(response.compactPosts);
        }
      }
    );
  }, [props.location.pathname]);

  useEffect(() => {
    if (userInfo.username !== "") {
      getLoggedUserUsername(localStorage.getItem("token")).then((response) => {
        if (response.username === userInfo.username) {
          setOwner(true);
        }
      });
    }
    // compare result username with profile username
  }, [userInfo]);

  return userDoesNotExist ? (
    <NonExistingPage />
  ) : (
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
            {isOwner ? (
              <Button className="Profile-info-button">Update profile</Button>
            ) : (
              <div className="Profile-info-first-row">
                <Button className="Profile-info-button">Message</Button>
                <Button className="Profile-info-button">Add friend</Button>
              </div>
            )}
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
      <div className="Profile-posts">
        <div className="Profile-posts-grid">
          {compactPosts.map((compactPost) => (
            <CompactPost key={compactPost.id} {...compactPost} />
          ))}
        </div>
      </div>
      <div className="Profile-footer"></div>
    </div>
  );
}
