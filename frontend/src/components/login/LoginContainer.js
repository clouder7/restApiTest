import {connect} from "react-redux";
import Login from "./";
import addUserLoginData from "../../actions/addUserLoginData";

const mapStateToProps = state => ({
    email: state.auth.login.email,
    password: state.auth.login.password
});

const mapDispatchToProps = dispatch => ({
    addUserLoginData: async payload => dispatch(addUserLoginData(payload))
});

export default connect(mapStateToProps, mapDispatchToProps)(Login);