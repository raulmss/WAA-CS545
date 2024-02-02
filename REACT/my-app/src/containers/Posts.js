import React from 'react';
import Post from '../components/Post';

const Posts = (props) => {

    const {getInfos} = props;
    
    const postItems = props.posts.map(post => {
        return (
            <Post 
            key={post.id}
            id={post.id}
            title={post.title}
            author={post.author}
            onClick={() => getInfos(post)}
            />
        ) 
    });

    return <div>{postItems}</div>
          
}

export default Posts;