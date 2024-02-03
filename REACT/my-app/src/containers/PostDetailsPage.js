import React, { useEffect, useState } from 'react';
import PostDetails from './PostDetails';
import { useParams } from 'react-router-dom';
import axios from 'axios';  

const PostDetailsPage = () => {
    // Your code for the PostDetailsPage component goes here
const {id} = useParams();
const [post, setPost] = useState({
    id: " loading...",
    title: "loading...",
    author: "loading..."
});

const fetchPost = (id)=> {
    axios.get("http://localhost:8080/api/v1/posts/"+id)
    .then( response => {
        console.log("In fetch post.")
        setPost(response.data)
        
    })
    .catch(error =>{
        console.log(error.message)
    })
}
useEffect(() => {
    fetchPost(id);
}, [id]);

    return (
        <div>
            <PostDetails value={post} />
        </div>
    );
};

export default PostDetailsPage;