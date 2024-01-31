import React, {useState} from 'react';

function Counter() {
    const [count, setCount] = useState(0); //useState is a hook from react used to set and update a state. 
   //count is the value
   //setCount is the function to count's value.
    return (
        <div>
            <p>Count: {count}</p>
            <button onClick={() => setCount(count + 1)}>Add</button>
            <button onClick={() => setCount(count - 1)}>Subtract</button>
        </div>
    );
}
export default Counter;