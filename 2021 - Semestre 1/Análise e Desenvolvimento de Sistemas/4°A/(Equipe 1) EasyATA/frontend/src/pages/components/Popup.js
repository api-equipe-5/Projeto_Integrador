import React from 'react'
import { useHistory } from "react-router-dom";
import "../../assets/css/popup.css"


function Popup(props){
    const history = useHistory();
    const navigateTo = () => history.push('/Index');

    return (props.trigger) ? (
        <div className="popup">
            <div className="popup-inner">
                { props.children }
                <button className="btn btn-sm btn-warning close-btn" onClick={() => {navigateTo(); props.setTrigger(false);}}>Fechar</button>
            </div>
        </div>
    ) : "";
}

export default Popup
