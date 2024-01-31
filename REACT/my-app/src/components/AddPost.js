import { useState } from "react";
import "./css/addPost.css"
import axios from "axios";

const AddPost = (props) => {
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



    //this is the calling of the function through the button
    const applyNewPost = () =>{
        props.addNewPost(title, author, content);
        clear();
    }

    const clear = () => {
        setTitle('');
        setAuthor('');
        setContent('');
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
