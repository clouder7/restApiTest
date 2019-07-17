import React from "react";

const Agreement = props => {
    return (
        <div className="input with_label boolean optional user_agreement">
            <div className="label_input">
                <label className="boolean optional" htmlFor="user_agreement">
                    I agree to the{" "}
                    <a href="/about/more" target="_blank">server rules</a>
                    {" "}and{" "}
                    <a href="/terms" target="_blank">terms of service</a>
                </label>
                <div className="label_input__wrapper">
                    <input value="0" type="hidden" name="user[agreement]"/>
                    <label className="checkbox">
                        <input className="boolean optional"
                               type="checkbox"
                               checked={props.agreement}
                               onChange={(e) => {
                                   props.toggle()
                               }}
                               name="agreement"
                               id="user_agreement"/>
                    </label>
                </div>
            </div>
        </div>
    );
};

export default Agreement;