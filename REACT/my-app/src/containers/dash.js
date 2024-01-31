import React, { useState, useEffect } from 'react';
import Posts from './Posts';
import './css/dash.css';
import PostDetails from './PostDetails';
import AddPost from '../components/AddPost';
import axios from 'axios';

const Dashboard = () => {
    const [text, setText] = React.useState('');
    const [valuePassed, setvaluePassed] = useState('') 
    const [postValue, setPostValue] = useState('');
    const [posts, setPosts] = useState([]);

    const handleChange = (event) => {
        setText(event.target.value);
    };

    const getInfo = (value) => {
        setPostValue(value);
    }

    const applyChange = (newtitle) =>{
        setvaluePassed(text);
    }

    const fetchPosts = ()=> {
        axios.get("http://localhost:8080/api/v1/posts")
        .then( response => {
            console.log("In fetch posts.")
            setPosts(response.data)
            
        })
        .catch(error =>{
            console.log(error.message)
        })
    }

    useEffect(() =>{
        fetchPosts();
    }, [])

    const deleteFunc = (id) =>{
        axios.delete(`http://localhost:8080/api/v1/posts/${id}`)
        .then(response =>{
            console.log(response.data);
            fetchPosts();
        })
        .catch(error =>{
            console.log(error);
        })
    };

        //this is the action of creating a new Post
        const addNewPost = (title, author, content) =>{ 
            console.log("in add post")
    
            axios.post('http://localhost:8080/api/v1/posts',{
                title:title,
                author:author,
                content:content
            })
            .then(response =>{
                console.log(response.data)
                fetchPosts();
            })
            .catch(error => {
                console.log(error.data)
            });
        }

 
    return (
        <div className="dashboard">
            <Posts posts ={posts} getInfos = {getInfo} value={valuePassed}/>

            <div className='update-area'>   
                <input type="text" value={text} onChange={handleChange} />
                <button onClick={applyChange} >Update Title</button>
            </div>

            <PostDetails 
            value = {postValue}
            deleteFunc = {deleteFunc}
            />

            <AddPost addNewPost ={addNewPost}/>
        </div>
    );
};

export default Dashboard;
