import './news.css';
import React from "react";
import NewsContent from './NewsContent';

const NewsHeader = (props) => {

    const articles = props.content;

    return (
        <div className="news">
            <h1 className="news-header"> {props.title} </h1>
            <hr className="news-hr"/>
            <div className="news-container">
                {articles.map(a => <NewsContent
                                    key={a.id}
                                    title={a.title}
                                    body={a.body}
                                    image={a.img} />)}
            </div>
        </div>
    )
}

export default NewsHeader;