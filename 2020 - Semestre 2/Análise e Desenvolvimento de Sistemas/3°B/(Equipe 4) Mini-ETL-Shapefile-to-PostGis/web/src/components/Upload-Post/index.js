import React from 'react';
import Dropzone from 'react-dropzone';

import postStep2 from '../../assets/img/post-shape-new.png';


import "./styles.css";

function UploadPost() {
    return (
        <div className="post-step2-button">
        <form method="POST" enctype="multipart/form-data" action="/upload">
          <img src={postStep2} alt="Shape-Button" width="100%"/>
          <input type="submit" value="Upload"/>
          </form>
        </div>
    );
}

export default UploadPost;