import React from "react";

import "./CompactPost.css";

export default function CompactPost(props) {
  return (
    <div className="CompactPost" onClick={() => console.log(props.id)}>
      <img
        className="CompactPost-image"
        src={props.media.url}
        alt={props.media.id}
      />
    </div>
  );
}
