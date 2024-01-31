import { useState } from "react";
import "./css/addPost.css"
import axios from "axios";

const AddPost = () => {
    const [title, setTitle] = useState('');
    const [author, setAuthor] = useState('');
    const [content, setContent] = useState('');

    const handleTitleChange = (e) => {
        setTitle(e.target.value);
    };

    const handleAuthorChange = (e) => {
        setAuthor(e.target.value);
    };

    const handleContentChange = (e) => {
        setContent(e.target.value);
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
        })
        .catch(error => {
            console.log(error.data)
        });
    }

    //this is the calling of the function through the button
    const applyNewPost = () =>{
        addNewPost(title, author, content);
    }

    return (
        <>
            <h1>Add New Post!</h1>
            <div className="addingArea">
                <div className="inputs">
                    <div className="field">
                        <label htmlFor="title">Title</label>
                        <input id="title" type="text" value={title} onChange={handleTitleChange}></input>
                    </div>
                    <div className="field">
                        <label htmlFor="author">Author</label>
                        <input id="author" type="text" value={author} onChange={handleAuthorChange}></input>
                    </div>
                    <div className="field">
                        <label htmlFor="content">Content</label>
                        <input type="text" value={content} onChange={handleContentChange}></input>
                    </div>
                </div>
                <div className="addButton">
                    <button onClick={applyNewPost}>ADD</button>
                </div>
            </div>
        </>
    );
};

export default AddPost;
