import "./form.css";
import React, { useState } from "react";

const AddNewsForm = (props) => {
  const [contentTitle, setContentTitle] = useState("");
  const [contentImg, setContentImg] = useState("");
  const [contentBody, setContentBody] = useState("");

  const contentTitleHandler = (e) => {
    setContentTitle(e.target.value);
  };
  const contentBodyHandler = (e) => {
    setContentBody(e.target.value);
  };
  const contentImgHandler = (e) => {
    setContentImg(e.target.value);
    console.log("Hello " + contentTitle);
  };

  const submitHandler = (event) => {
    event.preventDefault();
    const article = {
      title: contentTitle,
      body: contentBody,
      img: contentImg,
    };

    console.log(article);

    props.onAddArticle(article);
  };

  return (
    <div className="form-container">
      <form onSubmit={submitHandler}>
        <div className="x-input">
          <p className="x-input-label"> Title </p>
          <input
            value={contentTitle}
            className="title-input-field"
            name="title"
            onChange={contentTitleHandler}
          />
        </div>

        <div className="x-input">
          <p className="x-input-label"> Image URL </p>
          <input
            value={contentImg}
            type="url"
            className="body-input-field"
            name="image"
            onChange={contentImgHandler}
          />
        </div>

        <div className="x-input">
          <p className="x-input-label"> Content </p>
          <textarea
            value={contentBody}
            className="body-input-field"
            rows="8"
            cols="70"
            name="body"
            onChange={contentBodyHandler}
          />
        </div>

        <div className="x-input-button">
          <button type="submit" className="btn-submit">
            {" "}
            Add{" "}
          </button>
        </div>
      </form>
    </div>
  );
};

export default AddNewsForm;
