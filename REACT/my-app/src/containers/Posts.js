import React from 'react';
import Post from '../components/Post';
import { useNavigate } from 'react-router-dom';

const Posts = (props) => {

    const { getInfos } = props;
    const navigate = useNavigate();

    const handlePostClick = (post) => {
        getInfos(post);
        navigate(`/posts/${post.id}`);
    };


   
    const postItems = props.posts.map(post => {
        return (
            <Post 
            key={post.id}
            id={post.id}
            title={post.title}
            author={post.author}
            onClick={() => handlePostClick(post)}
            />
        ) 
    });

    return <div>{postItems}</div>
}

export default Posts;