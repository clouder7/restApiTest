import {ADD_AUTIFICATED_USER_DATA} from "../constants/actionTypes";

const addAutificatedUserData = (payload) => dispatch => {

    const action = {
        type: ADD_AUTIFICATED_USER_DATA,
        payload: payload
    };

    dispatch(action);
};

export default addAutificatedUserData;