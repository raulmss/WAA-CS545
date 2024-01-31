import { useState } from "react"
import "./css/PostDetails.css"
import axios from "axios";


const PostDetails = (props) => {

    const {value} = props;


    const deleteFunc = (id) =>{
        axios.delete(`http://localhost:8080/api/v1/posts/${id}`)
        .then(response =>{
            console.log(response.data);
            props.fetchPosts();
        })
        .catch(error =>{
            console.log(error);
        })
    };

    const deleteAction =()=>{
        deleteFunc(value.id);
        
    }

    return (
        <div className="post-details">
            <h1>MIU</h1>
            <p>{value.id}</p>
            <p>{value.title}</p>
            <p>{value.author}</p>

            <div className="links">
                <a>Edit</a>
                <a id="delete" onClick={deleteAction}>Delete</a>
            </div>
        </div>
    );
};

export default PostDetails;
