import { useState } from "react"
import "./css/PostDetails.css"


const PostDetails = (props) => {

    const {value} = props;

    return (
        <div className="post-details">
            <h1>MIU</h1>
            <p>{value.id}</p>
            <p>{value.title}</p>
            <p>{value.author}</p>

            <div>
                <a>Edit</a>
                <a>Delete</a>
            </div>
        </div>
    );
};

export default PostDetails;
