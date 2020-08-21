import React from "react";

import "./Profile.css";
import { Button } from "@material-ui/core";

export default function Profile(props) {
  return (
    <div className="Profile">
      <div className="Profile-header">
        <img
          className="Profile-avatar"
          src="https://earthsky.org/upl/2018/12/comet-wirtanen-Jack-Fusco-dec-2018-Anza-Borrego-desert-CA-e1544613895713.jpg"
          alt="Profile-avatar"
        />
        <div className="Profile-info">
          <div className="Profile-info-first-row">
            <p className="Profile-info-username">paveloff</p>
            <Button className="Profile-info-button">Message</Button>
            <Button className="Profile-info-button">Add friend</Button>
          </div>
          <div className="Profile-info-other-row">
            <p className="Profile-info-text">
              Posts: <strong>100</strong>
            </p>
            <p className="Profile-info-text">
              Followers: <strong>200</strong>
            </p>
            <p className="Profile-info-text">
              Following: <strong>50</strong>
            </p>
          </div>
          <div className="Profile-info-other-row">
            <p className="Profile-info-text">
              <strong>Mario Pavlic</strong>
            </p>
          </div>
          <div className="Profile-info-last-row">
            <p className="Profile-info-text">Full stack developer</p>
          </div>
        </div>
      </div>
      <hr />
    </div>
  );
}
