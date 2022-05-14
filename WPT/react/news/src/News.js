import React, { useState } from "react";
import NewsHeader from "./news/NewsHeader";
import AddNewsForm from "./form/AddNewsForm.js";
import './App.css'

function News(props) {
  const [briefArticle, setBriefArticle] = useState(props.briefArticles);
  const [topArticle, setTopArticle] = useState(props.topArticles);
  const [formVisibity, setFormVisibity] = useState(false);
  const [id, setId] = useState(10);

  const hideForm = () => setFormVisibity(false);
  const showform = () => setFormVisibity(!formVisibity);

  const addArticle = (article, section) => {
    article.id = id;
    setId(id + 1);
    switch (section) {
      case "brief":
        setBriefArticle(briefArticle.concat([article]));
        break;

      case "top":
        setTopArticle(topArticle.concat([article]));
        break;

      default:
        break;
    }
    console.log(article);
  };

  return (
    <div className="App">
      <header className="news-header-bar">
        <div className="header-logo" onClick={hideForm}>
          NEWS
        </div>
        <div className="btn-open-form" onClick={showform}>
          <button type="button"> + </button>
        </div>
      </header>
      {formVisibity && <AddNewsForm onAddArticle={addArticle} />}
      {!formVisibity && (
        <div>
          <NewsHeader title="NEWS BRIEFS" content={briefArticle} />
          <NewsHeader title="TOP NEWS" content={topArticle} />
        </div>
      )}
    </div>
  );
}

export default News;
