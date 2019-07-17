import React from "react";

const Footer = () => {
  return (
      <div className='form-footer'>
          <ul className='no-list'>
              <li><a href="/auth/sign_in">Log in</a></li>
              <li><a href="/auth/confirmation/new">Didn&#39;t receive confirmation instructions?</a></li>
          </ul>
      </div>
  );
};

export default Footer;