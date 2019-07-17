import {ADD_USER_REGISTER_DATA} from "../constants/actionTypes";

const addUserRegisterData = (payload) => dispatch => {

    const action = {
        type: ADD_USER_REGISTER_DATA,
        payload: payload
    };

    dispatch(action);
};

export default addUserRegisterData;