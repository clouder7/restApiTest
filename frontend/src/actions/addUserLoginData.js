import {ADD_USER_LOGIN_DATA} from "../constants/actionTypes";

const addUserLoginData = payload => dispatch => {

    const action = {
        type: ADD_USER_LOGIN_DATA,
        payload: payload
    };
    //return action;
    dispatch(action);
};

export default addUserLoginData;