import { useContext, useState } from 'react';
import './App.css';
import Dash from './containers/dash'
import { OnClickPostIdContext } from './components/context/OnClickPostIdContext';
import { Route, Routes } from 'react-router-dom';
import Home from './containers/Home';
import Header from './components/Header';
import PostDetailsPage from './containers/PostDetailsPage';
import CreateNewPostPage from './containers/CreateNewPostPage';

function App() {
  const [onClickPostId, setonClickPostId] = useState('');

  const setClickPostId = (value) => {
    setonClickPostId(value);
  }

  return (
    <div className="App">
      <Header/>
      <OnClickPostIdContext.Provider value = {onClickPostId} >
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/posts" element={<Dash setClickPostId = {setClickPostId} />}/>
          <Route path="/posts/:id" element={<PostDetailsPage/>}/>
          <Route path="/create-post" element={<CreateNewPostPage/>}/>
        </Routes>
      </OnClickPostIdContext.Provider>
    </div>
  );
}

export default App;
