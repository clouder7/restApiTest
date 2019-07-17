import {connect} from "react-redux";
import RegisterForm from "./RegisterForm";
import addUserRegisterData from "../../../actions/addUserRegisterData";

const mapActionsToProps = (dispatch) => ({
    addUserRegisterData: payload => dispatch(addUserRegisterData(payload))
});

const mapStateToProps = state => ({
    data: state.auth.register
});


export default connect(mapStateToProps, mapActionsToProps)(RegisterForm);