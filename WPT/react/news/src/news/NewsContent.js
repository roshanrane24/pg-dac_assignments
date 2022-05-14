import React from "react";
import "./news.css";

const NewsContent = (props) => {
  return (
    <div className="news-content">
      <div className="news-content-image-container">
        <img src={props.image} className="news-content-image" alt="" />
      </div>
      <div className="news-content-container">
        <h3 className="news-content-title"> {props.title} </h3>
        <p className="news-content-body"> {props.body} </p>
      </div>
    </div>
  );
};

export default NewsContent;
