import React from "react";

const ErrorExplanation = props => {
    return (
        <div className='flash-message alert' id='error_explanation'>
            <strong>Something isn&#39;t quite right yet! Please review {props.count} errors
                below</strong>
        </div>
    );
}

export default ErrorExplanation;