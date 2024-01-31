import React, { useState } from 'react';
import Posts from './Posts';
import './css/dash.css';
import PostDetails from './PostDetails';

const Dashboard = () => {
    const [text, setText] = React.useState('');
    const [valuePassed, setvaluePassed] = useState('') 
    const [postValue, setPostValue] = useState('');

    const handleChange = (event) => {
        setText(event.target.value);
    };

    const getInfo = (value) => {
        setPostValue(value);
    }

    const applyChange = (newtitle) =>{
        setvaluePassed(text);
    }

    return (
        <div className="dashboard">
            <Posts getInfos = {getInfo} value={valuePassed}/>

            <div className='update-area'>   
                <input type="text" value={text} onChange={handleChange} />
                <button onClick={applyChange} >Update Title</button>
            </div>

            <PostDetails value = {postValue}/>
        </div>
    );
};

export default Dashboard;
