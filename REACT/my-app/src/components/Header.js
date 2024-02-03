import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
    return (
        <header style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', backgroundColor: 'grey', color: 'white' }}>
            <nav>
                <ul style={{ display: 'flex', listStyle: 'none' }}>
                    <li style={{ marginRight: '10px' }}>
                        <Link to="/posts">Posts</Link>
                    </li>
                    <li>
                        <Link to="/create-post">Create Post</Link>
                    </li>
                </ul>
            </nav>
        </header>
    );
};

export default Header;