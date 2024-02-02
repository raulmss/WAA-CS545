import { useContext, useState } from 'react';
import './App.css';
import Dash from './containers/dash'
import { OnClickPostIdContext } from './components/context/OnClickPostIdContext';

function App() {
  const [onClickPostId, setonClickPostId] = useState('');

  const setClickPostId = (value) => {
    setonClickPostId(value);
  }

  return (
    <div className="App">
      <h3>Global ID: {onClickPostId}</h3>
      <OnClickPostIdContext.Provider value = {onClickPostId} >
        <Dash setClickPostId = {setClickPostId}/>
      </OnClickPostIdContext.Provider>
    </div>
  );
}

export default App;
