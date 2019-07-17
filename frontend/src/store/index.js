import {createStore, applyMiddleware} from "redux";
import {composeWithDevTools} from "redux-devtools-extension";
import thunk from "redux-thunk";
import rootReducer from "../reducers";

export const initialState = {
    auth: {
        register: {
            email: '',
            password: '',
            confirmPassword: '',
            nickname: '',
            agreement: false
        },
        login: {
            email: '',
            password: ''
        }
    },
    user: {
        id: null,
        firstName: '',
        lastName: '',
        email: '',
        nickname: ''
    }
};

const middleware = [thunk];

const store = createStore(
    rootReducer,
    initialState,
    composeWithDevTools(applyMiddleware(...middleware))
);

export default store;


