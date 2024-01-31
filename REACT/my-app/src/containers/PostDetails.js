import { useState } from "react"
import "./css/PostDetails.css"
import axios from "axios";


const PostDetails = (props) => {

    const {value, deleteFunc} = props;


    const deleteAction =()=>{
        deleteFunc(value.id);

        clear();
    }
    
    const clear = () =>{
        value.id ='';
        value.title ='';
        value.author ='';
    }

    return (
        <div className="post-details">
            <h1>MIU</h1>
            <p>{value.id}</p>
            <p>{value.title}</p>
            <p>{value.author}</p>

            <div className="links">
                <a>Edit</a>
                <a id="delete" onClick={deleteAction}>Delete</a>
            </div>
        </div>
    );
};

export default PostDetails;
