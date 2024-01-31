import React, { useEffect, useState } from 'react';
import Post from '../components/Post';
import axios from 'axios';

const Posts = (props) => {
    const [postsH, setPostsH] = useState( 
        [
            { id: 1, title: 'Post 1', author: 'Author 1' }
        ]
    );

    const {value, getInfos} = props;
    

    useEffect(() => {
        if(value){
            const updatedPostSH = [...postsH];
            updatedPostSH[0].title = value;
            setPostsH(updatedPostSH);
        }
    }, [value]);

    const fetchPosts = ()=> {
        axios.get("http://localhost:8080/api/v1/posts")
        .then( response => {
            console.log("In fetch posts.")
            setPostsH(response.data)
        })
        .catch(error =>{
            console.log(error.message)
        })
    }

    useEffect(() =>{
        fetchPosts();
    }, [])

    const postItems = postsH.map(post => {
        return (
            <Post 
            key={post.id}
            id={post.id}
            title={post.title}
            author={post.author}
            onClick={() => getInfos(post)}
            fetchPosts = {fetchPosts}
            />
        ) 
    });

    return <div>{postItems}</div>
          
}

export default Posts;