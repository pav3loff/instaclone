import React from "react";

import "./NonExistingPage.css";

export default function NonExistingPage() {
  return (
    <div className="NonExistingPage">
      <h2>Sorry, this page isn't available.</h2>
      <p className="NonExistingPage-paragraph">
        The link you followed may be broken, or the page may have been removed.{" "}
        <a className="NonExistingPage-link" href="/">
          Go back to Instaclone.
        </a>
      </p>
    </div>
  );
}
