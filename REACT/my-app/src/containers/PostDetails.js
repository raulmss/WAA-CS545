import { useContext} from "react"
import "./css/PostDetails.css"
import { OnClickPostContext } from "../components/context/OnClickPostContext";


const PostDetails = (props) => {

    const {deleteFunc} = props;

    const value = useContext(OnClickPostContext);

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
