import {
    ADD_USER_REGISTER_DATA,
    ADD_USER_LOGIN_DATA,
    ADD_AUTIFICATED_USER_DATA
} from "../constants/actionTypes";
import {initialState} from '../store';

const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_USER_REGISTER_DATA:
            return Object.assign({}, state, {
                auth: {
                    login: state.auth.login,
                    register: action.payload
                }
            });
        case ADD_USER_LOGIN_DATA:
            return Object.assign({}, state, {
                auth: {
                    login: action.payload,
                    register: state.auth.register
                }
            });
        case ADD_AUTIFICATED_USER_DATA:
            return Object.assign({}, state, {
               user: action.payload
            });
        default:
            return state;
    }
};

export default rootReducer;