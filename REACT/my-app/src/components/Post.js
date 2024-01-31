import React from 'react';
import "./css/post.css";

const Post = (props) => {
    return (
        <div className="Content" onClick = {props.onClick}>
            <p>ID: {props.id}</p>
            <p>Title: {props.title}</p>
            <p>Author: {props.author}</p>
        </div>
    );
}

export default Post;
