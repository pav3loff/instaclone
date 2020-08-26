import React, { useState } from "react";

import { Modal, Avatar } from "@material-ui/core";

import "./CompactPost.css";

export default function CompactPost(props) {
  const [modalOpen, setModalOpen] = useState(false);

  return (
    <div className="CompactPost">
      <img
        className="CompactPost-image"
        src={props.media.url}
        alt={props.media.id}
        onClick={() => setModalOpen(true)}
      />
      <Modal open={modalOpen} onClose={() => setModalOpen(false)}>
        <div className="CompactPost-Modal-outside-div">
          <div className="CompactPost-Modal-inside-div">
            <div className="CompactPost-FullPost-image-div">
              <img
                className="CompactPost-FullPost-image"
                src={props.media.url}
                alt={props.media.id}
              />
            </div>
            <div className="CompactPost-FullPost-info">
              <div className="CompactPost-FullPost-info-header">
                <Avatar
                  className="CompactPost-FullPost-info-header-avatar"
                  src={props.profilePicture.url}
                  alt="avatar"
                />
                <p className="CompactPost-FullPost-info-header-username">
                  {props.ownerUsername}
                </p>
              </div>
            </div>
          </div>
        </div>
      </Modal>
    </div>
  );
}
