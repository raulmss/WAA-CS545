import { useEffect, useRef, useState } from "react";
import "./css/addPost.css"
import axios from "axios";

const AddPost = (props) => {
    // const [title, setTitle] = useState('');
    // const [author, setAuthor] = useState('');
    // const [content, setContent] = useState('');
    // const handleTitleChange = (e) => {
    //     setTitle(e.target.value);
    // };

    // const handleAuthorChange = (e) => {
    //     setAuthor(e.target.value);
    // };

    // const handleContentChange = (e) => {
    //     setContent(e.target.value);
    // };
    
    const clear = () => {
        titleRef.current.value = "";
        authorRef.current.value ="";
        contentRef.current.value = "";
    }

    const titleRef = useRef("");
    const authorRef = useRef("");
    const contentRef = useRef("");


    useEffect( ()=>{
        //This makes the field focus on the title input field
        titleRef.current?.focus();
    },[])


    //this is the calling of the function through the button
    const applyNewPost = () =>{
        props.addNewPost(titleRef.current.value, authorRef.current.value, contentRef.current.value);
        console.log("title is: ", titleRef.current.value)
        clear();

    }


    return (
        <>
            <h1>Add New Post!</h1>
            <div className="addingArea">
                <div className="inputs">
                    <div className="field">
                        <label htmlFor="title">Title</label>
                        <input id="title" type="text" ref={titleRef} placeholder="Title"></input>
                    </div>
                    <div className="field">
                        <label htmlFor="author">Author</label>
                        <input id="author" type="text" ref={authorRef} placeholder="Author"></input>
                    </div>
                    <div className="field">
                        <label htmlFor="content">Content</label>
                        <input type="text" ref={contentRef} placeholder="Content"></input>
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
