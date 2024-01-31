import React, { useEffect, useState } from 'react';
import Post from '../components/Post';

const Posts = (props) => {
    const [postsH, setPostsH] = useState( 
        [
            { id: 1, title: 'Post 1', author: 'Author 1' },
            { id: 2, title: 'Post 2', author: 'Author 2' },
            { id: 3, title: 'Post 3', author: 'Author 3' }
        ]
    );

    const {value, getInfos} = props;
    

    if(value){
        const updatedPostSH = [...postsH];
        updatedPostSH[0].title = value;
    }

   

    

    // const fetchPosts = ()=> {
    //     axios.get("endpoint")
    //     .then( response => {
    //         setPostsH(response.data)
    //     })
    //     .catch(error =>{
    //         console.log(error.message)
    //     })
    // }

    // useEffect(() =>{
    //     fetchPosts();
    // }, [flag])
    // if [] is empty, this is to happen ONLY when mounting component

    const postItems = postsH.map(post => {
        return (
            <Post onClick={() => getInfos(post)}
            key={post.id}
            id={post.id}
            title={post.title}
            author={post.author}
            />
        ) 
    });

    return <div>{postItems}</div>
          
}

export default Posts;