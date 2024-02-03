import { useEffect, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./css/addPost.css"
import axios from "axios";

const AddPost = (props) => {
        
    const clear = () => {
        titleRef.current.value = "";
        authorRef.current.value ="";
        contentRef.current.value = "";
    }

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

    const titleRef = useRef("");
    const authorRef = useRef("");
    const contentRef = useRef("");


    useEffect( ()=>{
        titleRef.current?.focus();
    },[])

    const navigate = useNavigate();

    const applyNewPost = () =>{
        addNewPost(titleRef.current.value, authorRef.current.value, contentRef.current.value);
        console.log("title is: ", titleRef.current.value)
        navigate("/posts");
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
